public class Exercicio04 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        // nao sei se era pra fazer isso ou se era apenas para trocar os valores
        int auxiliar = a;
        System.out.println("O valor de a é: " + a);
        System.out.println("O valor de b é: " + b);
        // com o auxiliar troquei os valores ao inves de deixar ambos com valor 20
        a = b;
        b = auxiliar;
        System.out.println("O valor de a agora é: " + a);
        System.out.println("O valor de b agora é: " + b);
    }
}
