import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade total de eleitores: ");
        int totalEleitores = scanner.nextInt();
        System.out.print("Digite a quantidade de votos brancos: ");
        float votosBrancos = scanner.nextInt();
        float totalVotosBrancos = (votosBrancos * 100) / totalEleitores;
        System.out.print("Digite a quantidade de votos nulos: ");
        float votosNulos = scanner.nextInt();
        float totalVotosNulos = (votosNulos * 100) / totalEleitores;
        System.out.print("Digite a quantidade de votos válidos: ");
        float votosValidos = scanner.nextInt();
        float totalVotosValidos = (votosValidos * 100) / totalEleitores;
        System.out.println("O percentual de votos brancos é: " + totalVotosBrancos + "%");
        System.out.println("O percentual de votos nulos   é: " + totalVotosNulos + "%");
        System.out.println("O percentual de votos validos é: " + totalVotosValidos + "%");
    }
}
