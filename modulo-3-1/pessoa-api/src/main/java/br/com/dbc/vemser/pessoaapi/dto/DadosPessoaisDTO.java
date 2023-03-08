package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DadosPessoaisDTO {

    @Schema(description = "Nome", example = "Fulano", required = true)
    private String nome;

    @Schema(description = "CPF", example = "52478956325", required = true)
    private String cpf;

    @Schema(description = "RG", example = "12345678910", required = true)
    private String rg;

    @Schema(description = "CNH", example = "9876543210", required = true)
    private String cnh;

    @Schema(description = "Nome da Mãe", example = "Mãe do Fulano", required = true)
    private String nomeMae;

    @Schema(description = "Nome do Pai", example = "Seu Fulano pai", required = true)
    private String nomePai;

    @Schema(description = "Titulo", example = "0123456789102", required = true)
    private String tituloEleitor;

    @Schema(description = "Sexo", example = "F para Feminino", required = true)
    private Sexo sexo;
}