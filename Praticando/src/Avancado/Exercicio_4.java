package Avancado;

import java.util.Scanner;

public class Exercicio_4 {

    //Exercício 4: Escreva um programa em Java que implemente um jogo de xadrez em modo texto. O programa deve permitir
    // que dois jogadores realizem movimentos válidos e exibir o tabuleiro após cada movimento.
    private static char[][] tabuleiro = new char[8][8];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarTabuleiro();
        exibirTabuleiro();

        boolean jogoAcabou = false;
        int jogador = 1;

        while (!jogoAcabou) {
            System.out.println("Jogador " + jogador + ", faça o seu movimento:");
            System.out.print("Linha de origem: ");
            int linhaOrigem = scanner.nextInt();
            System.out.print("Coluna de origem: ");
            int colunaOrigem = scanner.nextInt();
            System.out.print("Linha de destino: ");
            int linhaDestino = scanner.nextInt();
            System.out.print("Coluna de destino: ");
            int colunaDestino = scanner.nextInt();

            if (movimentoValido(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino, jogador)) {
                realizarMovimento(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
                exibirTabuleiro();

                // Verificar se o jogo acabou
                if (verificarXeque(jogador)) {
                    jogoAcabou = true;
                    System.out.println("Jogo encerrado. Jogador " + jogador + " venceu!");
                } else if (verificarXeque(jogador)) {
                    System.out.println("Xeque! Jogador " + jogador + ", tome cuidado!");
                }

                // Trocar o jogador
                jogador = jogador == 1 ? 2 : 1;
            } else {
                System.out.println("Movimento inválido. Tente novamente.");
            }
        }
    }

    private static void inicializarTabuleiro() {
        // Inicializar o tabuleiro com as peças nas posições iniciais
        // Peças do jogador 1
        tabuleiro[0][0] = 'r'; // Torre
        tabuleiro[0][1] = 'n'; // Cavalo
        tabuleiro[0][2] = 'b'; // Bispo
        tabuleiro[0][3] = 'q'; // Rainha
        tabuleiro[0][4] = 'k'; // Rei
        tabuleiro[0][5] = 'b'; // Bispo
        tabuleiro[0][6] = 'n'; // Cavalo
        tabuleiro[0][7] = 'r'; // Torre
        for (int coluna = 0; coluna < 8; coluna++) {
            tabuleiro[1][coluna] = 'p'; // Peão
        }

        // Peças do jogador 2
        tabuleiro[7][0] = 'R'; // Torre
        tabuleiro[7][1] = 'N'; // Cavalo
        tabuleiro[7][2] = 'B'; // Bispo
        tabuleiro[7][3] = 'Q'; // Rainha
        tabuleiro[7][4] = 'K'; // Rei
        tabuleiro[7][5] = 'B'; // Bispo
        tabuleiro[7][6] = 'N'; // Cavalo
        tabuleiro[7][7] = 'R'; // Torre
        for (int coluna = 0; coluna < 8; coluna++) {
            tabuleiro[6][coluna] = 'P'; // Peão
        }

        // Preencher as outras posições vazias do tabuleiro
        for (int linha = 2; linha < 6; linha++) {
            for (int coluna = 0; coluna < 8; coluna++) {
                tabuleiro[linha][coluna] = '-';
            }
        }
    }

