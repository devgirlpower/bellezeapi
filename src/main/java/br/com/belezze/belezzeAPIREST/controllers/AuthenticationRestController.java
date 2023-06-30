package br.com.belezze.belezzeAPIREST.controllers;

import br.com.belezze.belezzeAPIREST.config.security.DataJWTToken;
import br.com.belezze.belezzeAPIREST.config.security.TokenService;
import br.com.belezze.belezzeAPIREST.domain.user.DataAuthentication;
import br.com.belezze.belezzeAPIREST.domain.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationRestController {


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity performLogin(@RequestBody @Valid DataAuthentication data) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.createToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new DataJWTToken(tokenJWT));
    }


}
