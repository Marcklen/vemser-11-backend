package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "FILME")
public class FilmeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1)
    private Integer idFilme;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Column(name = "NOTA")
    private Integer nota;

    @Column(name = "TIPO")
    @Enumerated(EnumType.STRING)
    private TipoFilme tipoFilme;
}