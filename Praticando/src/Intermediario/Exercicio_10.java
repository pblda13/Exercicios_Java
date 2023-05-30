package Intermediario;

import java.util.*;

public class Exercicio_10 {
    public static void main(String[] args) {

        //Exercício 10: Escreva um programa em Java que leia uma sequência de números inteiros e determine o número que
        // mais aparece na sequência. Em caso de empate, exiba todos os números que mais aparecem.

        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a sequência de números (digite um número negativo para encerrar):");

        List<Integer> numeros = new ArrayList<>();

        // Lê os números
        int numero;
        do {
            numero = scanner.nextInt();
            if (numero >= 0) {
                numeros.add(numero);
            }
        } while (numero >= 0);

        // Conta a frequência dos números
        Map<Integer, Integer> frequencia = new HashMap<>();
        int maxFrequencia = 0;

        for (int num : numeros) {
            int freq = frequencia.getOrDefault(num, 0) + 1;
            frequencia.put(num, freq);
            maxFrequencia = Math.max(maxFrequencia, freq);
        }

        // Exibe os números mais frequentes
        System.out.println("Números mais frequentes:");
        for (int num : frequencia.keySet()) {
            if (frequencia.get(num) == maxFrequencia) {
                System.out.println(num);
            }
        }

        // Fecha o scanner
        scanner.close();
    }
}
