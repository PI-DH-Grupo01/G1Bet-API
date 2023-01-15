package br.com.g1bet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;

    private Long cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeNascimento;
    @Email
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private String chavePix;

    private Double saldoUsuario;

}
