package br.com.g1bet.service;

import br.com.g1bet.model.Aposta;
import br.com.g1bet.model.Partida;
import br.com.g1bet.model.TipoApostaEnum;
import br.com.g1bet.model.Usuario;
import br.com.g1bet.model.dto.ApostaDTO;
import br.com.g1bet.model.dto.ApostaResponse;
import br.com.g1bet.repository.ApostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApostaService {

    @Autowired
    private ApostaRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PartidaService partidaService;

    public Object findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<ApostaResponse> findById(Long id) {
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(ApostaResponse.toApostaResponse(resp)))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Aposta>> findAllByTipo(TipoApostaEnum tipoDeAposta) {
        return ResponseEntity.ok(repository.findAllByTipo(tipoDeAposta));
    }

    public ApostaResponse save(ApostaDTO apostaDTO) {
        Usuario usuario = usuarioService.findById(apostaDTO.getUsuario());

        if (usuario.getSaldoUsuario() < apostaDTO.getValorApostado()) {
            throw new IllegalArgumentException("Valor inválido");
        }

        Partida partida = partidaService.findById(apostaDTO.getPartida());

        Aposta aposta = new Aposta();
        aposta.setTipo(apostaDTO.getTipo());
        aposta.setUsuario(usuario);
        aposta.setPartida(partida);
        aposta.setValorApostado(apostaDTO.getValorApostado());

        aposta = repository.save(aposta);
        return ApostaResponse.toApostaResponse(aposta);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Aposta> exibirHistorico(Long idUsuario) {
        return repository.findByUsuarioId(idUsuario);
    }

}
