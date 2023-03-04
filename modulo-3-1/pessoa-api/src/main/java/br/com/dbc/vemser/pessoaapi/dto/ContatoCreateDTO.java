package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    private Integer idPessoa;

    @NotNull(message = "Tipo de contato não pode ser nulo")
    private TipoContato tipoContato;

    @NotNull(message = "Número não pode ser nulo")
    @Size(max = 13, message = "Número não pode ter mais de 13 caracteres")
    private String numero;

    @NotBlank(message = "Descrição não pode ser nula ou vazia")
    private String descricao;
}
