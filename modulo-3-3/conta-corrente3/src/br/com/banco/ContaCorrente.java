package br.com.banco;

public class ContaCorrente extends Conta implements Impressao {

    private double chequeEspecial;

    public ContaCorrente() {
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public double retornarSaldoComChequeEspecial() {
        return getSaldo() + chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if ((valor <= getSaldo() && valor <= retornarSaldoComChequeEspecial())
                && valor > 0) {
            System.out.printf("Saque de R$ %.2f realizado com sucesso!%n", valor);
            setSaldo(getSaldo() - valor);
            return true;
        }
        System.out.println("Valor inválido para saque!!");
        return false;
    }

    @Override
    public void imprimir() {
        System.out.println("-------- Dados da conta corrente --------");
        System.out.println("br.com.banco.Cliente: " + getCliente().getNome());
        System.out.println("Agência: " + getAgencia() + " - br.com.banco.Conta: " + getNumeroConta());
        System.out.printf("Saldo: R$ %.2f%n", getSaldo());
        System.out.printf("Cheque especial: R$ %.2f%n", chequeEspecial);
        System.out.printf("Saldo com cheque especial: R$ %.2f%n", retornarSaldoComChequeEspecial());
    }
}