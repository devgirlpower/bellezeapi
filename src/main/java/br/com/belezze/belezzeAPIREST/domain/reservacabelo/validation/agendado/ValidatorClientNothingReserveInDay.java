package br.com.belezze.belezzeAPIREST.domain.reservacabelo.validation.agendado;

import br.com.belezze.belezzeAPIREST.domain.ExceptionValidation;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.BookingScheduleData;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorClientNothingReserveInDay implements ReserveScheduleValidator {

    @Autowired
    private ReserveRepository repository;

    public void valid(BookingScheduleData dados) {
        var last = dados.data().withHour(18);
        var first = dados.data().withHour(7);
        var clientHaveReserve = repository.existsByClientIdAndDataBetween(dados.idClient(), first, last);
        if (clientHaveReserve) {
            throw new ExceptionValidation("Cliente já tem reserva no dia.");
        }
    }

}
