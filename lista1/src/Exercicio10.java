import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Programa para informar o conceito do Aluno");
        System.out.println("Informe o numero de identificação do Aluno: ");
        int id = scanner.nextInt();
        System.out.println("Informe a Nota 01 do Aluno ");
        double nota1 = scanner.nextDouble();
        System.out.println("Informe a Nota 02 do Aluno ");
        double nota2 = scanner.nextDouble();
        System.out.println("Informe a Nota 03 do Aluno ");
        double nota3 = scanner.nextDouble();
        System.out.println("Informe a Média dos Exercicios ");
        double mediaExercicios = scanner.nextDouble();
        double mediaAproveitamento = (nota1 + nota2 * 2 + nota3 * 3 + mediaExercicios) / 7;
        if (mediaAproveitamento >= 9) {
            System.out.println("Identificacao do Aluno: " + id +
                    "\nNota 01: " + nota1 + "  |  Nota 02: " + nota2 + "  |  Nota 03: " + nota3 +
                    "\nMedia dos Exercicios: " + mediaExercicios + " Media de Aproveitamento: " + mediaAproveitamento +
                    "\nConceito A");
            System.out.println("A P R O V A D O");
        } else if (mediaAproveitamento >= 7.5 && mediaAproveitamento < 9) {
            System.out.println("Identificacao do Aluno: " + id +
                    "\nNota 01: " + nota1 + "  |  Nota 02: " + nota2 + "  |  Nota 03: " + nota3 +
                    "\nMedia dos Exercicios: " + mediaExercicios + " Media de Aproveitamento: " + mediaAproveitamento +
                    "\nConceito B");
            System.out.println("A P R O V A D O");
        } else if (mediaAproveitamento >= 6 && mediaAproveitamento < 7.5) {
            System.out.println("Identificacao do Aluno: " + id +
                    "\nNota 01: " + nota1 + "  |  Nota 02: " + nota2 + "  |  Nota 03: " + nota3 +
                    "\nMedia dos Exercicios: " + mediaExercicios + " Media de Aproveitamento: " + mediaAproveitamento +
                    "\nConceito C");
            System.out.println("A P R O V A D O");
        } else if (mediaAproveitamento >= 4 && mediaAproveitamento < 6) {
            System.out.println("Identificacao do Aluno: " + id +
                    "\nNota 01: " + nota1 + "  |  Nota 02: " + nota2 + "  |  Nota 03: " + nota3 +
                    "\nMedia dos Exercicios: " + mediaExercicios + " Media de Aproveitamento: " + mediaAproveitamento +
                    "\nConceito D");
            System.out.println("R E P R O V A D O");
        } else {
            System.out.println("Identificacao do Aluno: " + id +
                    "\nNota 01: " + nota1 + "  |  Nota 02: " + nota2 + "  |  Nota 03: " + nota3 +
                    "\nMedia dos Exercicios: " + mediaExercicios + " Media de Aproveitamento: " + mediaAproveitamento +
                    "\nConceito E");
            System.out.println("R E P R O V A D O");
        }
    }
}