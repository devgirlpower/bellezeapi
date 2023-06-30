package br.com.belezze.belezzeAPIREST.domain.reservacabelo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {

    boolean existsByClientIdAndDataBetween(Long idClient, LocalDateTime primeiraHora, LocalDateTime ultimaHora);

    boolean existsByProfessionalIdAndDataAndReasonCancelIsNull(Long idProfissional, LocalDateTime data);
}
