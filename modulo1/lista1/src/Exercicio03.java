import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite \n(1) para traduzir de Ingles para Portugues \n(2) para traduzir de Portugues para Ingles");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        if (opcao == 1) {
            System.out.println("Digite a palavra em Ingles");
            String palavra = scanner.nextLine();
            // apenas para nao dar erro ao digitar a palavra coloquei o toLowerCase
            switch (palavra.toLowerCase()) {
                case "dog":
                    System.out.println("Cachorro");
                    break;
                case "time":
                    System.out.println("Tempo");
                    break;
                case "love":
                    System.out.println("Amor");
                    break;
                case "city":
                    System.out.println("Cidade");
                    break;
                case "happy":
                    System.out.println("Feliz");
                    break;
                case "sad":
                    System.out.println("Triste");
                    break;
                case "should":
                    System.out.println("Deveria");
                    break;
                case "could":
                    System.out.println("Poderia");
                    break;
                default:
                    System.out.println("Essa Palavra não é Válida");
                    break;
            }
        } else if (opcao == 2) {
            System.out.println("Digite a palavra em Portugues");
            String palavra = scanner.nextLine();
            // apenas para nao dar erro ao digitar a palavra coloquei o toLowerCase
            switch (palavra.toLowerCase()) {
                case "cachorro":
                    System.out.println("Dog");
                    break;
                case "tempo":
                    System.out.println("Time");
                    break;
                case "amor":
                    System.out.println("Love");
                    break;
                case "cidade":
                    System.out.println("City");
                    break;
                case "feliz":
                    System.out.println("Happy");
                    break;
                case "triste":
                    System.out.println("Sad");
                    break;
                case "deveria":
                    System.out.println("Should");
                    break;
                case "poderia":
                    System.out.println("Could");
                    break;
                default:
                    System.out.println("Essa Palavra não é Válida");
                    break;
            }
        } else {
            System.out.println("Opção Inválida");
        }
    }
}