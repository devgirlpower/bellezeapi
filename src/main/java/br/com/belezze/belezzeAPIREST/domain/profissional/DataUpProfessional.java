package br.com.belezze.belezzeAPIREST.domain.profissional;

import br.com.belezze.belezzeAPIREST.domain.address.DataAddress;
import jakarta.validation.constraints.NotNull;

public record DataUpProfessional(
        @NotNull
        Long id,
        String name,
        String telefone,
        DataAddress address) {
}
