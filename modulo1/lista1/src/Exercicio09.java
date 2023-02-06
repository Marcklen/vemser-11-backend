import java.util.Scanner;

public class Exercicio09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a hora que começou o jogo: ");
        int horaInicio = scanner.nextInt();
        System.out.println("Informe os minutos de inicio do jogo: ");
        int minutoInicio = scanner.nextInt();
        System.out.println("Informe a hora que terminou o jogo: ");
        int horaTermino = scanner.nextInt();
        System.out.println("Informe os minutos de termino do jogo: ");
        int minutoTermino = scanner.nextInt();

        if (horaTermino < horaInicio || horaTermino == horaInicio && minutoTermino < minutoInicio) {
            horaTermino += 24;
        }
        if (minutoTermino < minutoInicio) {
            minutoTermino += 60;
            horaTermino -= 1;
        }
        /*
         poderia adicionar um outro if para caso de tudo igual e informar que o jogo teve 24horas de duração
         e colocar um else para validar os demais casos, porem acho que ficaria mais complicado de entender
         ai acabei colocando que se é tudo igual é que o jogo teve 0horas e 0min
        */

//        if (horaInicio == horaTermino && minutoInicio == minutoTermino) {
//            System.out.println("O jogo teve uma duração de 24 horas");
//        } else { o codigo abaixo }
        int duracaoHoras = horaTermino - horaInicio;
        int duracaoMinutos = minutoTermino - minutoInicio;

        System.out.println("O jogo teve uma duração de " + duracaoHoras + " hora(s) e "
                + duracaoMinutos + " minuto(s)");

    }
}
