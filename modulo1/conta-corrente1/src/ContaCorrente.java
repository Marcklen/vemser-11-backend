public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    final double CHEQUE_ESPECIAL = 500.00;

    void imprimirContaCorrente() {
        System.out.println("Nome: " + cliente.nome);
        System.out.println("CPF: " + cliente.cpf);
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Agência: " + agencia);
        System.out.println("Saldo: " + saldo);
        System.out.println("Cheque especial: " + CHEQUE_ESPECIAL);
        System.out.println("---- Contatos ---- ");
        for (int i = 0; i < cliente.contatos.length; i++) {
            if (cliente.contatos[i].tipo == 2) {
                cliente.contatos[i].imprimirContato();
            }
        }
        System.out.println("---- Endereços ----");
        for (int i = 0; i < cliente.enderecos.length; i++) {
            if (cliente.enderecos[i].tipo == 2) {
                cliente.enderecos[i].imprimirEndereco();
            }
        }
    }

    boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso!%n", valor);
            return true;
        } else {
            System.out.println("Não é possível sacar um valor negativo!");
            return false;
        }
    }

    boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso!%n", valor);
            return true;
        } else {
            System.out.println("Não é possível depositar um valor negativo!");
            return false;
        }
    }

    double retornarSaldoComChequeEspecial() {
        System.out.printf("Saldo com cheque especial: R$ %.2f%n", saldo + CHEQUE_ESPECIAL);
        return saldo + CHEQUE_ESPECIAL;
    }

    boolean transferir(ContaCorrente contaDestino, double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            contaDestino.saldo += valor;
            System.out.printf("Transferência de R$ %.2f realizada com sucesso!%n", valor);
            return true;
        } else {
            return false;
        }
    }
}