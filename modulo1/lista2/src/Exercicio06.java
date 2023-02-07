import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        int vetor[] = {10, 2, 30, 10, 5, 6, 10, 8, 9, 15};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um numero? ");
        int numero = scanner.nextInt();
        int contador = 0;
        int maiorQueNumeroDigitado = 0;
        int menorQueNumeroDigitado = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) {
                contador++;
            }
            if (vetor[i] < numero) {
                maiorQueNumeroDigitado++;
            }
            if (vetor[i] > numero) {
                menorQueNumeroDigitado++;
            }
        }
        System.out.println("O número " + numero + " aparece " + contador + " vezes no vetor.");
        System.out.println("O número " + numero + " é maior que " + maiorQueNumeroDigitado + " números do vetor.");
        System.out.println("O número " + numero + " é menor que " + menorQueNumeroDigitado + " números do vetor.");
    }
}