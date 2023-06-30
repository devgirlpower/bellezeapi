package br.com.belezze.belezzeAPIREST.domain.reservacabelo.validation.agendado;

import br.com.belezze.belezzeAPIREST.domain.ExceptionValidation;
import br.com.belezze.belezzeAPIREST.domain.profissional.ProfessionalRepository;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.BookingScheduleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorProfessionalAtivo implements ReserveScheduleValidator {

    @Autowired
    private ProfessionalRepository repository;

    public void valid(BookingScheduleData data) {
        if (data.idProfessional() == null) {
            return;
        }
        var professionalAtivo = repository.findAtivoById(data.idProfessional());
        if (!professionalAtivo) {
            throw new ExceptionValidation("Reserva não pode ser feita, profissional excluído.");
        }
    }

}
