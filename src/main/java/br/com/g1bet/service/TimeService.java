package br.com.g1bet.service;

import br.com.g1bet.mapper.exceptions.CampoExistenteException;
import br.com.g1bet.mapper.exceptions.IdNaoExisteException;
import br.com.g1bet.model.Time;
import br.com.g1bet.repository.TimeRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public List<Time> buscarTodosTimes() {
        return timeRepository.findAll();
    }

    public Time buscarId(Long id) {
        return timeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Time cadastrar(Time time) {
        if (timeRepository.existsByNome(time.getNome())) {
            throw new CampoExistenteException("Esse time já está cadastrado");
        }
        return timeRepository.save(time);
    }

    public Time findById(Long id) {
        return timeRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Id " + id, "Time não encontrado"));
    }

    public Time atualizar(Time time, Long id) {
        Time atualizar = findById(id);
        atualizar.setNome(time.getNome());
        return timeRepository.save(atualizar);
    }

    public void deletar(Long id) {
        Optional<Time> time = timeRepository.findById(id);
        if (time.isPresent()) {
            timeRepository.deleteById(id);
        }
        time.orElseThrow(() -> new IdNaoExisteException("Id nao existe"));
    }
}
