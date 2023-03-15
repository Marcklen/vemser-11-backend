package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.entity.enums.TipoFilme;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "FILME")
public class FilmeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1)
    @Column(name = "ID_FILME")
    private Integer idFilme;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "NOTA")
    private Integer nota;

    @Column(name = "TIPO")
//    @Enumerated(EnumType.STRING)
    private TipoFilme tipoFilme;

    @JsonIgnore
    @OneToMany(mappedBy = "filme", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PessoaFilmeEntity> avaliacoes;
}