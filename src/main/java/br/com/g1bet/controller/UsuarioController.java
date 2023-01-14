package br.com.g1bet.controller;

import br.com.g1bet.model.Usuario;
import br.com.g1bet.model.dto.UsuarioDTO;
import br.com.g1bet.model.dto.UsuarioResponse;
import br.com.g1bet.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(service.cadastrar(usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> atualizar(@RequestBody @Valid Usuario usuario, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.atualizar(usuario, id));
    }

}
