package br.com.belezze.belezzeAPIREST.domain.profissional;


import br.com.belezze.belezzeAPIREST.domain.address.Address;

public record DataDetailProfessional(Long id, String cpf, String name, String email, String telefone, AreaAtuacao area, Address endereco) {

    public DataDetailProfessional(Professional professional) {
        this(professional.getId(), professional.getName(), professional.getEmail(), professional.getCpf(), professional.getTelefone(), professional.getArea(), professional.getAddress());
    }
}
