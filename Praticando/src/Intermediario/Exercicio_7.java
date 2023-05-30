package Intermediario;

import java.util.*;

public class Exercicio_7 {
    public static void main(String[] args) {

        //Exercício 7: Escreva um programa em Java que leia uma lista de números inteiros e remova os números repetidos.
        // Em seguida, exiba a lista resultante.

        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de números:");
        int quantidadeNumeros = scanner.nextInt();

        System.out.println("Digite os números:");

        List<Integer> numeros = new ArrayList<>();

        // Lê os números
        for (int i = 0; i < quantidadeNumeros; i++) {
            int numero = scanner.nextInt();
            numeros.add(numero);
        }

        // Remove os números repetidos
        Set<Integer> numerosSemRepeticao = new HashSet<>(numeros);

        // Exibe a lista resultante
        System.out.println("Lista resultante:");
        for (int numero : numerosSemRepeticao) {
            System.out.println(numero);
        }

        // Fecha o scanner
        scanner.close();

    }
}
