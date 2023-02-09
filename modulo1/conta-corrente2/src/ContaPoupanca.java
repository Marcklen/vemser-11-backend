public class ContaPoupanca extends Conta implements Impressao {

    static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca() {}

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa() {
        double calcularRendimento = this.getSaldo() * JUROS_MENSAL;
        this.setSaldo(calcularRendimento);
        System.out.printf("Rendimento creditado com sucesso! Seu saldo atual é de : R$%.2f%n", this.getSaldo());
    }

    @Override
    public void imprimir() {
        System.out.println("-------- Dados da conta poupança --------");
        System.out.println("Cliente: " + this.getCliente().getNome());
        System.out.println("Agência: " + this.getAgencia() + " - Conta: " + this.getNumeroConta());
        System.out.printf("Saldo: R$%.2f%n", this.getSaldo());
        System.out.println("Taxa de Rendimento: " + JUROS_MENSAL + " % ao mês");
    }
}