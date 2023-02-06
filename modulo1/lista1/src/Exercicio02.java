import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha um dos estados abaixo: \n(1) - Ceara \n(2) - Rio Grande do Norte \n(3) - Recife");
        int estado = scanner.nextInt();
        switch (estado) {
            case 1 -> {
                System.out.println("Você escolheu o estado do Ceara");
                System.out.println("Escolha uma das cidades abaixo: \n(1) - Fortaleza \n(2) - Sobral");
                int cidade = scanner.nextInt();
                if (cidade == 1) {
                    System.out.println("Você escolheu a cidade de Fortaleza");
                    System.out.println("População: 2.703.391  - fonte: https://cidades.ibge.gov.br/brasil/ce/fortaleza/panorama");
                    System.out.println("Principal festa de Fortaleza é o Carnaval mas no momento atual são os pré carnavais que acontecem todo final de semana");
                    System.out.println("IDH (Índice de Desenvolvimento Humano): 0,754 -- baseado em dados de (2010) também do IBGE");
                } else if (cidade == 2) {
                    System.out.println("Você escolheu a cidade de Sobral");
                    System.out.println("População: 212.437 - fonte: https://cidades.ibge.gov.br/brasil/ce/sobral/panorama");
                    System.out.println("Principal festa é a da padroeira Nossa Senhora de Conceição e também o Carnabral");
                    System.out.println("IDH (Índice de Desenvolvimento Humano): 0,714 -- baseado em dados de (2010) também do IBGE");
                } else {
                    System.out.println("Você não escolheu nenhuma cidade");
                }
            }
            case 2 -> {
                System.out.println("Você escolheu o estado do Rio Grande do Norte");
                System.out.println("Escolha uma das cidades abaixo: \n(1) - Natal \n(2) - Caicó");
                int cidade = scanner.nextInt();
                if (cidade == 1) {
                    System.out.println("Você escolheu a cidade de Natal");
                    System.out.println("População: 896.708 - fonte: https://www.ibge.gov.br/cidades-e-estados/rn/natal.html");
                    System.out.println("Principal festa é o Carnatal, que é carnaval fora de época");
                    System.out.println("IDH (Índice de Desenvolvimento Humano): 0,763 -- baseado em dados de (2010) também do IBGE");
                } else if (cidade == 2) {
                    System.out.println("Você escolheu a cidade de Caicó");
                    System.out.println("População: 68.726 - fonte: https://www.ibge.gov.br/cidades-e-estados/rn/caico.html");
                    System.out.println("Principal festa é o Carnaval de Caicó, eleito o 3º melhor carnaval do Nordeste, ficando atrás apenas de Salvador e Olinda");
                    System.out.println("IDH (Índice de Desenvolvimento Humano): 0,710 -- baseado em dados de (2010) também do IBGE");
                } else {
                    System.out.println("Você não escolheu nenhuma cidade");
                }
            }
            case 3 -> {
                System.out.println("Você escolheu o estado do Pernambuco");
                System.out.println("Escolha uma das cidades abaixo: \n(1) - Recife \n(2) - Olinda");
                int cidade = scanner.nextInt();
                if (cidade == 1) {
                    System.out.println("Você escolheu a cidade de Recife");
                    System.out.println("População: 1.661,017 - fonte: https://www.ibge.gov.br/cidades-e-estados/pe/recife.html");
                    System.out.println("Principal festa de Recife é o seu carnaval!!!");
                    System.out.println("IDH (Índice de Desenvolvimento Humano): 0,772 -- baseado em dados de (2010) também do IBGE");
                } else if (cidade == 2) {
                    System.out.println("Você escolheu a cidade de Olinda");
                    System.out.println("População: 393.734 - fonte: https://www.ibge.gov.br/cidades-e-estados/pe/olinda.html");
                    System.out.println("Principal festa é o Carnaval de Olinda , eleito o 2º melhor carnaval do Nordeste, ficando atrás apenas de Salvador!");
                    System.out.println("IDH (Índice de Desenvolvimento Humano): 0,735 -- baseado em dados de (2010) também do IBGE");
                } else {
                    System.out.println("Você não escolheu nenhuma cidade");
                }
            }
            default -> System.out.println("Você não escolheu nenhum estado");
        }
    }
}