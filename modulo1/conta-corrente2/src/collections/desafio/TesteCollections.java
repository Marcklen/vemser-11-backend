package collections.desafio;

import java.util.ArrayList;
import java.util.List;

public class TesteCollections {
    public static void main(String[] args) {
        // criando a collections
        List<String> nomes = new ArrayList<>();
        // adicionando elementos
        nomes.add("Marcklen");
        nomes.add("Monteiro");
        nomes.add("Guimarães");
        nomes.add("Danielle");
        nomes.add("Miguel");
        nomes.add("Dourado");
        // imprimindo a lista inicial completa
        System.out.println((nomes) + " - Tamanho lista: '" + nomes.size() + "'");
        // imprimindo o penultimo elemento da lista
        System.out.println(nomes.size() - 2); // imprimindo o indice do penultimo elemento
        System.out.println(nomes.get(nomes.size() - 2)); // imprimindo o valor do elemento
        // imprimindo o primeiro elemento da lista
        System.out.println(nomes.get(0));
        // removendo o ultimo elemento da lista
        nomes.remove(nomes.size() - 1);
        // imprimindo a lista final
        System.out.println((nomes) + " - Tamanho lista: '" + nomes.size() + "'");
    }
}