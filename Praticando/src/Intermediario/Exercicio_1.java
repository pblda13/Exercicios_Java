package Intermediario;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercicio_1 {
    public static void main(String[] args) {
        // Exercício 1: Escreva um programa em Java que receba uma frase do usuário e conte quantas vezes cada palavra aparece na frase.
        // Exiba o resultado no final.


        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma frase:");
        String frase = scanner.nextLine();

        // Remove pontuações da frase, mantendo apenas letras, números e espaços
        frase = frase.replaceAll("[^a-zA-Z0-9\\s]", "");

        // Divide a frase em palavras separadas por espaços
        String[] palavras = frase.split("\\s+");

        // Cria um mapa para armazenar as palavras e suas contagens
        Map<String, Integer> contadorPalavras = new HashMap<>();

        // Conta as ocorrências de cada palavra
        for (String palavra : palavras) {
            if (contadorPalavras.containsKey(palavra)) {
                // Incrementa a contagem se a palavra já existe no mapa
                contadorPalavras.put(palavra, contadorPalavras.get(palavra) + 1);
            } else {
                // Adiciona a palavra ao mapa com contagem 1 se ela não existe
                contadorPalavras.put(palavra, 1);
            }
        }

        // Exibe o resultado
        System.out.println("Contagem das palavras:");
        for (Map.Entry<String, Integer> entry : contadorPalavras.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Fecha o scanner
        scanner.close();
    }
}


