import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] matriz = new double[10][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Digite o valor da mercadoria " + (i + 1) + " " + (j + 1));
                matriz[i][j] = scanner.nextDouble();
            }
        }
        // imprimindo a matriz para ficar mais fácil de visualizar e tentar buscar a menor soma das colunas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        // soma das colunas
        double somaColuna1 = 0;
        double somaColuna2 = 0;
        double somaColuna3 = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (j == 0) {
                    somaColuna1 += matriz[i][j];
                } else if (j == 1) {
                    somaColuna2 += matriz[i][j];
                } else if (j == 2) {
                    somaColuna3 += matriz[i][j];
                }
            }
        }
        if (somaColuna1 > somaColuna2 && somaColuna2 > somaColuna3) {
            System.out.println("A coluna 3 tem a menor soma");
        } else if (somaColuna1 > somaColuna2 && somaColuna2 < somaColuna3) {
            System.out.println("A coluna 2 tem a menor soma");
        } else if (somaColuna1 < somaColuna2 && somaColuna2 < somaColuna3) {
            System.out.println("A coluna 1 tem a menor soma");
        }
    }
}