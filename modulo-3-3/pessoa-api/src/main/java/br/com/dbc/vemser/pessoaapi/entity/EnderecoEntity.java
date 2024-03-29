package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.entity.enums.TipoEndereco;
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
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENDERECO_CONTATO")
    @SequenceGenerator(name = "SEQ_ENDERECO_CONTATO", sequenceName = "SEQ_ENDERECO_CONTATO", allocationSize = 1)
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;

    @Column(name = "TIPO")
//    @Enumerated(EnumType.STRING)
    private TipoEndereco tipo;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "PAIS")
    private String pais;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "enderecos")
    private Set<PessoaEntity> pessoas;
}