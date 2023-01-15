package br.com.g1bet.repository;

import br.com.g1bet.model.Partida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Long> {

    @Query(value = "SELECT p FROM Partida p WHERE p.timeCasa.id = ?1 OR p.timeVisitante.id = ?1")
    Page<Partida> findAllHistoricoPorTime(Long id, Pageable pageable);
}
