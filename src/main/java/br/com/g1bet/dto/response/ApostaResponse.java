package br.com.g1bet.dto.response;

import br.com.g1bet.model.Aposta;
import br.com.g1bet.model.TipoApostaEnum;

import java.text.DecimalFormat;

public class ApostaResponse {
    private Long id;
    private String usuario;
    private PartidaResponse partida;
    private TipoApostaEnum tipoApostaEnum;
    private Double valor;
    private Double odd;
    private String possivelRetorno;
    private static final DecimalFormat df = new DecimalFormat("R$ 0.00");
    private static final DecimalFormat df2 = new DecimalFormat("0.00");

    public static ApostaResponse toApostaResponse(Aposta aposta) {
        PartidaResponse partidaResponse = new PartidaResponse();
        partidaResponse.setResultado(aposta.getPartida().getResultado());
        partidaResponse.setDataHora(aposta.getPartida().getDataHora());
        partidaResponse.setTimeCasa(aposta.getPartida().getTimeCasa().getNome());
        partidaResponse.setTimeVisitante(aposta.getPartida().getTimeVisitante().getNome());
        return new ApostaResponse(
                aposta.getId(),
                aposta.getUsuario().getNome(),
                partidaResponse,
                aposta.getTipo(),
                aposta.getValorApostado(),
                aposta.getOdd(),
                df.format(aposta.getOdd() * aposta.getValorApostado())
        );
    }

    public ApostaResponse(Long id, String usuario, PartidaResponse partida,
                          TipoApostaEnum tipoApostaEnum, Double valor, Double odd, String possivelRetorno) {
        this.id = id;
        this.usuario = usuario;
        this.partida = partida;
        this.tipoApostaEnum = tipoApostaEnum;
        this.valor = valor;
        this.odd = odd;
        this.possivelRetorno = possivelRetorno;
    }

    public ApostaResponse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public PartidaResponse getPartida() {
        return partida;
    }

    public void setPartida(PartidaResponse partida) {
        this.partida = partida;
    }

    public TipoApostaEnum getTipoApostaEnum() {
        return tipoApostaEnum;
    }

    public void setTipoApostaEnum(TipoApostaEnum tipoApostaEnum) {
        this.tipoApostaEnum = tipoApostaEnum;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getOdd() {
        return df2.format(odd);
    }

    public void setOdd(Double odd) {
        this.odd = odd;
    }

    public String getPossivelRetorno() {
        return possivelRetorno;
    }

    public void setPossivelRetorno(String possivelRetorno) {
        this.possivelRetorno = possivelRetorno;
    }
}
