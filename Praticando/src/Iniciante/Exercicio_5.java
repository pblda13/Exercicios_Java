package Iniciante;

import java.util.Scanner;

public class Exercicio_5 {
    public static void main(String[] args) {

        //Exercício 5: Escreva um programa em Java que verifique se um número é par ou ímpar. O programa deve solicitar ao usuário que insira
        // um número inteiro e exibir uma mensagem indicando se o número é par ou ímpar.

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero");

        int num = sc.nextInt();

        double ImparOuPar = num % 2;

        if (ImparOuPar == 0){
            System.out.println("Par");
        }
        else {
            System.out.println("Impar");
        }

        sc.close();
    }
}
