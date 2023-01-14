package br.com.g1bet.controller;

import br.com.g1bet.model.Time;
import br.com.g1bet.service.TimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Time> post(@RequestBody @Valid Time time) {
        return ResponseEntity.status(HttpStatus.CREATED).body(timeService.cadastrar(time));
    }

    @PutMapping
    public ResponseEntity<Time> put(@RequestBody @Valid Time time, Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(timeService.atualizar(time, id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        timeService.deletar(id);
    }

}
