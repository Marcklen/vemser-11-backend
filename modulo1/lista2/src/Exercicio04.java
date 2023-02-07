import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dadosAluno[][] = new int[2][4];
        for (int linha = 0; linha < dadosAluno.length; linha++) {
            for (int coluna = 0; coluna < dadosAluno.length; coluna++) {
                System.out.println("Número da matricula " + (linha + 1) + " " + (coluna + 1));
                dadosAluno[linha][coluna] = scanner.nextInt();
                System.out.println("Média das provas " + (linha + 1) + " " + (coluna + 1));
                dadosAluno[linha][coluna] = scanner.nextInt();
                System.out.println("Média dos trabalhos " + (linha + 1) + " " + (coluna + 1));
                dadosAluno[linha][coluna] = scanner.nextInt();
                System.out.println("Nota final " + (linha + 1) + " " + (coluna + 1));
                dadosAluno[linha][coluna] = scanner.nextInt();
            }
        }
    }
}