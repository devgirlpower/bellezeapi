package br.com.belezze.belezzeAPIREST.domain.reservacabelo;

import br.com.belezze.belezzeAPIREST.domain.profissional.AreaAtuacao;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record BookingScheduleData(
        Long idProfessional,

        @NotNull
        Long idClient,

        @NotNull
        @Future
        LocalDateTime data,

        AreaAtuacao area) {
}
