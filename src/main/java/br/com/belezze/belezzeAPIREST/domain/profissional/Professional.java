package br.com.belezze.belezzeAPIREST.domain.profissional;

import br.com.belezze.belezzeAPIREST.domain.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Profissionais")
@Entity(name = "Professional")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professional {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private AreaAtuacao area;
    @Embedded
    private Address address;
    private Boolean ativo;

    public Professional(DataRegisterProfessional data) {
        this.ativo = true;
        this.telefone = data.telefone();
        this.cpf = data.cpf();
        this.name = data.name();
        this.email = data.email();
        this.area = data.area();
        this.address = new Address(data.address());
    }

    public void upData(DataUpProfessional data) {
        if (data.telefone() != null) {
            this.telefone = data.telefone();
        }
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.address() != null) {
            this.address.updateData(data.address());
        }

    }

    public void delete() {
        this.ativo = false;
    }
}
