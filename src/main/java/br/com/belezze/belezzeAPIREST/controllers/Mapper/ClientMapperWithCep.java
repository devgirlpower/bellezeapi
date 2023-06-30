package br.com.belezze.belezzeAPIREST.controllers.Mapper;

import br.com.belezze.belezzeAPIREST.domain.address.Address;
import br.com.belezze.belezzeAPIREST.domain.cliente.Client;
import br.com.belezze.belezzeAPIREST.domain.cliente.DataRecordClient;

public class ClientMapperWithCep {

    public static Client createClient(DataRecordClient data, Address address) {
       return Client.builder()
                .cpf(data.cpf())
               .ativo(true)
                .name(data.name())
                .telefone(data.telefone())
                .email(data.email())
                .Address(address)
                .build();
    }

}
