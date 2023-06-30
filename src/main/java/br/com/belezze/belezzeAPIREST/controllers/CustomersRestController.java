package br.com.belezze.belezzeAPIREST.controllers;

import br.com.belezze.belezzeAPIREST.controllers.Mapper.ClientMapperWithCep;
import br.com.belezze.belezzeAPIREST.domain.address.Address;
import br.com.belezze.belezzeAPIREST.domain.cliente.*;
import br.com.belezze.belezzeAPIREST.integration.ViaCepIntegration;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clientes")
@SecurityRequirement(name = "bearer-key")
public class CustomersRestController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(UriComponentsBuilder uriBuilder, @RequestBody @Valid DataRecordClient data) throws Exception {
        Address address = ViaCepIntegration.integrationCep(data.cep());
        System.out.println("localidade:"+address.getLocalidade());
        Client client = ClientMapperWithCep.createClient(data,address);

        repository.save(client);

        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataDetailClient(client));
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var client = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailClient(client));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpClient data) {
        var client = repository.getReferenceById(data.id());
        client.upData(data);

        return ResponseEntity.ok(new DataDetailClient(client));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var client = repository.getReferenceById(id);
        client.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<DataListClient>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {
        var page2 = repository.findAllByAtivoTrue(page).map(DataListClient::new);
        return ResponseEntity.ok(page2);
    }



}
