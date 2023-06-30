package br.com.belezze.belezzeAPIREST.domain.cliente;

import br.com.belezze.belezzeAPIREST.domain.address.DataAddress;
import jakarta.validation.constraints.NotNull;

public record DataUpClient(
        @NotNull
        Long id,
        String name,
        String telefone,
        DataAddress address) {
}
