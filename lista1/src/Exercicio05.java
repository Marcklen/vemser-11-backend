import java.util.Scanner;

public class Exercicio05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vamos calcular a area de um retangulo! ");
        System.out.print("Digite a base: ");
        double base = scanner.nextDouble();
        System.out.print("Digite a altura: ");
        double altura = scanner.nextDouble();
        double area = base * altura;
        System.out.println("A area do retangulo é: " + area);
    }
}
