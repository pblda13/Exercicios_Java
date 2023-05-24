package Iniciante;

import java.util.Random;

public class Exercicio_10 {
    public static void main(String[] args) {

        //Exercício 10: Escreva um programa em Java que simule o lançamento de um dado.
        // O programa deve gerar um número aleatório entre 1 e 6 e exibir o resultado.

        Random random = new Random();

        int numeroAleatorio = random.nextInt(6) + 1;

        System.out.println("O dado foi lançado e o resultado é: " + numeroAleatorio);
    }


    }

