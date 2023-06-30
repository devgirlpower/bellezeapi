package br.com.belezze.belezzeAPIREST.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private String logradouro;
    private String bairro;
    private String cep;
    private String num;
    private String complemento;
    private String localidade;
    private String uf;

    public Address(DataAddress data) {
        this.logradouro = data.logradouro();
        this.bairro = data.bairro();
        this.cep = data.cep();
        this.uf = data.uf();
        this.localidade = data.localidade();
        this.num = data.num();
        this.complemento = data.complemento();
    }

    public void updateData(DataAddress data) {
        if (data.cep() != null) {
            this.cep = data.cep();
        }
        if (data.uf() != null) {
            this.uf = data.uf();
        }
        if (data.logradouro() != null) {
            this.logradouro = data.logradouro();
        }
        if (data.bairro() != null) {
            this.bairro = data.bairro();
        }
        if (data.localidade() != null) {
            this.localidade = data.localidade();
        }
        if (data.num() != null) {
            this.num = data.num();
        }
        if (data.complemento() != null) {
            this.complemento = data.complemento();
        }
    }
}
