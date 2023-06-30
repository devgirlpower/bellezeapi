package br.com.belezze.belezzeAPIREST.domain.cliente;


import br.com.belezze.belezzeAPIREST.domain.address.Address;

public record DataDetailClient(Long id, String name, String email, String cpf, String telefone, Address address) {

    public DataDetailClient(Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getCpf(), client.getTelefone(), client.getAddress());
    }
}
