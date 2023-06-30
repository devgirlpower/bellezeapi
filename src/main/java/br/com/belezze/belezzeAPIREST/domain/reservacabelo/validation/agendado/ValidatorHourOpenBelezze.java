package br.com.belezze.belezzeAPIREST.domain.reservacabelo.validation.agendado;

import br.com.belezze.belezzeAPIREST.domain.ExceptionValidation;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.BookingScheduleData;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidatorHourOpenBelezze implements ReserveScheduleValidator {

    public void valid(BookingScheduleData data) {
        var diaReserva = data.data();
        var domingo = diaReserva.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = diaReserva.getHour() < 7;
        var depoisDeFechar = diaReserva.getHour() > 18;
        if (domingo || antesDaAbertura || depoisDeFechar) {
            throw new ExceptionValidation("Reserva fora de nossos horários de atendimento.");
        }

    }

}
