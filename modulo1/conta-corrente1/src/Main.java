public class Main {
    public static void main(String[] args) {
        Cliente marcklen = new Cliente();
        marcklen.nome = "Marcklen Monteiro Guimarães";
        marcklen.cpf = "012.345.678-90";
        marcklen.contatos = new Contato[2];
        marcklen.contatos[0] = new Contato();
        marcklen.contatos[0].tipo = 1;
        marcklen.contatos[0].descricao = "Fixo";
        marcklen.contatos[0].telefone = "(85) 3102-0304";
        marcklen.contatos[1] = new Contato();
        marcklen.contatos[1].tipo = 2;
        marcklen.contatos[1].descricao = "Celular";
        marcklen.contatos[1].telefone = "(85) 98879-8959";
        marcklen.enderecos = new Endereco[2];
        marcklen.enderecos[0] = new Endereco();
        marcklen.enderecos[0].tipo = 1;
        marcklen.enderecos[0].logradouro = "Rua do Centro";
        marcklen.enderecos[0].numero = 123;
        marcklen.enderecos[0].complemento = "Apto 101 - A";
        marcklen.enderecos[0].cep = "60.789-123";
        marcklen.enderecos[0].cidade = "Fortaleza";
        marcklen.enderecos[0].estado = "CE";
        marcklen.enderecos[0].pais = "Brasil";
        marcklen.enderecos[1] = new Endereco();
        marcklen.enderecos[1].tipo = 2;
        marcklen.enderecos[1].logradouro = "Rua do Leão de Aço";
        marcklen.enderecos[1].numero = 321;
        marcklen.enderecos[1].complemento = "Prox. a Libertadores";
        marcklen.enderecos[1].cep = "60.123-456";
        marcklen.enderecos[1].cidade = "Fortaleza";
        marcklen.enderecos[1].estado = "CE";
        marcklen.enderecos[1].pais = "Brasil";

        Cliente miguel = new Cliente();
        miguel.nome = "Miguel Dourado Guimarães";
        miguel.cpf = "098.765.432-10";
        miguel.contatos = new Contato[1];
        miguel.contatos[0] = new Contato();
        miguel.contatos[0].tipo = 2;
        miguel.contatos[0].descricao = "Celular";
        miguel.contatos[0].telefone = "(85) 98812-3456";
        miguel.enderecos = new Endereco[1];
        miguel.enderecos[0] = new Endereco();
        miguel.enderecos[0].tipo = 2;
        miguel.enderecos[0].logradouro = "Rua Tente Outra Vez";
        miguel.enderecos[0].numero = 987;
        miguel.enderecos[0].complemento = "Prox. a praça Nao Diga Que a Vitória está Perdida";
        miguel.enderecos[0].cep = "60.123-400";
        miguel.enderecos[0].cidade = "Fortaleza";
        miguel.enderecos[0].estado = "CE";
        miguel.enderecos[0].pais = "Brasil";
        // criando as contas corrente - Marcklen
        ContaCorrente nubank = new ContaCorrente();
        nubank.cliente = marcklen;
        nubank.numeroConta = "1234-5";
        nubank.agencia = 6789;
        nubank.saldo = 1000.00;
        nubank.chequeEspecial = 1000.00;
        // criando as contas corrente - Miguel
        ContaCorrente caixa = new ContaCorrente();
        caixa.cliente = miguel;
        caixa.numeroConta = "9876-5";
        caixa.agencia = 4321;
        caixa.saldo = 1500.00;
        caixa.chequeEspecial = 500.00;
        // imprimindo o marcklen - Marcklen
        nubank.imprimirContaCorrente();
        // imprime o marcklen - Miguel
        caixa.imprimirContaCorrente();
        // fazendo as transações
        nubank.depositar(500.00);
        caixa.depositar(1000.00);
        nubank.retornarSaldoComChequeEspecial();
        caixa.retornarSaldoComChequeEspecial();
        nubank.sacar(200.00);
        caixa.sacar(2500.00);
        nubank.retornarSaldoComChequeEspecial();
        caixa.retornarSaldoComChequeEspecial();
        nubank.transferir(caixa, 1000.00);
        System.out.printf("Saldo da conta %s: %.2f\n", nubank.cliente.nome, nubank.saldo);
        System.out.printf("Saldo da conta %s: %.2f\n", caixa.cliente.nome, caixa.saldo);
    }
}