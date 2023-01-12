package br.com.g1bet.controller;

import br.com.g1bet.model.Time;
import br.com.g1bet.service.TimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/times")
@CrossOrigin("*")
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping
    public ResponseEntity<List<Time>> buscarTodosTimes() {
        return ResponseEntity.ok(timeService.buscarTodosTimes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> buscarId(@PathVariable Long id) {
        return ResponseEntity.ok(timeService.buscarId(id));
    }

//    @GetMapping("/{time}")
//    public ResponseEntity<List<Time>> getByTime(@PathVariable String nome) {
//        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
//    }

    @PostMapping
    public ResponseEntity<Time> post(@RequestBody Time time, UriComponentsBuilder builder) {
        Time cadastrarTime = timeService.cadastrar(time);
        URI uri = builder.path("/times/{id}").buildAndExpand(cadastrarTime.getId()).toUri();

        return ResponseEntity.created(uri).body(cadastrarTime);
    }

    @PutMapping
    public ResponseEntity<Time> put(@RequestBody Time time, Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(timeService.atualizar(time, id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        timeService.deletar(id);
    }

}
