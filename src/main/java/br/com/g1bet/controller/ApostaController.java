package br.com.g1bet.controller;

import br.com.g1bet.model.Aposta;
import br.com.g1bet.repository.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apostas")
@CrossOrigin("*")
public class ApostaController {
    @Autowired
    private ApostaRepository repository;

    @GetMapping
    public ResponseEntity<List<Aposta>> GetAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id_partida}")
    public ResponseEntity<Aposta> GetById(@PathVariable Long id_partida) {
        return repository.findById(id_partida)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/aposta/{tipoDeAposta}")
    public ResponseEntity<List<Aposta>> GetByAposta(@PathVariable String tipoDeAposta){
        return ResponseEntity.ok(repository.findAllByApostaContainingIgnoreCase(tipoDeAposta));

    }

    @PostMapping
    public ResponseEntity<Aposta> post(@RequestBody Aposta apostaModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(apostaModel));
    }

    @PutMapping
    public ResponseEntity<Aposta> put(@RequestBody Aposta apostaModel) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(apostaModel));
    }

    @DeleteMapping("/{id_partida}")
    public void delete(@PathVariable Long id_partida) {
        repository.deleteById(id_partida);
    }



}
