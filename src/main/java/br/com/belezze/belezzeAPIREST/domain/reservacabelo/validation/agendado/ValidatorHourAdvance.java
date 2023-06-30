package br.com.belezze.belezzeAPIREST.domain.reservacabelo.validation.agendado;

import br.com.belezze.belezzeAPIREST.domain.ExceptionValidation;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.BookingScheduleData;
import jakarta.xml.bind.ValidationException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidatorHourAdvance implements ReserveScheduleValidator {

    public void valid(BookingScheduleData data) {
        var dataAgendaReserva = data.data();
        var agora = LocalDateTime.now();
        var diferencaMinutos = Duration.between(agora, dataAgendaReserva).toMinutes();

        if (diferencaMinutos < 30) {
            throw new ExceptionValidation("Reserva deve ser feita no minímo 30 min antes do horário desejado.");
        }

    }
}
