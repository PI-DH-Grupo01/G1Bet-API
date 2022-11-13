package br.com.g1bet.repository;

import br.com.g1bet.model.ApostaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApostaRepository extends JpaRepository <ApostaModel, Long> {
    public List<ApostaModel> findAllByApostaContainingIgnoreCase(String tipoDeAposta);
}
