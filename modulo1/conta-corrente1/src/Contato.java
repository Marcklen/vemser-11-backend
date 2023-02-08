public class Contato {
    String descricao;
    String telefone;
    int tipo;

    void imprimirContato() {
        System.out.println("Descrição: " + descricao);
        System.out.println("Telefone: " + telefone);
        if (tipo == 1) {
            System.out.println("Residencial");
        } else {
            System.out.println("Comercial");
        }
    }
}