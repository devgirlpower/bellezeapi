package br.com.belezze.belezzeAPIREST.domain.reservacabelo;

import java.time.LocalDateTime;

public record DataDetailReserve(Long id, Long idProfissional, Long idClient, LocalDateTime data) {
    public DataDetailReserve(Reserve reserve) {
        this(reserve.getId(), reserve.getProfessional().getId(), reserve.getClient().getId(), reserve.getData());
    }
}
