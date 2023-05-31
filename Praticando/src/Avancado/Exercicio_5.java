package Avancado;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Exercicio_5 {
    public static void main(String[] args) {

        //Exercício 5: Escreva um programa em Java que leia um arquivo XML contendo informações de livros (título, autor, ano)
        // e permita ao usuário realizar consultas e filtrar os livros com base em critérios específicos, como autor ou ano de publicação.

        try {
            // Carregar o arquivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("books.xml");

            // Obter a lista de elementos de livro
            NodeList bookList = document.getElementsByTagName("book");

            // Exibir todos os livros
            System.out.println("Livros disponíveis:");
            for (int i = 0; i < bookList.getLength(); i++) {
                Element bookElement = (Element) bookList.item(i);
                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                String year = bookElement.getElementsByTagName("year").item(0).getTextContent();
                System.out.println("Título: " + title);
                System.out.println("Autor: " + author);
                System.out.println("Ano de publicação: " + year);
                System.out.println("-------------------------");
            }

            // Realizar consultas e filtragens
            // Exemplo: Filtrar por autor
            String desiredAuthor = "John Doe";
            System.out.println("Livros do autor " + desiredAuthor + ":");
            for (int i = 0; i < bookList.getLength(); i++) {
                Element bookElement = (Element) bookList.item(i);
                String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                if (author.equals(desiredAuthor)) {
                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    String year = bookElement.getElementsByTagName("year").item(0).getTextContent();
                    System.out.println("Título: " + title);
                    System.out.println("Ano de publicação: " + year);
                    System.out.println("-------------------------");
                }
            }

            // Exemplo: Filtrar por ano de publicação
            int desiredYear = 2022;
            System.out.println("Livros publicados em " + desiredYear + ":");
            for (int i = 0; i < bookList.getLength(); i++) {
                Element bookElement = (Element) bookList.item(i);
                String year = bookElement.getElementsByTagName("year").item(0).getTextContent();
                if (Integer.parseInt(year) == desiredYear) {
                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                    System.out.println("Título: " + title);
                    System.out.println("Autor: " + author);
                    System.out.println("-------------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
