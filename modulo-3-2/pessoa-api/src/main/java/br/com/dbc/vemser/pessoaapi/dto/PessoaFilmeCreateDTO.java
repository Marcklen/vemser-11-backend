package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaFilmeCreateDTO {

    @NotNull(message = "o ID do filme é obrigatório")
    @Schema(description = "Id do filme", example = "1")
    private Integer idFilme;
    @Past
    @Schema(description = "Data que o filme foi assistido", example = "2022-10-08")
    private LocalDate dataAssistido;

    @NotBlank(message = "O nome do filme é obrigatório")
    @Schema(description = "Descrição do filme assistido", example = "Filme muito bom")
    private String descricao;

    @NotNull(message = "A nota do filme é obrigatória")
    @Min(value = 0, message = "A nota deve ser maior ou igual a zero")
    @Max(value = 10, message = "A nota deve ser menor ou igual a dez")
    @Schema(description = "Nota do filme assistido", example = "8")
    private Integer notaPessoa;

}