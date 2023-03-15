package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "PET")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PET")
    @SequenceGenerator(name = "SEQ_PET", sequenceName = "SEQ_PET", allocationSize = 1)
    @Column(name = "ID_PET")
    private Integer idPet;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "TIPO")
    @Enumerated(EnumType.ORDINAL) // 0 - CACHORRO, 1 - GATO, 2 - GUAXINIM
    private TipoPet tipo;

//    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PESSOA" , referencedColumnName = "ID_PESSOA")
    private PessoaEntity idPessoa;
}