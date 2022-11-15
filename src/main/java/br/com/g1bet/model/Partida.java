package br.com.g1bet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "partidas")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_partida;

    @OneToMany(mappedBy = "partidas", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("partidas")
    private int id_timeA;

    @OneToMany(mappedBy = "partidas", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("partidas")
    private int id_timeB;

    @NotNull
    @Size(min = 5, max = 20)
    private String nome_partida;

    @NotNull
    @Size(min = 5, max = 20)
    private String resultado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data_hora_partida;


    public int getId_partida() {
        return id_partida;
    }
    public void setId_partida(int id_partida) {
        this.id_partida = id_partida;
    }

    public int getId_timeA() {
        return id_timeA;
    }

    public void setId_timeA(int id_timeA) {
        this.id_timeA = id_timeA;
    }

    public int getId_timeB() {
        return id_timeB;
    }

    public void setId_timeB(int id_timeB) {
        this.id_timeB = id_timeB;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getData_hora_partida() {
        return data_hora_partida;
    }

    public void setData_hora_partida(Date data_hora_partida) {
        this.data_hora_partida = data_hora_partida;
    }

    public String getNome_partida() { return nome_partida; }

    public void setNome_partida(String nome_partida) { this.nome_partida = nome_partida; }
}
