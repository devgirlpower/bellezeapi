package br.com.belezze.belezzeAPIREST.domain.reservacabelo.validation.agendado;

import br.com.belezze.belezzeAPIREST.domain.ExceptionValidation;
import br.com.belezze.belezzeAPIREST.domain.cliente.ClientRepository;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.BookingScheduleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidatorClientActive implements ReserveScheduleValidator {

    @Autowired
    private ClientRepository repository;

    public void valid(BookingScheduleData dados) {
        var clientActive = repository.findAtivoById(dados.idClient());
        if (!clientActive) {
            throw new ExceptionValidation("Reserva não pode ser cadastrada, cliente foi excluído.");
        }
    }
}
