package br.com.g1bet.controller;

import br.com.g1bet.model.Usuario;
import br.com.g1bet.dto.request.UsuarioRequest;
import br.com.g1bet.dto.response.UsuarioResponse;
import br.com.g1bet.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrar(@RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.ok(service.cadastrar(usuarioRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.atualizar(usuario, id));
    }

}
