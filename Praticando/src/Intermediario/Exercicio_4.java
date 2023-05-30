package Intermediario;

import java.util.Scanner;

public class Exercicio_4 {

    public static void main(String[] args) {

        //Exercício 4: Escreva um programa em Java que implemente uma calculadora simples.
        // O programa deve solicitar ao usuário que insira dois números e a operação desejada (+, -, *, /).
        // Em seguida, exiba o resultado da operação.

        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número:");
        double numero1 = scanner.nextDouble();

        System.out.println("Digite o segundo número:");
        double numero2 = scanner.nextDouble();

        System.out.println("Digite a operação desejada (+, -, *, /):");
        String operacao = scanner.next();

        double resultado;

        // Executa a operação desejada
        switch (operacao) {
            case "+" -> {
                resultado = numero1 + numero2;
                System.out.println("Resultado: " + resultado);
            }
            case "-" -> {
                resultado = numero1 - numero2;
                System.out.println("Resultado: " + resultado);
            }
            case "*" -> {
                resultado = numero1 * numero2;
                System.out.println("Resultado: " + resultado);
            }
            case "/" -> {
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                    System.out.println("Resultado: " + resultado);
                } else {
                    System.out.println("Divisão por zero não é permitida.");
                }
            }
            default -> System.out.println("Operação inválida.");
        }

        // Fecha o scanner
        scanner.close();

    }
}
