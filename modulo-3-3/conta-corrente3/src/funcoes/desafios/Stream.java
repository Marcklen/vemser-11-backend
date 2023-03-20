package funcoes.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro Paulo", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Enzo", 2350, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

        //1- listar todas as pessoas
        lista.stream()
                .forEach(System.out::println);
        System.out.println("-----------------------------------");
        //2- filtrar todas as pessoas com salario maior do que 5 mil (filter)
        lista.stream()
                .filter(p -> p.getSalario() > 5000)
                .forEach(System.out::println);
        System.out.println("-----------------------------------");
        //3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente (filter, sorted)
        lista.stream()
                .filter(p -> p.getCargo().equalsIgnoreCase("desenvolvedor"))
                .sorted((p1, p2) -> Double.compare(p1.getSalario(), p2.getSalario()))
                .forEach(System.out::println);
        System.out.println("-----------------------------------");
        //4- fazer a média salarial de todos
        System.out.println(lista.stream()
                .mapToDouble(Pessoa::getSalario)
                .average()
                .getAsDouble());
        System.out.println("-----------------------------------");
        //5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil
        System.out.println(lista.stream()
                .anyMatch(p -> p.getSalario() > 20000));
        System.out.println("-----------------------------------");
        //6- retornar uma lista de todos os ids das pessoas
        lista.stream()
                .map(Pessoa::getId)
                .forEach(System.out::println);
        System.out.println("-----------------------------------");
        //7- criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto
        lista.stream()
                .map(p -> new Salario(p.getId(), p.getSalario()))
                .forEach(System.out::println);
        System.out.println("-----------------------------------");
        //8- retornar um HashMap (estrutura de dados, e não uma função map) contendo os ids e os nomes dos colaboradores
        lista.stream()
                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome))
                .forEach((k, v) -> System.out.println(k + " - " + v));
        System.out.println("-----------------------------------");
        //9- com o mapa da 8, retornar o nome com o id=2
        System.out.println(lista.stream()
                .collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome))
                .get(2));
        System.out.println("-----------------------------------");
        //10- verificar se tem alguém que contenha o nome "Paulo" (containsignorecase) na lista e retornar o primeiro elemento que encontrar (findFirst).
        //    Imprimir o nome e salário dessa pessoa
        lista.stream()
                .filter(p -> p.getNome().toLowerCase().contains("paulo"))
                .findFirst()
                .ifPresent(p -> System.out.println(p.getNome() + " - " + p.getSalario()));
        System.out.println("-----------------------------------");
    }
    static class Salario extends Pessoa{
        public Salario(int id, double salario) {
            super(id, salario);
        }

        @Override
        public String toString() {
            return "Salario{" + "id=" + this.getId() + ", salario=" + this.getSalario() + '}';
        }
    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        public Pessoa(int id, double salario) {
            this.id = id;
            this.salario = salario;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return "Pessoa{" + "id=" + id + ", nome=" + nome + ", salario=" + salario + ", cargo=" + cargo + '}';
        }
    }
}