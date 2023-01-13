package br.com.g1bet.dto.response;

import br.com.g1bet.model.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

    private Long id;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;
    private String email;
    private Double saldoUsuario;

    public static UsuarioResponse toUsuarioResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getDataDeNascimento(),
                usuario.getEmail(),
                usuario.getSaldoUsuario()
        );
    }

}