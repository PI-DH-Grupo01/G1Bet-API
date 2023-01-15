package br.com.g1bet.controller;

import br.com.g1bet.model.Partida;
import br.com.g1bet.repository.PartidaRepository;
import br.com.g1bet.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/partida")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PartidaController {

    @Autowired
    private PartidaService service;

    @Autowired
    private PartidaRepository repository;

    @GetMapping("/historico/{idTime}")
    public ResponseEntity<List<Partida>> exibirHistoricoPartida(@PathVariable Long idTime) {
        return ResponseEntity.ok(service.exibirHistoricoPartida(idTime));
    }

    @PostMapping
    public ResponseEntity<Partida> cadastrar(@RequestBody @Valid Partida partida) {
        return ResponseEntity.ok(service.cadastrar(partida));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping
    public ResponseEntity<Partida> put(@RequestBody @Valid Partida partidaModel) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(partidaModel));
    }

}
