package Intermediario;

import java.util.Scanner;

public class Exercicio_5 {
    public static void main(String[] args) {

        //Exercício 5: Escreva um programa em Java que leia uma matriz quadrada de tamanho NxN e verifique se ela é uma matriz diagonal.
        // Uma matriz diagonal é aquela em que todos os elementos fora da diagonal principal são iguais a zero.

        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tamanho da matriz (N):");
        int tamanho = scanner.nextInt();

        // Cria a matriz com o tamanho informado
        int[][] matriz = new int[tamanho][tamanho];

        System.out.println("Digite os elementos da matriz:");

        // Lê os elementos da matriz
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Verifica se a matriz é diagonal
        boolean matrizDiagonal = true;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                // Verifica se há elementos fora da diagonal principal diferentes de zero
                if (i != j && matriz[i][j] != 0) {
                    matrizDiagonal = false;
                    break;
                }
            }
        }

        // Exibe o resultado
        if (matrizDiagonal) {
            System.out.println("A matriz é diagonal.");
        } else {
            System.out.println("A matriz não é diagonal.");
        }

        // Fecha o scanner
        scanner.close();
    }
}
