package br.com.dbc.vemser.pessoaapi.dto.in;

import br.com.dbc.vemser.pessoaapi.entity.enums.TipoFilme;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class FilmeCreateDTO {

        @NotBlank(message = "Nome/Descrição do Filme deve ser informado")
        @Schema(description = "Nome/Descrição do Filme", example = "Vingadores - Ultimato", required = true)
        private String descricao;

        @Min(value = 0, message = "Nota deve ser maior ou igual a 0")
        @Max(value = 10, message = "Nota deve ser menor ou igual a 10")
        @Schema(description = "Nota do Filme", example = "8", required = true)
        private Integer nota;

        @NotNull(message = "Tipo de Filme deve ser informado")
        @Schema(description = "Tipo de Filme", example = "AÇÃO ou ROMANCE", required = true)
        private TipoFilme tipoFilme;
}