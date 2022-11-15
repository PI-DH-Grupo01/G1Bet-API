package br.com.g1bet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Aposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAposta;

    @OneToMany(mappedBy = "apostas", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("apostas")
    private Long idUsuario;

    @OneToMany(mappedBy = "apostas", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("apostas")
    private Long idPartida;

    @NotNull
    @Size(min = 5, max = 20)
    private String tipoDeAposta;

    @NotNull
    private float valorApostado;

    public Aposta() {

    }

    public Long getIdAposta() {
        return idAposta;
    }

    public void setIdAposta(Long idAposta) {
        this.idAposta = idAposta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Long idPartida) {
        this.idPartida = idPartida;
    }

    public String getTipoDeAposta() {
        return tipoDeAposta;
    }

    public void setTipoDeAposta(String tipoDeAposta) {
        this.tipoDeAposta = tipoDeAposta;
    }

    public float getValorApostado() {
        return valorApostado;
    }

    public void setValorApostado(float valorApostado) {
        this.valorApostado = valorApostado;
    }
}

