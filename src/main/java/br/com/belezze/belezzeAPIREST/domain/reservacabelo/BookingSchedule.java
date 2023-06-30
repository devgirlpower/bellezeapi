package br.com.belezze.belezzeAPIREST.domain.reservacabelo;

import br.com.belezze.belezzeAPIREST.domain.ExceptionValidation;
import br.com.belezze.belezzeAPIREST.domain.cliente.ClientRepository;
import br.com.belezze.belezzeAPIREST.domain.profissional.Professional;
import br.com.belezze.belezzeAPIREST.domain.profissional.ProfessionalRepository;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.validation.agendado.ReserveScheduleValidator;
import br.com.belezze.belezzeAPIREST.domain.reservacabelo.validation.cancelamentos.ValidatorCancellationReserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingSchedule {

    @Autowired
    private ReserveRepository reserveRepository;
    @Autowired
    private List<ReserveScheduleValidator> validators;
    @Autowired
    private List<ValidatorCancellationReserve> validatorsCancel;
    @Autowired
    private ProfessionalRepository professionalRepository;
    @Autowired
    private ClientRepository clientRepository;

    public DataDetailReserve toSchedule(BookingScheduleData data) {
        if (!clientRepository.existsById(data.idClient())) {
            throw new ExceptionValidation("O id do cliente não foi encontrado na base de dados.");
        }

        if (data.idProfessional() != null && !professionalRepository.existsById(data.idProfessional())) {
            throw new ExceptionValidation("Id do professional não foi encontrado na base de dados.");
        }

        validators.forEach(v -> v.valid(data));

        var client = clientRepository.getReferenceById(data.idClient());
        var professional = selectProfissional(data);

        if (professional == null) {
            throw new ExceptionValidation("Não tem profissional disponível nesta data.");
        }

        var reserve = new Reserve(null, professional, client, data.data(), null);
        reserveRepository.save(reserve);

        return new DataDetailReserve(reserve);
    }

    public void cancel(BookingCancellationData data) {
        if (!reserveRepository.existsById(data.idReserve())) {
            throw new ExceptionValidation("Id de reserva não existe.");
        }

        validatorsCancel.forEach(v -> v.valid(data));

        var reserve = reserveRepository.getReferenceById(data.idReserve());
        reserve.cancel(data.reason());
    }


    private Professional selectProfissional(BookingScheduleData data) {
        if (data.idProfessional() != null) {
            return professionalRepository.getReferenceById(data.idProfessional());
        }

        if (data.area() == null) {
            throw new ExceptionValidation("área é obrigatório quando profissional não selecionado.");
        }

        return professionalRepository.selecionaProfissionalAleatorioLivreData(data.area(), data.data());
    }

}
