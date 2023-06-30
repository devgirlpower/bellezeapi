package br.com.belezze.belezzeAPIREST.config.security;

import br.com.belezze.belezzeAPIREST.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;


    public String getSubject(String tokenJWT) {
        try {
            var resultALgorithm = Algorithm.HMAC256(secret);
            return JWT.require(resultALgorithm)
                    .withIssuer("API belleze")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido/expirado.");
        }
    }

    public String createToken(User user) {
        try {
            var resultAlgorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API belleze")
                    .withSubject(user.getLogin())
                    .withExpiresAt(expiration())
                    .sign(resultAlgorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao criar token jwt.", exception);
        }
    }

    private Instant expiration() {
        return LocalDateTime.now().plusHours(5).toInstant(ZoneOffset.of("-03:00"));
    }

}
