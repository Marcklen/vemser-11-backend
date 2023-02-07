public class Contato {
    String descricao;
    String telefone;
    int tipo;

    void imprimirContato() {
        System.out.println("Contato: " + descricao);
        System.out.println("Telefone: " + telefone);
        if (tipo == 1) {
            System.out.println("Residencial: " + tipo);
        } else {
            System.out.println("Comercial: " + tipo);
        }
    }
}