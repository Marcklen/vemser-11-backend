package funcoes.desafios;

public class MainFuncao {
    public static void main(String[] args) {

        Calculo soma = (a, b) -> { return a + b; };
        Calculo mult  = (a, b) -> { return a * b; };
        System.out.println(soma.calcular(2, 3));
        System.out.println(mult.calcular(4, 5));
    }
}