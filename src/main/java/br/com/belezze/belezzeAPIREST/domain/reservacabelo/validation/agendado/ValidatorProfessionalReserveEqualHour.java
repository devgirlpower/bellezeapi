package br.com.belezze.belezzeAPIREST.domain.reservacabelo.validation.agendado;

import br.com.belezze.belezzeAPIREST.domain.ExceptionValidation;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.BookingScheduleData;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorProfessionalReserveEqualHour implements ReserveScheduleValidator {

    @Autowired
    private ReserveRepository repository;

    public void valid(BookingScheduleData data) {
        var professionalIndisponivel = repository.existsByProfessionalIdAndDataAndReasonCancelIsNull(data.idProfessional(), data.data());
        if (professionalIndisponivel) {
            throw new ExceptionValidation("Professional possui outra reserva neste horário.");
        }
    }

}
