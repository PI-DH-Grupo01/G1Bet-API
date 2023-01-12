package br.com.g1bet.controller;

import br.com.g1bet.model.Partida;
import br.com.g1bet.repository.PartidaRepository;
import br.com.g1bet.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Partida> cadastrar(@RequestBody Partida partida, UriComponentsBuilder builder) {
        Partida cadastrarPartida = service.cadastrar(partida);
        URI uri = builder.path("/partidas/{id}").buildAndExpand(cadastrarPartida.getId()).toUri();

        return ResponseEntity.created(uri).body(cadastrarPartida);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deletar(id);
    }

    @PutMapping
    public ResponseEntity<Partida> put(@RequestBody Partida partidaModel) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(repository.save(partidaModel));
    }

}
