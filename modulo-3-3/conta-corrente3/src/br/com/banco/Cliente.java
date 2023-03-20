package br.com.banco;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Contato> contatos = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente() { }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public List<Contato> getContatos() { return contatos; }

    public void setContatos(Contato contatos) { this.contatos.add(contatos); }

    public List<Endereco> getEnderecos() { return enderecos; }

    public void setEnderecos(Endereco enderecos) { this.enderecos.add(enderecos); }

    void imprimirCliente() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        imprimirContato();
        imprimirEndereco();
    }
    void imprimirContato() {
        System.out.println("-------- Contatos --------");
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i) != null) {
                contatos.get(i).imprimirContato();
            }
        }
    }
    void imprimirEndereco() {
        System.out.println("-------- Endereços --------");
        for (Endereco endereco : enderecos) {
            if (endereco != null) {
                endereco.imprimirEndereco();
            }
        }
    }
}