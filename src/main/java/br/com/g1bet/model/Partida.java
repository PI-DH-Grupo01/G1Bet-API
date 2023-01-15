package br.com.g1bet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_time_visitante", referencedColumnName = "id")
    private Time timeVisitante;

    @ManyToOne()
    @JoinColumn(name = "id_time_casa", referencedColumnName = "id")
    private Time timeCasa;

    @NotNull
    @Size(min = 5, max = 20)
    private String resultado;

    @Column(name = "data_hora_partida")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataHora;
}
