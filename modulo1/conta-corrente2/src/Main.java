public class Main {
    public static void main(String[] args) {

        Contato[] contatoMarcklen = new Contato[2];
        contatoMarcklen[0] = new Contato("Celular", "85-98879-8959", 2);
        Endereco[] endMarcklen = new Endereco[2];
        endMarcklen[0] = new Endereco(1, "Rua Leão de Aço", 1918, "Pici", "60-111-333", "Fortaleza", "CE", "BR");
        Cliente marcklen = new Cliente("Marcklen Guimarães", "011-222-333-44", contatoMarcklen, endMarcklen);
        ContaCorrente contaMarcklen = new ContaCorrente(marcklen, "1234-5", "0569", 1000d, 500d);

        Contato[] contatoMiguel = new Contato[2];
        contatoMiguel[0] = new Contato("Celular", "85-98801-2345", 2);
        Endereco[] endMiguel = new Endereco[2];
        endMiguel[0] = new Endereco(1, "Rua Fortaleza EC", 1918, "Tricolor", "60-111-333", "Fortaleza", "CE", "BR");
        Cliente miguel = new Cliente("Miguel Dourado", "022-333-444-55", contatoMiguel, endMiguel);
        ContaCorrente contaMiguel = new ContaCorrente(miguel, "1234-5", "0569", 1000d, 1000d);

        System.out.println("------------------------------------------");
        System.out.println("IMPRIMINDO DADOS DA CONTA - MARCKLEN");
        contaMarcklen.imprimir();
        System.out.println("------------------------------------------");
        System.out.println("IMPRIMINDO DADOS DA CONTA - MIGUEL");
        contaMiguel.imprimir();
        System.out.println("-----------------------------------------");
        contaMarcklen.depositar(500);
        contaMarcklen.imprimir();
        contaMarcklen.sacar(1000);
        contaMarcklen.imprimir();
        contaMarcklen.sacar(500);
        contaMarcklen.imprimir();
        System.out.println("-----------------------------------------");
        contaMiguel.transferir(contaMarcklen, 199);
        System.out.println("-----------------------------------------");
        contaMarcklen.imprimir();
        System.out.println("-----------------------------------------");
        contaMiguel.imprimir();
    }
}