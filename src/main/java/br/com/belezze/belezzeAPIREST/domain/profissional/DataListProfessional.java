package br.com.belezze.belezzeAPIREST.domain.profissional;

public record DataListProfessional(Long id, String name, String email, String cpf, AreaAtuacao area) {
    public DataListProfessional(Professional professional) {
        this(professional.getId(), professional.getName(), professional.getEmail(), professional.getCpf(), professional.getArea());
    }

}
