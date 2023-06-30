package br.com.belezze.belezzeAPIREST.controllers;

import br.com.belezze.belezzeAPIREST.domain.profissional.*;
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
@RequestMapping("profissional")
@SecurityRequirement(name = "bearer-key")
public class ProfessionalRestController {

    @Autowired
    private ProfessionalRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity register(UriComponentsBuilder uriBuilder, @RequestBody @Valid DataRegisterProfessional data) {
        var professional = new Professional(data);
        repository.save(professional);

        var uri = uriBuilder.path("/profissional/{id}").buildAndExpand(professional.getId()).toUri();

        return ResponseEntity.created(uri).body(new DataDetailProfessional(professional));
    }
    @GetMapping
    public ResponseEntity<Page<DataListProfessional>> list(@PageableDefault(size = 15, sort = {"name"}) Pageable page) {
        var page2 = repository.findAllByAtivoTrue(page).map(DataListProfessional::new);
        return ResponseEntity.ok(page2);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var professional = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataDetailProfessional(professional));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var professional = repository.getReferenceById(id);
        professional.delete();

        return ResponseEntity.noContent().build();
    }
    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DataUpProfessional data) {
        var professional = repository.getReferenceById(data.id());
        professional.upData(data);

        return ResponseEntity.ok(new DataDetailProfessional(professional));
    }




}
