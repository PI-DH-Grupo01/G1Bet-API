package br.com.g1bet.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Aposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_partida")
    private Partida partida;

    @NotNull
    @Column(name = "tipo_de_aposta")
    @Enumerated(EnumType.STRING)
    private TipoApostaEnum tipo;

    @NotNull
    private Double valorApostado;

    @NotNull
    private Double odd = Math.random() * 5;

    public Aposta() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public TipoApostaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoApostaEnum tipo) {
        this.tipo = tipo;
    }

    public Double getValorApostado() {
        return valorApostado;
    }

    public void setValorApostado(Double valorApostado) {
        this.valorApostado = valorApostado;
    }

    public Double getOdd() {
        return arredondarParaDuasCasas(odd);
    }

    public static Double arredondarParaDuasCasas(double d) {
        return ((long) (d < 0 ? d * 100 - 0.5 : d * 100 + 0.5)) / 100.0;
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }

}

