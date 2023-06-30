package br.com.belezze.belezzeAPIREST.domain.cliente;

public record DataListClient(Long id,String email, String cpf, String name) {

    public DataListClient(Client client) {
        this(client.getId(), client.getName(), client.getEmail(), client.getCpf());
    }

}
