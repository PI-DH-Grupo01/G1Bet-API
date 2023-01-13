package br.com.g1bet.controller;

import br.com.g1bet.model.Aposta;
import br.com.g1bet.model.TipoApostaEnum;
import br.com.g1bet.dto.request.ApostaRequest;
import br.com.g1bet.dto.response.ApostaResponse;
import br.com.g1bet.service.ApostaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apostas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ApostaController {

    private final ApostaService service;

    public ApostaController(ApostaService apostaService) {
        this.service = apostaService;
    }

//    @GetMapping
//    public ResponseEntity<List<Aposta>> getAll() {
//        return (ResponseEntity<List<Aposta>>) service.findAll();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ApostaResponse> buscarId(@PathVariable Long id) {
        return service.buscarId(id);
    }

    @GetMapping("/tipo/{tipoDeAposta}")
    public ResponseEntity<List<Aposta>> buscarTipo(@PathVariable TipoApostaEnum tipoDeAposta) {
        return ResponseEntity.ok(service.buscarTipo(tipoDeAposta));
    }

    @PostMapping
    public ResponseEntity<Object> apostar(@RequestBody ApostaRequest apostaModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.apostar(apostaModel));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/historico/{id}")
    public ResponseEntity<List<ApostaResponse>> exibirHistorico(@PathVariable Long id) {
        return ResponseEntity.ok(service.exibirHistorico(id));
    }


}
