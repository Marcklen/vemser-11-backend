package br.com.dbc.vemser.pessoaapi.dto.in;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UsuarioCreateDTO {

    @NotNull
    private String login;
    @NotNull
    private String senha;
}