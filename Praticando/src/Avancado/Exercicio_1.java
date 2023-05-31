package Avancado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Exercício 1: Escreva um programa em Java que leia um arquivo CSV contendo informações de alunos (nome, idade, nota) e
// armazene essas informações em objetos. Em seguida, exiba os alunos em ordem decrescente de nota.

    class Aluno {
        private String nome;
        private int idade;
        private double nota;

        public Aluno(String nome, int idade, double nota) {
            this.nome = nome;
            this.idade = idade;
            this.nota = nota;
        }

        public String getNome() {
            return nome;
        }

        public int getIdade() {
            return idade;
        }

        public double getNota() {
            return nota;
        }
    }

    public class Exercicio_1 {
        public static void main(String[] args) {
            List<Aluno> alunos = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader("alunos.csv"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    String nome = data[0];
                    int idade = Integer.parseInt(data[1]);
                    double nota = Double.parseDouble(data[2]);
                    Aluno aluno = new Aluno(nome, idade, nota);
                    alunos.add(aluno);
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }

            // Ordena os alunos em ordem decrescente de nota
            Collections.sort(alunos, Comparator.comparingDouble(Aluno::getNota).reversed());

            // Exibe os alunos ordenados
            for (Aluno aluno : alunos) {
                System.out.println("Nome: " + aluno.getNome() + ", Idade: " + aluno.getIdade() + ", Nota: " + aluno.getNota());
            }
        }
    }