    private static void exibirTabuleiro() {
        // Exibir o tabuleiro atual
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean movimentoValido(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, int jogador) {
        char pecaOrigem = tabuleiro[linhaOrigem][colunaOrigem];
        char pecaDestino = tabuleiro[linhaDestino][colunaDestino];

        // Verificar se a peça de origem pertence ao jogador atual
        if ((jogador == 1 && Character.isUpperCase(pecaOrigem)) || (jogador == 2 && Character.isLowerCase(pecaOrigem))) {
            return false;
        }

        // Implementar a lógica de verificação de movimento válido para cada tipo de peça
        return switch (Character.toLowerCase(pecaOrigem)) {
            case 'r' ->
                // Lógica de movimento válido para a Torre
                    movimentoValidoTorre(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
            case 'n' ->
                // Lógica de movimento válido para o Cavalo
                    movimentoValidoCavalo(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
            case 'b' ->
                // Lógica de movimento válido para o Bispo
                    movimentoValidoBispo(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
            case 'q' ->
                // Lógica de movimento válido para a Rainha
                    movimentoValidoRainha(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
            case 'k' ->
                // Lógica de movimento válido para o Rei
                    movimentoValidoRei(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
            case 'p' ->
                // Lógica de movimento válido para o Peão
                    movimentoValidoPeao(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino);
            default -> false; // Peça inválida
        };
    }

    private static boolean movimentoValidoTorre(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        // Verificar se o movimento é uma linha reta na horizontal ou vertical
        return linhaOrigem == linhaDestino || colunaOrigem == colunaDestino;
    }

    private static boolean movimentoValidoCavalo(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        // Verificar se o movimento é um L
        int linhaDiff = Math.abs(linhaDestino - linhaOrigem);
        int colunaDiff = Math.abs(colunaDestino - colunaOrigem);
        return (linhaDiff == 2 && colunaDiff == 1) || (linhaDiff == 1 && colunaDiff == 2);
    }

    private static boolean movimentoValidoBispo(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        // Verificar se o movimento é uma linha reta na diagonal
        int linhaDiff = Math.abs(linhaDestino - linhaOrigem);
        int colunaDiff = Math.abs(colunaDestino - colunaOrigem);
        return linhaDiff == colunaDiff;
    }

    private static boolean movimentoValidoRainha(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        // Verificar se o movimento é uma linha reta na horizontal, vertical ou diagonal
        return linhaOrigem == linhaDestino || colunaOrigem == colunaDestino || Math.abs(linhaDestino - linhaOrigem) == Math.abs(colunaDestino - colunaOrigem);
    }

    private static boolean movimentoValidoRei(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        // Verificar se o movimento é uma distância de no máximo 1 em qualquer direção
        int linhaDiff = Math.abs(linhaDestino - linhaOrigem);
        int colunaDiff = Math.abs(colunaDestino - colunaOrigem);
        return linhaDiff <= 1 && colunaDiff <= 1;
    }

    private static boolean movimentoValidoPeao(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        // Verificar se o movimento é válido para avançar, capturar ou fazer o movimento especial de avançar 2 casas no primeiro movimento
        if (colunaOrigem == colunaDestino) {
            if (linhaOrigem == 1 && linhaDestino == 3 && tabuleiro[2][colunaOrigem] == '-') {
                return true; // Movimento especial de avançar 2 casas no primeiro movimento
            }
            return linhaDestino == linhaOrigem + 1 && tabuleiro[linhaDestino][colunaDestino] == '-'; // Avançar 1 casa
        } else {
            return linhaDestino == linhaOrigem + 1 && Math.abs(colunaDestino - colunaOrigem) == 1 && Character.isLowerCase(tabuleiro[linhaDestino][colunaDestino]); // Capturar peça adversária
        }
    }


    private static void realizarMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        // Realizar o movimento no tabuleiro
        char pecaOrigem = tabuleiro[linhaOrigem][colunaOrigem];
        tabuleiro[linhaOrigem][colunaOrigem] = '-';
        tabuleiro[linhaDestino][colunaDestino] = pecaOrigem;
    }


        private static boolean verificarXeque ( int jogador){
            // Obter a posição do rei do jogador atual
            int linhaRei = -1;
            int colunaRei = -1;
            char rei = (jogador == 1) ? 'K' : 'k';

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (tabuleiro[i][j] == rei) {
                        linhaRei = i;
                        colunaRei = j;
                        break;
                    }
                }
                if (linhaRei != -1 && colunaRei != -1) {
                    break;
                }
            }

            // Verificar se alguma peça adversária pode capturar o rei
            char pecaAdversaria = (jogador == 1) ? 'a' : 'A';
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    char peca = tabuleiro[i][j];
                    if (Character.toLowerCase(peca) == pecaAdversaria) {
                        if (movimentoValido(i, j, linhaRei, colunaRei, jogador)) {
                            return true; // Rei está em xeque
                        }
                    }
                }
            }

            return false; // Rei não está em xeque
        }




        }






