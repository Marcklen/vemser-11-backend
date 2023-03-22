package br.com.dbc.vemser.pessoaapi.dto.out;

import br.com.dbc.vemser.pessoaapi.dto.in.EnderecoCreateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {

    @Schema(description = "Id do Endereco com auto increment", example = "1", required = false)
    private Integer idEndereco;
}