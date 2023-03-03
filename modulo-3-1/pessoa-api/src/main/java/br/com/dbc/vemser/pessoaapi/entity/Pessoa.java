package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa {
    private Integer idPessoa;

    @NotBlank(message = "O Nome não pode ser vazio nem nulo")
    private String nome;

    @NotNull(message = "A Data de Nascimento não pode ser vazia nem nula")
    @PastOrPresent(message = "A Data de Nascimento não pode ser futura")
    private LocalDate dataNascimento;

    @NotBlank(message = "O CPF não pode ser vazio nem nulo")
    @Length(min = 11, max = 11, message = "O CPF deve conter exatamente 11 caracteres")
    private String cpf;
}