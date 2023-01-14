package br.com.g1bet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    @Size(min = 5, max = 100)
    private String nome;

    @OneToMany(mappedBy = "timeCasa", cascade = CascadeType.ALL)
    @JsonIgnore
    @NotNull
    private List<Partida> partidasCasa;

    @OneToMany(mappedBy = "timeVisitante", cascade = CascadeType.ALL)
    @JsonIgnore
    @NotNull
    private List<Partida> partidasVisitante;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
