package br.com.g1bet.dto.response;

import java.time.LocalDateTime;

public class PartidaResponse {
    private String timeCasa;
    private String timeVisitante;
    private LocalDateTime dataHora;
    private String resultado;

    public String getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(String timeCasa) {
        this.timeCasa = timeCasa;
    }

    public String getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(String timeVisitante) {
        this.timeVisitante = timeVisitante;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getResultado() {
        if (resultado == null) {
            return "Partida iniciará";
        }
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
