package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

@Data
public class PessoaDTO extends PessoaCreateDTO { // acrescentei o nome para também mostrar no postman

    private Integer id;
    private String nome; // depois retiro caso fique diferente dos demais ,
    // vou fazer o teste nao extendendo a classe PessoaCreateDTO
}