import java.util.Scanner;

public class Exercicio08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o cargo do funcionario: ");
        String cargo = scanner.nextLine();
        System.out.print("Informe o salario do funcionario: ");
        double salario = scanner.nextDouble();
        double aumento = 0;

        switch (cargo.toLowerCase()) {
            case "gerente" -> aumento = salario * 0.10;
            case "engenheiro" -> aumento = salario * 0.20;
            case "tecnico" -> aumento = salario * 0.30;
            default -> aumento = salario * 0.40;
        }
        System.out.println("O funcionario do cargo " + cargo.toUpperCase() + " tinha um salario de " + salario
                + " e passou a receber " + (salario + aumento) + " com uma diferença de " + aumento);
        scanner.close();
    }
}
        /*
        if ((cargo == "Gerente") || (cargo == "gerente") || (cargo == "GERENTE")) {
            aumento = salario * 0.10;
        } else if (cargo == "Engenheiro" || cargo == "engenheiro" || cargo == "ENGENHEIRO") {
            aumento = salario * 0.20;
        } else if (cargo == "Técnico" || cargo == "tecnico" || cargo == "TECNICO") {
            aumento = salario * 0.30;
        } else {
            aumento = salario * 0.40;
        }
        System.out.println("O funcionario do cargo " + cargo + " tinha um salario de " + salario
                + " e passou a receber " + (salario + aumento) + " com uma diferença de " + aumento);
        */