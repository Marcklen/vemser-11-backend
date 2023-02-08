public class Cliente {
    String nome;
    String cpf;
    Contato contatos[];
    Endereco enderecos[];

    void imprimirCliente() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("---- Contatos ---- ");
        for (int i = 0; i < contatos.length; i++) {
            contatos[i].imprimirContato();
        }
        System.out.println("---- Endereços ----");
        for (int i = 0; i < enderecos.length; i++) {
            enderecos[i].imprimirEndereco();
        }
    }
}
