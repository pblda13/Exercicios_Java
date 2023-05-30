package Intermediario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercicio_3 {
    public static void main(String[] args) {

        //Exercício 3: Escreva um programa em Java que leia um arquivo de texto e conte o número de palavras presentes nele.
            // Caminho do arquivo a ser lido

            String caminhoArquivo = "D:\\Users\\Pâmela\\Desktop\\Exercicios_Java\\Praticando\\src\\Intermediario\\Arquivo.txt";

            try {
                // Cria um objeto FileReader para ler o arquivo
                FileReader fileReader = new FileReader(caminhoArquivo);

                // Cria um objeto BufferedReader para ler o conteúdo do arquivo
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String linha;
                int contadorPalavras = 0;

                // Lê cada linha do arquivo
                while ((linha = bufferedReader.readLine()) != null) {
                    // Divide a linha em palavras separadas por espaços
                    String[] palavras = linha.split("\\s+");

                    // Incrementa o contador de palavras com o número de palavras na linha
                    contadorPalavras += palavras.length;
                }

                // Exibe o resultado
                System.out.println("Número de palavras no arquivo: " + contadorPalavras);

                // Fecha o BufferedReader
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
