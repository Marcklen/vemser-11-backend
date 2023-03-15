package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

public enum TipoFilme {

    TERROR_SUSPENSE(0), ANIMACAO(1), DRAMA_MISTERIO(2), COMEDIA_ROMANCE(3);

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
