package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {

    private Integer idPessoa;

    @NotNull(message = "Tipo de endereço não pode ser nulo")
    private TipoEndereco tipo;

    @NotEmpty(message = "Logradouro não pode ser vazio")
    @Size(max = 250, message = "Logradouro não pode ter mais de 250 caracteres")
    private String logradouro;

    @NotNull(message = "Número não pode ser nulo")
    private Integer numero;

    private String complemento;

    @NotBlank(message = "CEP não pode ser vazio")
    @Size(min = 8, max = 8, message = "CEP não pode ter mais de 8 caracteres")
    private String cep;

    @NotBlank(message = "CEP não pode ser vazio")
    @Size(max = 250, message = "Cidade não pode ter mais de 250 caracteres")
    private String cidade;

    @NotNull(message = "Estado não pode ser nulo")
    private String estado;

    @NotNull(message = "País não pode ser nulo")
    private String pais;
}
