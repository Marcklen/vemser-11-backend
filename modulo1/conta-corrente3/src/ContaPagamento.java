public class ContaPagamento extends Conta implements Impressao {

    static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public void imprimir() {
        System.out.println("-------- Dados da conta pagamento --------");
        System.out.println("Cliente: " + this.getCliente().getNome());
        System.out.println("Agência: " + this.getAgencia() + " - Conta: " + this.getNumeroConta());
        System.out.printf("Saldo: R$ %.2f%n", this.getSaldo());
        System.out.println("Taxa de Saque: " + TAXA_SAQUE + " por utilização");
    }

    @Override
    public boolean sacar(double valor) {
        if (valor < 0 || valor >= this.getSaldo() - TAXA_SAQUE) {
            System.out.println("Valor inválido ou Saldo Insuficiente!");
            return false;
        } else {
            super.setSaldo(this.getSaldo() - valor - TAXA_SAQUE);
            System.out.println("Saque realizado com sucesso");
            return true;
        }
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (super.sacar(valor)) {
            conta.depositar(valor);
            System.out.printf("Transferência de R$ %.2f realizada com sucesso!%n", valor);
            return true;
        } else {
            System.out.println("Transferência não realizada!");
            return false;
        }
    }
}
