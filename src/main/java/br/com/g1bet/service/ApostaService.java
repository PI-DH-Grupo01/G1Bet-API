package br.com.g1bet.service;

import br.com.g1bet.exceptions.SaldoInsuficienteException;
import br.com.g1bet.model.Aposta;
import br.com.g1bet.model.Partida;
import br.com.g1bet.model.TipoApostaEnum;
import br.com.g1bet.model.Usuario;
import br.com.g1bet.dto.request.ApostaRequest;
import br.com.g1bet.dto.response.ApostaResponse;
import br.com.g1bet.repository.ApostaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApostaService {

    private final ApostaRepository repository;
    private final UsuarioService usuarioService;
    private final PartidaService partidaService;

    public ApostaService(ApostaRepository repository, UsuarioService usuarioService, PartidaService partidaService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.partidaService = partidaService;
    }

    public ResponseEntity<ApostaResponse> buscarId(Long id) {
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(ApostaResponse.toApostaResponse(resp)))
                .orElse(ResponseEntity.notFound().build());
    }

    public List<Aposta> buscarTipo(TipoApostaEnum tipoDeAposta) {
        return repository.findAllByTipo(tipoDeAposta);
    }

    public ApostaResponse apostar(ApostaRequest apostaRequest) {
        Usuario usuario = usuarioService.buscar(apostaRequest.getUsuario());

        if (usuario.getSaldoUsuario() < apostaRequest.getValorApostado()) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        Partida partida = partidaService.findById(apostaRequest.getPartida());

        Aposta aposta = new Aposta();
        aposta.setTipo(apostaRequest.getTipo());
        aposta.setUsuario(usuario);
        aposta.setPartida(partida);
        aposta.setValorApostado(apostaRequest.getValorApostado());

        aposta = repository.save(aposta);
        return ApostaResponse.toApostaResponse(aposta);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<ApostaResponse> exibirHistorico(Long id) {
        return repository.findByUsuarioId(id).stream().map(aposta -> ApostaResponse.toApostaResponse(aposta)).toList();
    }

}
