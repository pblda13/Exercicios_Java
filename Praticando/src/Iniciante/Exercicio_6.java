package Iniciante;

import java.util.Scanner;

public class Exercicio_6 {

    public static void main(String[] args) {

        //Exercício 6: Escreva um programa em Java que exiba os primeiros 10 números da sequência de Fibonacci.
        // A sequência de Fibonacci é uma série de números em que cada número é a soma dos dois anteriores.
        // A sequência começa com 0 e 1. Portanto, os primeiros números da sequência são: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34.

        Scanner x = new Scanner(System.in);
        System.out.println("Digite a quantidade de termos");
        int n1 = 0, n2 = 1;
        for (int qtd = x.nextInt(); qtd > 0; qtd--) {
            System.out.print(n1 + " ");
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        System.out.println("Fim");
    }
}
