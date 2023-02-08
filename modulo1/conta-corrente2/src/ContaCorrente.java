public class ContaCorrente extends Conta implements Impressao {

    private double chequeEspecial;

    public ContaCorrente() {
    }

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public double retornarSaldoComChequeEspecial() {
        return getSaldo() + chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public boolean sacar(double valor) {
        if (valor > retornarSaldoComChequeEspecial()) {
            System.out.printf("Saldo insuficiente para saque de R$ %.2f%n", valor);
            return false;
        } else if (valor <= retornarSaldoComChequeEspecial()) {
            setSaldo(getSaldo() - valor);
            return true;
        } else if (valor < 0) {
            System.out.println("Valor inválido para saque!!");
            return false;
        }
        return false;
    }

    @Override
    public void imprimir() {
        System.out.println("-------- Dados da conta corrente --------");
        System.out.println("Cliente: " + getCliente().getNome());
        System.out.println("Agência: " + getAgencia() + " - Conta: " + getNumeroConta());
        System.out.printf("Saldo: R$ %.2f%n", getSaldo());
        System.out.printf("Cheque especial: R$ %.2f%n", chequeEspecial);
        System.out.printf("Saldo com cheque especial: R$ %.2f%n", retornarSaldoComChequeEspecial());
    }
}