package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

public enum TipoFilme {

    TERROR(0), ANIMACAO(1), DRAMA(2), COMEDIA(3), ROMANCE(4), SUSPENSE(5), FICCAO(6);

    private Integer tipo;

    TipoFilme(Integer tipo) { this.tipo = tipo; }
    public Integer getTipo() { return tipo; }

    public static TipoFilme tipoFilme(Integer tipo) {
        return Arrays.stream(TipoFilme.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
