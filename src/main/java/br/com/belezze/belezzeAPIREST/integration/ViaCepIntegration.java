package br.com.belezze.belezzeAPIREST.integration;

import br.com.belezze.belezzeAPIREST.domain.address.Address;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public abstract class ViaCepIntegration {
    public static Address integrationCep(String cep) throws Exception {
        String test = "https://viacep.com.br/ws/"+cep+"/json/";


        URL url = new URL(test);
        URLConnection connection = url.openConnection();
        InputStream input = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input,"UTF-8"));


        String cep2;
        StringBuilder jsoncep = new StringBuilder();
        while((cep2 = reader.readLine()) != null) {
            jsoncep.append(cep2);
        }
        Address address = new Gson().fromJson(jsoncep.toString(), Address.class);
        return Address.builder()
                .uf(address.getUf())
                .logradouro(address.getLogradouro())
                .bairro(address.getBairro())
                .cep(address.getCep())
                .complemento(address.getComplemento())
                .localidade(address.getLocalidade())
                .build();


    }
}
