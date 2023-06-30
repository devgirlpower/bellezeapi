package br.com.belezze.belezzeAPIREST.domain.reservacabelo.validation.cancelamentos;

import br.com.belezze.belezzeAPIREST.domain.ExceptionValidation;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.BookingCancellationData;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidatorAdvanceHourCancellation implements ValidatorCancellationReserve {

    @Autowired
    private ReserveRepository repository;

    @Override
    public void valid(BookingCancellationData data) {
        var tempoAgora = LocalDateTime.now();
        var reserve = repository.getReferenceById(data.idReserve());
        var diferenca = Duration.between(tempoAgora, reserve.getData()).toHours();

        if (diferenca < 24) {
            throw new ExceptionValidation("Reserva só pode ser cancelada até 24h antes.");
        }
    }
}
