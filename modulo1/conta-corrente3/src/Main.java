import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente marcklen = new Cliente("Marcklen Guimarães", "011-222-333-11");
        marcklen.setContatos(new Contato("Celular", "85-98879-8959", 2));
        marcklen.setEnderecos(new Endereco(1, "Rua Leão de Aço", 1918, "Pici", "60-111-333", "Fortaleza", "CE", "BR"));
        marcklen.imprimirCliente();
        System.out.println("-----------------------------------------");
        Cliente miguel = new Cliente("Miguel Guimarães", "012-444-555-11");
        miguel.setContatos(new Contato("Celular", "85-98801-2345", 2));
        miguel.setEnderecos(new Endereco(1, "Rua Fortaleza EC", 1918, "Tricolor", "60-111-333", "Fortaleza", "CE", "BR"));
        miguel.imprimirCliente();

        Conta contaCorrenteMarcklen = new ContaCorrente(marcklen, "1234-5", "0569", 500d, 500d);
        Conta contaPagamentoMarcklen = new ContaPagamento(marcklen, "1234-5", "0569", 100d);

        Conta contaPoupancaMiguel = new ContaPoupanca(miguel, "1234-5", "0569", 200d);

        System.out.println("-----------------------------------------");
        System.out.println("IMPRIMINDO DADOS DA CONTA - MARCKLEN");
        System.out.println("-----------------------------------------");
        ((ContaCorrente) contaCorrenteMarcklen).imprimir();
        System.out.println("-----------------------------------------");
        ((ContaPagamento) contaPagamentoMarcklen).imprimir();
        System.out.println("-----------------------------------------");
        System.out.println("IMPRIMINDO DADOS DA CONTA - MIGUEL");
        System.out.println("-----------------------------------------");
        ((ContaPoupanca) contaPoupancaMiguel).imprimir();
        System.out.println("-----------------------------------------");
        ((ContaPoupanca) contaPoupancaMiguel).creditarTaxa();
        ((ContaPoupanca) contaPoupancaMiguel).imprimir();
        System.out.println("-----------------------------------------");
        System.out.println("Depositando 100 R$");
        contaCorrenteMarcklen.depositar(100d);
        System.out.println("Sacando 400 R$");
        contaCorrenteMarcklen.sacar(400d);
        ((ContaCorrente) contaCorrenteMarcklen).imprimir();
        System.out.println("-----------------------------------------");
        ((ContaPagamento) contaPagamentoMarcklen).imprimir();
        System.out.println("Transferindo 100 R$ da conta corrente para conta pagamento");
        contaCorrenteMarcklen.transferir(contaPagamentoMarcklen, 100d);
        System.out.println("-----------------------------------------");
        ((ContaCorrente) contaCorrenteMarcklen).imprimir();
        System.out.println("-----------------------------------------");
        ((ContaPagamento) contaPagamentoMarcklen).imprimir();
        System.out.println("-----------------------------------------");
        contaPagamentoMarcklen.sacar(150d);
        System.out.println("-----------------------------------------");
        ((ContaPagamento) contaPagamentoMarcklen).imprimir();
        System.out.println("-----------------------------------------");
    }
}