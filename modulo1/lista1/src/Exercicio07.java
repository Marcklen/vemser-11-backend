import java.util.Scanner;

public class Exercicio07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double ABCD = 5.30;
        final double XYPK = 6.00;
        final double KLMP = 3.20;
        final double QRST = 2.50;
        System.out.println("Digite o código de 4 digitos do produto: ");
        String codigo = scanner.nextLine();
        switch (codigo.toUpperCase()) {
            case "ABCD" -> {
                System.out.println("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                double total = quantidade * ABCD;
                System.out.println("O valor total é: " + total);
            }
            case "XYPK" -> {
                System.out.println("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                double total = quantidade * XYPK;
                System.out.println("O valor total é: " + total);
            }
            case "KLMP" -> {
                System.out.println("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                double total = quantidade * KLMP;
                System.out.println("O valor total é: " + total);
            }
            case "QRST" -> {
                System.out.println("Digite a quantidade: ");
                int quantidade = scanner.nextInt();
                double total = quantidade * QRST;
                System.out.println("O valor total é: " + total);
            }
            default -> System.out.println("Código do produto é inválido!");
        }
    }
}
