import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = "";
        int contador = 0;
        int vetorIdade[] = new int[100];
        double vetorAltura[] = new double[100];
        double vetorPeso[] = new double[100];
        do {
            System.out.println("Informe o nome do Jogador");
            nome = scanner.nextLine();
            System.out.println("Informe a idade do Jogador");
            int idade = scanner.nextInt();
            System.out.println("Informe o peso do Jogador");
            double peso = scanner.nextDouble();
            System.out.println("Informe a altura do Jogador");
            double altura = scanner.nextDouble();
            contador++;
            scanner.nextLine();
            vetorIdade[contador] = idade;
            vetorPeso[contador] = peso;
            vetorAltura[contador] = altura;
        } while (!nome.equals("sair"));

        if (contador > 0) {
            double auxiliarMaiorJogador;
            double auxiliarJogadorMaisPesado;
            int auxiliarJogadorMaisVelho;
            double mediaAlturas = 0;
            for (int i = 1; i <= contador; i++) {
                for (int j = i; j <= contador; j++) {
                    if (vetorIdade[i] > vetorIdade[j]) {
                        auxiliarJogadorMaisVelho = vetorIdade[i];
                        vetorIdade[i] = vetorIdade[j];
                        vetorIdade[j] = auxiliarJogadorMaisVelho;
                    }
                    if (vetorAltura[i] > vetorAltura[j]) {
                        auxiliarMaiorJogador = vetorAltura[i];
                        vetorAltura[i] = vetorAltura[j];
                        vetorAltura[j] = auxiliarMaiorJogador;
                    }
                    if (vetorPeso[i] > vetorPeso[j]) {
                        auxiliarJogadorMaisPesado = vetorPeso[i];
                        vetorPeso[i] = vetorPeso[j];
                        vetorPeso[j] = auxiliarJogadorMaisPesado;
                    }
                }
                mediaAlturas += vetorAltura[i];
            }
            System.out.println("Quantidade de Jogadores Cadastrados: " + contador);
            System.out.println("Altura do maior Jogador: " + vetorAltura[contador]);
            System.out.println("Jogador mais velho: " + vetorIdade[contador]);
            System.out.println("Jogador mais pesado: " + vetorPeso[contador]);
            System.out.println("Média das alturas jogadores: " + (mediaAlturas / contador));
        }
    }
}
