package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PessoaFilmeDTO extends PessoaFilmeCreateDTO {

    @Schema(description = "Id da pessoa", example = "1")
    private Integer idPessoa;
}