import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int advinhaNumero;
        System.out.println("Escolha um número inteiro, positivo e que seja menor que 1000 ?");
        System.out.print("Opção -> ");
        int numero = scanner.nextInt();
        while (numero <= 0 || numero >= 1000) {
            System.out.println("Número inválido! Tente de novo.");
            System.out.print("Opção -> ");
            numero = scanner.nextInt();
        }
        System.out.println("Adivinhe o número que eu escolhi!");
        System.out.print("Opção -> ");
        advinhaNumero = scanner.nextInt();
        while (advinhaNumero != numero) {
            if (advinhaNumero < numero) {
                System.out.println("O número que eu escolhi é maior... Tente Novamente!");
            } else {
                System.out.println("O número que eu escolhi é menor... Tente Novamente!");
            }
            System.out.print("Opção -> ");
            advinhaNumero = scanner.nextInt();
        }
        System.out.println("Parabéns, você acertou!");
    }
}