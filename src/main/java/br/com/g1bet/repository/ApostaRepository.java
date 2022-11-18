package br.com.g1bet.repository;

import br.com.g1bet.model.Aposta;
import br.com.g1bet.model.TipoApostaEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Long> {
    List<Aposta> findByUsuarioId(Long id);

    List<Aposta> findAllByTipo(TipoApostaEnum tipoDeAposta);
}
