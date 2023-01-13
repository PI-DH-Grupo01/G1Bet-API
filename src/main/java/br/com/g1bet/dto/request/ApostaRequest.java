package br.com.g1bet.dto.request;

import br.com.g1bet.model.TipoApostaEnum;

public class ApostaRequest {

    private Long usuario;
    private Long partida;
    private TipoApostaEnum tipo;
    private Double ValorApostado;
    private Double possivelRetorno;

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getPartida() {
        return partida;
    }

    public void setPartida(Long partida) {
        this.partida = partida;
    }

    public TipoApostaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoApostaEnum tipo) {
        this.tipo = tipo;
    }

    public Double getValorApostado() {
        return ValorApostado;
    }

    public void setValorApostado(Double valorApostado) {
        ValorApostado = valorApostado;
    }

    public Double getPossivelRetorno() {
        return possivelRetorno;
    }

    public void setPossivelRetorno(Double possivelRetorno) {
        this.possivelRetorno = possivelRetorno;
    }

}
