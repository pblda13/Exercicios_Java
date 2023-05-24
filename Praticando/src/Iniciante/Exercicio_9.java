package Iniciante;

import java.util.Scanner;

public class Exercicio_9 {
    public static void main(String[] args) {

        //Escreva um programa em Java que converta uma temperatura em graus Celsius para Fahrenheit. O programa deve solicitar
        // ao usuário que insira uma temperatura em graus Celsius e exibir a temperatura equivalente em Fahrenheit.
        // Utilize a fórmula: Fahrenheit = Celsius * 9/5 + 32.

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite uma temperatura ");
        double Celsius = entrada.nextDouble();
        double Fahrenheit = Celsius * 9/5 + 32;

        System.out.println("A temperatura em Fahrenheit é: " + Fahrenheit);


    }
}
