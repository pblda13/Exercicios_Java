package Avancado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Exercício 6: Escreva um programa em Java que implemente um sistema de gestão de estoque. O programa deve permitir ao usuário adicionar produtos,
// atualizar quantidades, exibir relatórios de estoque e fazer vendas, registrando as saídas de produtos.
class Product {
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class InventoryManagementSystem {
    private List<Product> products;

    public InventoryManagementSystem() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Produto adicionado com sucesso!");
    }

    public void updateProductQuantity(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                product.setQuantity(quantity);
                System.out.println("Quantidade do produto atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    public void displayInventory() {
        System.out.println("Relatório de estoque:");
        for (Product product : products) {
            System.out.println("Nome do produto: " + product.getName());
            System.out.println("Quantidade: " + product.getQuantity());
            System.out.println("-------------------------");
        }
    }

    public void sellProduct(String productName, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                if (product.getQuantity() >= quantity) {
                    product.setQuantity(product.getQuantity() - quantity);
                    System.out.println("Venda registrada com sucesso!");
                } else {
                    System.out.println("Quantidade insuficiente em estoque!");
                }
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }
}

public class Exercicio_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManagementSystem inventorySystem = new InventoryManagementSystem();

        while (true) {
            System.out.println("Sistema de Gestão de Estoque");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Atualizar quantidade de produto");
            System.out.println("3 - Exibir relatório de estoque");
            System.out.println("4 - Realizar venda");
            System.out.println("5 - Sair");

            int option = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (option) {
                case 1:
                    System.out.println("Digite o nome do produto:");
                    String name = scanner.nextLine();
                    System.out.println("Digite a quantidade do produto:");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    Product product = new Product(name, quantity);
                    inventorySystem.addProduct(product);
                    break;
                case 2:
                    System.out.println("Digite o nome do produto:");
                    String productName = scanner.nextLine();
                    System.out.println("Digite a nova quantidade do produto:");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    inventorySystem.updateProductQuantity(productName, newQuantity);
                    break;
                case 3:
                    inventorySystem.displayInventory();
                    break;
                case 4:
                    System.out.println("Digite o nome do produto:");
                    String productToSell = scanner.nextLine();
                    System.out.println("Digite a quantidade a ser vendida:");
                    int quantityToSell = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    inventorySystem.sellProduct(productToSell, quantityToSell);
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}

