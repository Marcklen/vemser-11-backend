public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.nome = "Marcklen Monteiro Guimarães";
        cliente.cpf = "012.345.678-90";
        cliente.contatos = new Contato[2];
        cliente.contatos[0] = new Contato();
        cliente.contatos[0].tipo = 1;
        cliente.contatos[0].descricao = "Fixo";
        cliente.contatos[0].telefone = "(85) 3102-0304";
        cliente.contatos[1] = new Contato();
        cliente.contatos[1].tipo = 2;
        cliente.contatos[1].descricao = "Celular";
        cliente.contatos[1].telefone = "(85) 98879-8959";
        cliente.enderecos = new Endereco[2];
        cliente.enderecos[0] = new Endereco();
        cliente.enderecos[0].tipo = 1;
        cliente.enderecos[0].logradouro = "Rua do Centro";
        cliente.enderecos[0].numero = 123;
        cliente.enderecos[0].complemento = "Apto 101 - A";
        cliente.enderecos[0].cep = "60.789-123";
        cliente.enderecos[0].cidade = "Fortaleza";
        cliente.enderecos[0].estado = "CE";
        cliente.enderecos[0].pais = "Brasil";
        cliente.enderecos[1] = new Endereco();
        cliente.enderecos[1].tipo = 2;
        cliente.enderecos[1].logradouro = "Rua do Leão de Aço";
        cliente.enderecos[1].numero = 321;
        cliente.enderecos[1].complemento = "Prox. a Libertadores";
        cliente.enderecos[1].cep = "60.123-456";
        cliente.enderecos[1].cidade = "Fortaleza";
        cliente.enderecos[1].estado = "CE";
        cliente.enderecos[1].pais = "Brasil";

        Cliente outroCliente = new Cliente();
        outroCliente.nome = "Miguel Dourado Guimarães";
        outroCliente.cpf = "098.765.432-10";
        outroCliente.contatos = new Contato[1];
        outroCliente.contatos[0] = new Contato();
        outroCliente.contatos[0].tipo = 2;
        outroCliente.contatos[0].descricao = "Celular";
        outroCliente.contatos[0].telefone = "(85) 98812-3456";
        outroCliente.enderecos = new Endereco[1];
        outroCliente.enderecos[0] = new Endereco();
        outroCliente.enderecos[0].tipo = 2;
        outroCliente.enderecos[0].logradouro = "Rua Tente Outra Vez";
        outroCliente.enderecos[0].numero = 987;
        outroCliente.enderecos[0].complemento = "Prox. a praça Nao Diga Que a Vitória está Perdida";
        outroCliente.enderecos[0].cep = "60.123-400";
        outroCliente.enderecos[0].cidade = "Fortaleza";
        outroCliente.enderecos[0].estado = "CE";
        outroCliente.enderecos[0].pais = "Brasil";
        // criando as contas corrente - Marcklen
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.cliente = cliente;
        contaCorrente.numeroConta = "1234-5";
        contaCorrente.agencia = 6789;
        contaCorrente.saldo = 1000.00;
        // criando as contas corrente - Miguel
        ContaCorrente outraContaCorrente = new ContaCorrente();
        outraContaCorrente.cliente = outroCliente;
        outraContaCorrente.numeroConta = "9876-5";
        outraContaCorrente.agencia = 4321;
        outraContaCorrente.saldo = 1500.00;
        // imprimindo o cliente - Marcklen
        contaCorrente.imprimirContaCorrente();
        // imprime o cliente - Miguel
        outraContaCorrente.imprimirContaCorrente();
        // fazendo as transações
        contaCorrente.depositar(500.00);
        outraContaCorrente.depositar(1000.00);
        contaCorrente.retornarSaldoComChequeEspecial();
        outraContaCorrente.retornarSaldoComChequeEspecial();
        contaCorrente.sacar(200.00);
        outraContaCorrente.sacar(2500.00);
        contaCorrente.retornarSaldoComChequeEspecial();
        outraContaCorrente.retornarSaldoComChequeEspecial();
        contaCorrente.transferir(outraContaCorrente, 1000.00);
        System.out.printf("Saldo da conta %s: %.2f\n", contaCorrente.cliente.nome, contaCorrente.saldo);
        System.out.printf("Saldo da conta %s: %.2f\n", outraContaCorrente.cliente.nome, outraContaCorrente.saldo);
    }
}