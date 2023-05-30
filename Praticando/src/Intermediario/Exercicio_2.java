package Intermediario;

import java.util.Scanner;

public class Exercicio_2 {
    public static void main(String[] args) {

        //Exercício 2: Escreva um programa em Java que leia uma sequência de números inteiros e determine o segundo maior
        // número presente nessa sequência.

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de números da sequência:");
        int quantidadeNumeros = scanner.nextInt();

        if (quantidadeNumeros < 2) {
            System.out.println("A sequência deve ter pelo menos dois números.");
            scanner.close();
            return;
        }

        int maior = Integer.MIN_VALUE;
        int segundoMaior = Integer.MIN_VALUE;

        System.out.println("Digite os números da sequência:");
        for (int i = 0; i < quantidadeNumeros; i++) {
            int numero = scanner.nextInt();

            if (numero > maior) {
                segundoMaior = maior;
                maior = numero;
            } else if (numero > segundoMaior && numero < maior) {
                segundoMaior = numero;
            }
        }

        System.out.println("O segundo maior número da sequência é: " + segundoMaior);

        // Fecha o scanner
        scanner.close();
    }
}


