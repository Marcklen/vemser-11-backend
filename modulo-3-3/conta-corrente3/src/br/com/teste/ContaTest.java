package br.com.teste;

import br.com.banco.ContaCorrente;
import br.com.banco.ContaPagamento;
import br.com.banco.ContaPoupanca;
import org.junit.Assert;
import org.junit.Test;

public class ContaTest {

    // deve testar saque conta corrente e verificar saldo com sucesso
    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso(){
        // declaração de variaveis
        double saldo = 1000;
        double valorSaque = 500;
        double saldoEsperado = 500;

        // act
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo);
        boolean saqueRealizadoComSucesso = contaCorrente.sacar(valorSaque);

        // assert
        Assert.assertTrue(saqueRealizadoComSucesso);
        Assert.assertEquals(saldoEsperado, contaCorrente.getSaldo(), 0);
    }

    // deve testar saque conta corrente sem saldo
    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo(){
        double saldo = 0;
        double valorSaque = 500;
        double saldoEsperado = 0;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo);
        boolean saqueRealizadoComSucesso = contaCorrente.sacar(valorSaque);

        Assert.assertFalse(saqueRealizadoComSucesso);
        Assert.assertEquals(saldoEsperado, contaCorrente.getSaldo(), 0);
    }

    // deve testar saque conta poupança e verificar saldo com sucesso
    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso(){
        double saldo = 1000;
        double valorSaque = 500;
        double saldoEsperado = 500;

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(saldo);
        boolean saqueRealizadoComSucesso = contaPoupanca.sacar(valorSaque);

        Assert.assertTrue(saqueRealizadoComSucesso);
        Assert.assertEquals(saldoEsperado, contaPoupanca.getSaldo(), 0);
    }

    // deve testar saque conta poupança sem saldo
    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo() {
        double saldo = 0;
        double valorSaque = 500;
        double saldoEsperado = 0;

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(saldo);
        boolean saqueRealizadoComSucesso = contaPoupanca.sacar(valorSaque);

        Assert.assertFalse(saqueRealizadoComSucesso);
        Assert.assertEquals(saldoEsperado, contaPoupanca.getSaldo(), 0);
    }

    // deve testar saque conta pagamento e verificar saldo com sucesso
    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso() {
        double saldo = 1000;
        double valorSaque = 500;
        double taxa = 4.25;
        double saldoEsperado = 500 - taxa;

        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(saldo);
        boolean saqueRealizadoComSucesso = contaPagamento.sacar(valorSaque);

        Assert.assertTrue(saqueRealizadoComSucesso);
        Assert.assertEquals(saldoEsperado, contaPagamento.getSaldo(), 0);
    }

    // deve testar saque conta pagamento sem saldo
    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo(){
        double saldo = 0;
        double valorSaque = 500;
        double saldoEsperado = 0;

        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(saldo);
        boolean saqueRealizadoComSucesso = contaPagamento.sacar(valorSaque);

        Assert.assertFalse(saqueRealizadoComSucesso);
        Assert.assertEquals(saldoEsperado, contaPagamento.getSaldo(), 0);
    }

    // deve testar transferencia e verificar saldo com sucesso
    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso(){
        double saldo = 1000;
        double valorTransferencia = 500;
        double saldoEsperadoCorrente = 500;
        double saldoEsperadoPoupanca = 1500;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(saldo);

        boolean transferenciaRealizadaComSucesso = contaCorrente.transferir(contaPoupanca, valorTransferencia);

        Assert.assertTrue(transferenciaRealizadaComSucesso);
        Assert.assertEquals(saldoEsperadoCorrente, contaCorrente.getSaldo(), 0);
        Assert.assertEquals(saldoEsperadoPoupanca, contaPoupanca.getSaldo(), 0);
    }

    // deve testar transferencia sem saldo
    @Test
    public void deveTestarTransferenciaSemSaldo(){
        double saldo = 0;
        double valorTransferencia = 500;
        double saldoEsperado = 0;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(saldo);

        boolean transferenciaRealizadaComSucesso = contaCorrente.transferir(contaPoupanca, valorTransferencia);

        Assert.assertFalse(transferenciaRealizadaComSucesso);
        Assert.assertEquals(saldoEsperado, contaCorrente.getSaldo(), 0);
        Assert.assertEquals(saldoEsperado, contaPoupanca.getSaldo(), 0);
    }

    // deve testar deposito e verificar saldo com sucesso
    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso() {
        double saldo = 1000;
        double valorDeposito = 500;
        double saldoEsperado = 1500;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo);

        boolean depositoRealizadoComSucesso = contaCorrente.depositar(valorDeposito);

        Assert.assertTrue(depositoRealizadoComSucesso);
        Assert.assertEquals(saldoEsperado, contaCorrente.getSaldo(), 0);
    }

    // deve testar deposito negativo
    @Test
    public void deveTestarDepositoNegativo() {
        double saldo = 1000;
        double valorDeposito = -500;
        double saldoEsperado = 1000;

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo);

        boolean depositoRealizadoComSucesso = contaCorrente.depositar(valorDeposito);

        Assert.assertFalse(depositoRealizadoComSucesso);
        Assert.assertEquals(saldoEsperado, contaCorrente.getSaldo(), 0);
    }

}