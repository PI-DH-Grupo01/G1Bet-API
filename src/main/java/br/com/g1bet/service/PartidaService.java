package br.com.g1bet.service;

import br.com.g1bet.exceptions.IdNaoExisteException;
import br.com.g1bet.model.Partida;
import br.com.g1bet.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository repository;

    public Page<Partida> exibirHistoricoPartida(Long idTime, Pageable pageable) {
        return repository.findAllHistoricoPorTime(idTime, pageable);
    }

    public Partida findById(Long id) {
        Partida partida = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Partida não encontrada"));
        return partida;
    }

    public Partida cadastrar(Partida partida) {
        return repository.save(partida);
    }

    public void deletar(Long id) {
        Optional<Partida> partida = repository.findById(id);

        if (!partida.isPresent()) {
            throw new IdNaoExisteException("Id não encontrado");
        }
        repository.deleteById(id);
    }

}
