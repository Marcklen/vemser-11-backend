package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RelatorioPessoaCompletoDTO {

    private Integer idPessoa; // referente a pessoa
    private String nome; // referente a pessoa
    private String email; // referente a pessoa

    private String numero; // referente a contato

    private String cep; // referente a endereco
    private String cidade; // referente a endereco
    private String estado; // referente a endereco
    private String pais; // referente a endereco

    private String nomePet; // referente a pet

    private String descricaoFilme; // referente a filme
    private Integer notaFilme; // referente a filme

    private String descricaoPessoa; // referente a pessoa x filme
    private Integer notaPessoa; // referente a pessoa x filme
    private LocalDate dataAssistido; // referente a pessoa x filme
}