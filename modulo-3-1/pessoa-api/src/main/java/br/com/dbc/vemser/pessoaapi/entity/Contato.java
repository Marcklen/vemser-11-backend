package br.com.dbc.vemser.pessoaapi.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    @NotNull(message = "Tipo de contato não pode ser nulo")
    private TipoContato tipoContato;
    @NotNull(message = "Número não pode ser nulo")
    @Length(max = 13 , message = "Número não pode ter mais de 13 caracteres")
    private String numero;
    @NotBlank(message = "Descrição não pode ser nula ou vazia")
    private String descricao;

    public Contato() { }

    public Contato(Integer idContato, Integer idPessoa, TipoContato tipoContato, String numero, String descricao) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.tipoContato = tipoContato;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getIdContato() { return idContato; }

    public void setIdContato(Integer idContato) { this.idContato = idContato; }

    public TipoContato getTipoContato() { return tipoContato; }

    public void setTipoContato(TipoContato tipoContato) { this.tipoContato = tipoContato; }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getIdPessoa() { return idPessoa; }

    public void setIdPessoa(Integer idPessoa) { this.idPessoa = idPessoa; }

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", tipoContato=" + tipoContato +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
