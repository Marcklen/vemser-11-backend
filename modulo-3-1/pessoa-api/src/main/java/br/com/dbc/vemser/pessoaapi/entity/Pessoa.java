package br.com.dbc.vemser.pessoaapi.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDate;

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

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa, String nome, LocalDate dataNascimento, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
