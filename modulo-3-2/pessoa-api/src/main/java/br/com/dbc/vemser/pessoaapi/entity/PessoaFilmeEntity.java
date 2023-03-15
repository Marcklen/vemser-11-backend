package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "PESSOA_X_FILME")
public class PessoaFilmeEntity {

    @EmbeddedId
//    @AttributeOverrides({
//            @AttributeOverride(name = "idPessoa", column = @Column(name = "ID_PESSOA", nullable = false)),
//            @AttributeOverride(name = "idFilme", column = @Column(name = "ID_FILME", nullable = false))
//    })
    private PessoaFilmePK id;
    @Column(name = "DT_ASSISTIDO")
    private LocalDate dataAssistido;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "NOTA_PESSOA")
    private Integer notaPessoa;
}