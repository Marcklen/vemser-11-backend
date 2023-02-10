public abstract class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    public Conta(){}

    public Conta(Cliente cliente, String numeroConta, String agencia, double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getNumeroConta() { return numeroConta; }

    public void setNumeroConta(String numeroConta) { this.numeroConta = numeroConta; }

    public String getAgencia() { return agencia; }

    public void setAgencia(String agencia) { this.agencia = agencia; }

    public double getSaldo() { return saldo; }

    public void setSaldo(double saldo) { this.saldo = saldo; }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo && valor > 0) {
            System.out.printf("Saque de R$ %.2f realizado com sucesso!%n", valor);
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso!%n", valor);
            return true;
        } else {
            System.out.println("Não é possível depositar um valor negativo!");
            return false;
        }
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (sacar(valor)) {
            conta.depositar(valor);
            System.out.printf("Transferência de R$ %.2f realizada com sucesso!%n", valor);
            return true;
        } else {
            return false;
        }
    }
}