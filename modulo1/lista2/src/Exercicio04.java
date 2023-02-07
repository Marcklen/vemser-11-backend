import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dadosAluno[][] = new int[5][4];
        for (int i = 0; i < dadosAluno.length; i++) {
            int coluna = 0;
            System.out.print("Digite a matrícula do aluno : " + (i + 1) + " : ");
            dadosAluno[i][coluna] = scanner.nextInt();
            coluna++;
            System.out.print("Digite a média das provas do aluno : " + (i + 1) + " : ");
            dadosAluno[i][coluna] = scanner.nextInt();
            coluna++;
            System.out.print("Digite a média dos trabalhos do aluno : " + (i + 1) + " : ");
            dadosAluno[i][coluna] = scanner.nextInt();
            coluna++;
            dadosAluno[i][coluna] = (int) ((dadosAluno[i][1] * 0.6) + (dadosAluno[i][2] * 0.4));
        }
        double mediaNotaFinal = 0;
        double maiorMedia = 0;
        int indiceMaiorNota = 0;
        for (int i = 0; i < dadosAluno.length; i++) {
            mediaNotaFinal += dadosAluno[i][3];
            if (dadosAluno[i][3] > maiorMedia) {
                maiorMedia = dadosAluno[i][3];
                indiceMaiorNota = i;
            }
        }
        System.out.println("A Matricula do aluno com a maior nota final é " + dadosAluno[indiceMaiorNota][0]);
        System.out.printf("A media das notas finais dos alunos e : %.2f", mediaNotaFinal / dadosAluno.length);
    }
}