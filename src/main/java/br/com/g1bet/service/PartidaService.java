package br.com.g1bet.service;

import br.com.g1bet.mapper.exceptions.IdNaoExisteException;
import br.com.g1bet.model.Partida;
import br.com.g1bet.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository repository;

    public List<Partida> exibirHistoricoPartida(Long idTime) {
        List<Partida> visitantes = repository.findAllByTimeVisitante_Id(idTime);
        List<Partida> casa = repository.findAllByTimeCasa_Id(idTime);
        visitantes.addAll(casa);
        return visitantes;
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
