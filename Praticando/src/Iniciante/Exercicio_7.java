package Iniciante;

import java.util.Scanner;

public class Exercicio_7 {

    public static void main(String[] args) {

        //Exercício 7: Escreva um programa em Java que verifique se um número é primo. O programa deve solicitar ao usuário que
        // insira um número inteiro e exibir uma mensagem indicando se o número é primo ou não. Um número primo é aquele que é
        // divisível apenas por 1 e por ele mesmo.

        Scanner entrada = new Scanner(System.in);

        // vamos solicitar um número inteiro positivo
        System.out.print("Informe um número inteiro positivo: ");
        int numero = Integer.parseInt(entrada.nextLine());

        // o número é negativo?
        if (numero < 0) {
            System.out.println("Número inválido.");
        }
        // é 0 ou 1?
        else if (numero == 0 || numero == 1) {
            System.out.println("O número não é primo.");
        }
        // é maior que 1
        else {
            boolean ehPrimo = true;

            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    ehPrimo = false;
                    break;
                }
            }

            if (ehPrimo) {
                System.out.println("O número é primo.");
            } else {
                System.out.println("O número não é primo.");
            }
        }
    }
}
