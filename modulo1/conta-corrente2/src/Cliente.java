public class Cliente {
    private String nome;
    private String cpf;
    private Contato contatos[];
    private Endereco enderecos[];

    public Cliente() { }
    public Cliente(String nome, String cpf, Contato contatos[], Endereco enderecos[]) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public Contato[] getContatos() { return contatos; }

    public void setContatos(Contato[] contatos) { this.contatos = contatos; }

    public Endereco[] getEnderecos() { return enderecos; }

    public void setEnderecos(Endereco[] enderecos) { this.enderecos = enderecos; }

    void imprimirCliente() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("-------- Contatos --------");
        for (int i = 0; i < contatos.length; i++) {
            contatos[i].imprimirContato();
        }
        System.out.println("-------- Endereços --------");
        for (int i = 0; i < enderecos.length; i++) {
            enderecos[i].imprimirEndereco();
        }
    }
}