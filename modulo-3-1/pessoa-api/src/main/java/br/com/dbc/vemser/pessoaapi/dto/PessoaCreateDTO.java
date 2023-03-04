package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @NotBlank(message = "O Nome não pode ser vazio nem nulo")
    private String nome;

    @NotNull(message = "A Data de Nascimento não pode ser vazia nem nula")
    @PastOrPresent(message = "A Data de Nascimento não pode ser futura")
    private LocalDate dataNascimento;

    @NotBlank(message = "O CPF não pode ser vazio nem nulo")
    @Length(min = 11, max = 11, message = "O CPF deve conter exatamente 11 caracteres")
    private String cpf;
}