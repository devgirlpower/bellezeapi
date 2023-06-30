package br.com.belezze.belezzeAPIREST.domain.cliente;

import br.com.belezze.belezzeAPIREST.domain.address.Address;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Clientes")
@Entity(name = "Client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private br.com.belezze.belezzeAPIREST.domain.address.Address Address;
    private Boolean ativo;


    public void upData(DataUpClient dados) {
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.address() != null) {
            this.Address.updateData(dados.address());
        }

    }

    public void delete() {
        this.ativo = false;
    }
}
