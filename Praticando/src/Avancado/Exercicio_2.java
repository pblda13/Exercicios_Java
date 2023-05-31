package Avancado;

import java.util.Scanner;

public class Exercicio_2 {
    public static void main(String[] args) {

        //Exercício 2: Escreva um programa em Java que implemente uma calculadora científica. O programa deve permitir ao usuário
        // realizar operações matemáticas avançadas, como exponenciação, radiciação, trigonometria, logaritmo, entre outras.


        Scanner scanner = new Scanner(System.in);

        System.out.println("Calculadora Científica");
        System.out.println("======================");
        System.out.println("Selecione a operação:");
        System.out.println("1. Exponenciação");
        System.out.println("2. Radiciação");
        System.out.println("3. Trigonometria");
        System.out.println("4. Logaritmo");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.print("Digite a base: ");
                double base = scanner.nextDouble();
                System.out.print("Digite o expoente: ");
                double expoente = scanner.nextDouble();
                double resultadoExponenciacao = Math.pow(base, expoente);
                System.out.println("Resultado: " + resultadoExponenciacao);
            }
            case 2 -> {
                System.out.print("Digite o número: ");
                double numero = scanner.nextDouble();
                double resultadoRadiciacao = Math.sqrt(numero);
                System.out.println("Resultado: " + resultadoRadiciacao);
            }
            case 3 -> {
                System.out.println("Selecione a função trigonométrica:");
                System.out.println("1. Seno");
                System.out.println("2. Cosseno");
                System.out.println("3. Tangente");
                System.out.print("Opção: ");
                int opcaoTrigonometria = scanner.nextInt();
                System.out.print("Digite o ângulo em radianos: ");
                double angulo = scanner.nextDouble();
                double resultadoTrigonometria;
                switch (opcaoTrigonometria) {
                    case 1:
                        resultadoTrigonometria = Math.sin(angulo);
                        System.out.println("Resultado: " + resultadoTrigonometria);
                        break;
                    case 2:
                        resultadoTrigonometria = Math.cos(angulo);
                        System.out.println("Resultado: " + resultadoTrigonometria);
                        break;
                    case 3:
                        resultadoTrigonometria = Math.tan(angulo);
                        System.out.println("Resultado: " + resultadoTrigonometria);
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
            case 4 -> {
                System.out.print("Digite o número: ");
                double numeroLog = scanner.nextDouble();
                double resultadoLog = Math.log(numeroLog);
                System.out.println("Resultado: " + resultadoLog);
            }
            default -> System.out.println("Opção inválida");
        }
    }
}

