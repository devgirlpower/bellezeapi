package br.com.belezze.belezzeAPIREST.domain.cliente;

import br.com.belezze.belezzeAPIREST.domain.address.DataAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DataRecordClient(
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,
        @NotBlank
        String name,

        @NotBlank
        String cpf,

        @NotNull  String cep) {
}
