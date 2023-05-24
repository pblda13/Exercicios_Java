package Iniciante;

import java.util.Scanner;

public class Exercicio_4 {
    public static void main(String[] args) {

        //Exercício 4: Escreva um programa em Java que solicite ao usuário que insira seu nome e, em seguida,
        // exiba uma saudação personalizada na tela.

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome");

        String nome = sc.nextLine();

        System.out.printf("Olá %s seja bem vindo !!",nome);

        sc.close();

    }
}
