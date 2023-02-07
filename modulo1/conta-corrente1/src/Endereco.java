public class Endereco {
    int tipo;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    void imprimirEndereco() {
        System.out.println("Endereço: " + logradouro + ", " + numero);
        System.out.println("Complemento: " + complemento);
        System.out.println("CEP: " + cep);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado);
        System.out.println("País: " + pais);
        if (tipo == 1) {
            System.out.println("Residencial: " + tipo);
        } else {
            System.out.println("Comercial: " + tipo);
        }
    }
}
