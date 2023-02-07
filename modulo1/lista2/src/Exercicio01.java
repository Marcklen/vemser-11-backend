import java.util.Scanner;

public class Exercicio01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome de um produto: ");
        String produto = scanner.nextLine().toLowerCase();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Promoção: " + produto + "\n-------------------------\n");
        float desconto = 0.05f;
        for (int i = 1; i <= 10; i++) {
            System.out.printf(i + " x R$ %.2f = R$ %.2f\n",
                    (preco - (preco * desconto)), (preco - (preco * desconto)) * i);
            desconto += 0.05f;
        }
    }
}