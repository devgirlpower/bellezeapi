package br.com.belezze.belezzeAPIREST.domain.reservacabelo;

import jakarta.validation.constraints.NotNull;

public record BookingCancellationData(
        @NotNull
        Long idReserve,
        @NotNull
        ReasonCancel reason) {
}
