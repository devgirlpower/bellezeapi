package br.com.belezze.belezzeAPIREST.domain.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAddress(
        @NotBlank
        String logradouro,
        @NotBlank
        String localidade,
        @NotBlank
        String uf,
        String complemento,
        String num,
        @NotBlank
        String bairro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep) {
}
