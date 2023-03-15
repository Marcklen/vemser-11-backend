package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class PessoaFilmePK implements Serializable {

    @Column(name = "ID_PESSOA")
    private Integer idPessoa;

    @Column(name = "ID_FILME")
    private Integer idFilme;
}