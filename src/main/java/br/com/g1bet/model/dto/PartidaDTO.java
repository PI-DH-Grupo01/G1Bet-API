package br.com.g1bet.model.dto;

import br.com.g1bet.model.Time;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class PartidaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_time_visitante", referencedColumnName = "id")
    @NotNull
    private Time timeVisitante;

    @ManyToOne()
    @JoinColumn(name = "id_time_casa", referencedColumnName = "id")
    @NotNull
    private Time timeCasa;

    @NotNull
    @Size(min = 5, max = 20)
    private String resultado;

    @Column(name = "data_hora_partida")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dataHora;

    public PartidaDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(Time timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public Time getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(Time timeCasa) {
        this.timeCasa = timeCasa;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }



}
