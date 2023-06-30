package br.com.belezze.belezzeAPIREST.domain.profissional;

import br.com.belezze.belezzeAPIREST.domain.address.DataAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataRegisterProfessional(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        String cpf,
        @NotNull
        AreaAtuacao area,
        @NotNull @Valid DataAddress address) {
}
