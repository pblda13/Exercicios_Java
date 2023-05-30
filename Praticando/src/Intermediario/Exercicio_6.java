package Intermediario;

import java.util.Random;
import java.util.Scanner;

public class Exercicio_6 {
    public static void main(String[] args) {

        //Exercício 6: Escreva um programa em Java que implemente um jogo de adivinhação.
        // O programa deve gerar um número aleatório entre 1 e 100 e permitir que o usuário faça tentativas de adivinhar o número.
        // O programa deve fornecer dicas informando se o número é maior ou menor do que a tentativa do usuário.

        // Cria um objeto Random para gerar o número aleatório
        Random random = new Random();

        // Gera um número aleatório entre 1 e 100
        int numeroAleatorio = random.nextInt(100) + 1;

        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao jogo de adivinhação!");
        System.out.println("Tente adivinhar o número entre 1 e 100.");

        int tentativas = 0;
        boolean acertou = false;

        while (!acertou) {
            System.out.println("Digite a sua tentativa:");
            int tentativa = scanner.nextInt();

            tentativas++;

            if (tentativa == numeroAleatorio) {
                acertou = true;
                System.out.println("Parabéns! Você acertou o número em " + tentativas + " tentativas.");
            } else if (tentativa < numeroAleatorio) {
                System.out.println("O número é maior que a sua tentativa.");
            } else {
                System.out.println("O número é menor que a sua tentativa.");
            }
        }

        // Fecha o scanner
        scanner.close();
    }
}
