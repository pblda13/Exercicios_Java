package Intermediario;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio_8 {
    public static void main(String[] args) {
        //Exercício 8: Escreva um programa em Java que leia uma lista de nomes de arquivos e verifique se cada arquivo existe no sistema
        // de arquivos. Exiba uma mensagem indicando quais arquivos existem e quais não existem.

        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de arquivos:");
        int quantidadeArquivos = scanner.nextInt();

        System.out.println("Digite os nomes dos arquivos:");

        List<String> nomesArquivos = new ArrayList<>();

        // Lê os nomes dos arquivos
        for (int i = 0; i < quantidadeArquivos; i++) {
            String nomeArquivo = scanner.next();
            nomesArquivos.add(nomeArquivo);
        }

        System.out.println("Verificando existência dos arquivos...");

        // Verifica a existência dos arquivos
        for (String nomeArquivo : nomesArquivos) {
            File arquivo = new File(nomeArquivo);

            if (arquivo.exists()) {
                System.out.println("O arquivo '" + nomeArquivo + "' existe.");
            } else {
                System.out.println("O arquivo '" + nomeArquivo + "' não existe.");
            }
        }

        // Fecha o scanner
        scanner.close();
    }
}
