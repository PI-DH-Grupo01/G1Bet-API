package br.com.g1bet.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PartidaResponse {
    private String timeCasa;
    private String timeVisitante;
    private LocalDateTime dataHora;
    private String resultado;

    public String getResultado() {
        if (resultado == null) {
            return "Partida iniciará";
        }
        return resultado;
    }
}
