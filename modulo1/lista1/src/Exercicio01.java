import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a sua cidade: ");
        String cidade = scanner.nextLine();
        System.out.println("Digite o estado que pertence a sua cidade: ");
        String estado = scanner.nextLine();
        System.out.println("Digite a sua idade: ");
        int idade = scanner.nextInt();
        System.out.println("Olá seu nome é " + nome + ", você tem " + idade + " anos, " +
                "é da cidade de " + cidade + ", situada no estado de " + estado + ".");
    }
}
