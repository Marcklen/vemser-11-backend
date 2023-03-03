package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contato {
    private Integer idContato;
    private Integer idPessoa;

    @NotNull(message = "Tipo de contato não pode ser nulo")
    private TipoContato tipoContato;

    @NotNull(message = "Número não pode ser nulo")
    @Size(max = 13, message = "Número não pode ter mais de 13 caracteres")
    private String numero;

    @NotBlank(message = "Descrição não pode ser nula ou vazia")
    private String descricao;
}