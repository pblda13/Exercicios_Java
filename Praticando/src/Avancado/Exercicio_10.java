package Avancado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Exercicio_10 {

    public static void main(String[] args) {

        //Exercício 10: Escreva um programa em Java que simule um servidor web. O programa deve ser capaz de receber solicitações HTTP,
        // processá-las e retornar respostas adequadas, como exibir páginas HTML ou fornecer arquivos estáticos.

        int port = 8080; // Porta do servidor web
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor web iniciado na porta " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                // Ler a solicitação do cliente
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String request = reader.readLine();

                // Processar a solicitação e retornar a resposta adequada
                String response = processRequest(request);

                // Enviar a resposta para o cliente
                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write(response.getBytes("UTF-8"));

                // Fechar as conexões
                outputStream.close();
                reader.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processRequest(String request) {
        String[] lines = request.split("\r\n");
        String[] requestLine = lines[0].split(" ");
        String method = requestLine[0];
        String path = requestLine[1];

        // Processar a solicitação com base no método HTTP
        switch (method) {
            case "GET":
                return processGetRequest(path);
            case "POST":
                return processPostRequest(path, lines);
            case "PUT":
                return processPutRequest(path, lines);
            case "DELETE":
                return processDeleteRequest(path);
            default:
                return "HTTP/1.1 405 Method Not Allowed\r\n\r\n";
        }
    }

    private static String processGetRequest(String path) {
        // Lógica para processar uma solicitação GET
        // Aqui você pode retornar a resposta adequada, como uma página HTML, um arquivo estático, etc.
        if (path.equals("/")) {
            return "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<html><body><h1>Página Inicial</h1><p>Esta é a página inicial do servidor web.</p></body></html>";
        } else if (path.equals("/about")) {
            return "HTTP/1.1 200 OK\r\n"
                    + "Content-Type: text/html\r\n"
                    + "\r\n"
                    + "<html><body><h1>Sobre</h1><p>Esta é a página de informações sobre o servidor web.</p></body></html>";
        } else {
            return "HTTP/1.1 404 Not Found\r\n\r\n";
        }
    }

    private static String processPostRequest(String path, String[] lines) {
        // Lógica para processar uma solicitação POST
        // Aqui você pode extrair os dados enviados no corpo da solicitação e realizar alguma ação, como adicionar um registro em um banco de dados

        // Exemplo de resposta
        return "HTTP/1.1 200 OK\r\n\r\n";
    }

    private static String processPutRequest(String path, String[] lines) {
        // Lógica para processar uma solicitação PUT
        // Aqui você pode extrair os dados enviados no corpo da solicitação e realizar alguma ação, como atualizar um registro em um banco de dados

        // Exemplo de resposta
        return "HTTP/1.1 200 OK\r\n\r\n";
    }

    private static String processDeleteRequest(String path) {
        // Lógica para processar uma solicitação DELETE
        // Aqui você pode realizar uma ação, como excluir um registro em um banco de dados

        // Exemplo de resposta
        return "HTTP/1.1 200 OK\r\n\r\n";
    }

}
