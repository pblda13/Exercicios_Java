package Iniciante;

import java.util.Scanner;

public class Exercicio_8 {
    public static void main(String[] args) {

        //Exercício 8: Escreva um programa em Java que solicite ao usuário que insira uma palavra e verifique se essa palavra é um palíndromo.
        // Um palíndromo é uma palavra que pode ser lida da mesma forma tanto da esquerda para a direita como da direita para a esquerda.

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = entrada.nextLine();

        if (ehPalindromo(palavra)) {
            System.out.println("A palavra é um palíndromo.");
        } else {
            System.out.println("A palavra não é um palíndromo.");
        }
    }

    public static boolean ehPalindromo(String palavra) {
        int inicio = 0;
        int fim = palavra.length() - 1;

        while (inicio < fim) {
            if (palavra.charAt(inicio) != palavra.charAt(fim)) {
                return false;
            }

            inicio++;
            fim--;
        }

        return true;
    }
    }

