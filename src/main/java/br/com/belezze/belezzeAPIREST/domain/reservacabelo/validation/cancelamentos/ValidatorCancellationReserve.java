package br.com.belezze.belezzeAPIREST.domain.reservacabelo.validation.cancelamentos;

import br.com.belezze.belezzeAPIREST.domain.reservacabelo.BookingCancellationData;

public interface ValidatorCancellationReserve {

    void valid(BookingCancellationData data);

}
