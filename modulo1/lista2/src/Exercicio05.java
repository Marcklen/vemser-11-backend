import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matriz = new double[3][3];
        double[] somaColunaMercado = new double[3];
        int colunaMaisEmConta = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Digite o valor da mercadoria " + (i + 1) + " " + (j + 1));
                matriz[i][j] = scanner.nextDouble();
                // somando ao digitar os valores
                somaColunaMercado[i] += matriz[j][i];
            }
            if (i > 0 && somaColunaMercado[i] < somaColunaMercado[i - 1]) {
                colunaMaisEmConta = i + 1;
            }
        }
        // imprimindo a matriz para ficar mais fácil de visualizar e tentar buscar a menor soma das colunas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("O mercado da coluna " + colunaMaisEmConta + " é o mais em conta!");
    }
}