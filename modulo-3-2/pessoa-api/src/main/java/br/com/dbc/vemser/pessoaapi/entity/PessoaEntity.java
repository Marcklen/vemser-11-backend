package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "PESSOA")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "SEQ_PESSOA2", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Integer idPessoa;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "EMAIL")
    private String email;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PET" , referencedColumnName = "ID_PET")
    private PetEntity pet;

    @OneToMany(mappedBy = "pessoaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContatoEntity> contatos;

    @ManyToMany//(cascade = CascadeType.ALL)
    @JoinTable(name = "PESSOA_X_PESSOA_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_PESSOA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO"))
    private Set<EnderecoEntity> enderecos;
}