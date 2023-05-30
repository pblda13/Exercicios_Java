package Intermediario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//Exercício 9: Escreva um programa em Java que implemente uma classe para representar uma agenda de contatos.
// A classe deve permitir adicionar contatos, remover contatos, listar todos os contatos e pesquisar por um contato específico.

class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone;
    }
}

class AgendaDeContatos {
    private List<Contato> contatos;

    public AgendaDeContatos() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(String nome, String telefone) {
        Contato contato = new Contato(nome, telefone);
        contatos.add(contato);
        System.out.println("Contato adicionado com sucesso!");
    }

    public void removerContato(String nome) {
        boolean encontrado = false;

        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatos.remove(contato);
                encontrado = true;
                System.out.println("Contato removido com sucesso!");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contato não encontrado na agenda.");
        }
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            System.out.println("Lista de contatos:");

            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }

    public void pesquisarContato(String nome) {
        boolean encontrado = false;

        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Contato encontrado:");
                System.out.println(contato);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contato não encontrado na agenda.");
        }
    }
}

public class Exercicio_9 {

    public static void main(String[] args) {
        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        AgendaDeContatos agenda = new AgendaDeContatos();

        boolean sair = false;

        while (!sair) {
            System.out.println("----- Menu da Agenda de Contatos -----");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Remover contato");
            System.out.println("3. Listar contatos");
            System.out.println("4. Pesquisar contato");
            System.out.println("5. Sair");
            System.out.println("--------------------------------------");
            System.out.println("Digite a opção desejada:");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o nome do contato:");
                    scanner.nextLine(); // Limpar o buffer do teclado
                    String nome = scanner.nextLine();
                    System.out.println("Digite o telefone do contato:");
                    String telefone = scanner.nextLine();
                    agenda.adicionarContato(nome, telefone);
                }
                case 2 -> {
                    System.out.println("Digite o nome do contato que deseja remover:");
                    scanner.nextLine(); // Limpar o buffer do teclado
                    String nomeRemover = scanner.nextLine();
                    agenda.removerContato(nomeRemover);
                }
                case 3 -> agenda.listarContatos();
                case 4 -> {
                    System.out.println("Digite o nome do contato que deseja pesquisar:");
                    scanner.nextLine(); // Limpar o buffer do teclado
                    String nomePesquisar = scanner.nextLine();
                    agenda.pesquisarContato(nomePesquisar);
                }
                case 5 -> {
                    sair = true;
                    System.out.println("Encerrando a agenda de contatos.");
                }
                default -> System.out.println("Opção inválida. Digite um número válido.");
            }
        }

        // Fecha o scanner
        scanner.close();

    }
}