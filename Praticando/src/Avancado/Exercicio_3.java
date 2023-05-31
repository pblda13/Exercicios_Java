package Avancado;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Exercício 3: Escreva um programa em Java que leia um arquivo JSON contendo dados de produtos (nome, preço, descrição) e permita ao usuário
// pesquisar e visualizar os produtos por meio de um menu interativo.
class Produto {
    private String nome;
    private double preco;
    private String descricao;

    public Produto(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }
}

public class Exercicio_3 {
    public static void main(String[] args) {
        List<Produto> produtos = lerArquivoJSON("produtos.json");
        if (produtos == null) {
            System.out.println("Falha ao ler o arquivo JSON.");
            return;
        }

        // Menu interativo
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Menu de Opções:");
            System.out.println("1. Listar todos os produtos");
            System.out.println("2. Pesquisar produtos por nome");
            System.out.println("3. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarProdutos(produtos);
                    break;
                case 2:
                    System.out.print("Digite o nome do produto: ");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    String nomePesquisa = scanner.nextLine();
                    pesquisarProdutoPorNome(produtos, nomePesquisa);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 3);
    }

    // Função para ler o arquivo JSON e retornar uma lista de produtos
    private static List<Produto> lerArquivoJSON(String nomeArquivo) {
        try (FileReader reader = new FileReader(nomeArquivo)) {
            Gson gson = new Gson();
            Type tipoListaProdutos = new TypeToken<List<Produto>>(){}.getType();
            return gson.fromJson(reader, tipoListaProdutos);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Função para listar todos os produtos
    private static void listarProdutos(List<Produto> produtos) {
        System.out.println("Produtos Disponíveis:");
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Descrição: " + produto.getDescricao());
            System.out.println("-------------------------");
        }
    }

    // Função para pesquisar produtos por nome
    private static void pesquisarProdutoPorNome(List<Produto> produtos, String nomePesquisa) {
        boolean encontrou = false;
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomePesquisa)) {
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Preço: " + produto.getPreco());
                System.out.println("Descrição: " + produto.getDescricao());
                System.out.println("-------------------------");
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum produto encontrado com o nome '" + nomePesquisa + "'.");
        }
    }
}
