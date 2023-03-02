package br.com.dbc.vemser.pessoaapi.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Endereco {
    private Integer idEndereco;
    private Integer idPessoa;
    @NotNull(message = "Tipo de endereço não pode ser nulo")
    private TipoEndereco tipo;
    @NotEmpty(message = "Logradouro não pode ser vazio")
    @Length(max = 250, message = "Logradouro não pode ter mais de 250 caracteres")
    private String logradouro;
    @NotNull(message = "Número não pode ser nulo")
    private Integer numero;
    private String complemento;
    @NotBlank(message = "CEP não pode ser vazio")
    @Length(min = 8, max = 8, message = "CEP não pode ter mais de 8 caracteres")
    private String cep;
    @NotBlank(message = "CEP não pode ser vazio")
    @Length(max = 250, message = "Cidade não pode ter mais de 250 caracteres")
    private String cidade;
    @NotNull(message = "Estado não pode ser nulo")
    private String estado;
    @NotNull(message = "País não pode ser nulo")
    private String pais;

    public Endereco(){}

    public Endereco(Integer idEndereco, Integer idPessoa, TipoEndereco tipo, String logradouro, Integer numero,
                    String complemento, String cep, String cidade, String estado, String pais) {
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Integer getIdPessoa() { return idPessoa; }

    public void setIdPessoa(Integer idPessoa) { this.idPessoa = idPessoa; }

    public Integer getIdEndereco() { return idEndereco; }
    public void setIdEndereco(Integer idEndereco) { this.idEndereco = idEndereco; }
    public TipoEndereco getTipo() { return tipo; }
    public void setTipo(TipoEndereco tipo) { this.tipo = tipo; }
    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
}