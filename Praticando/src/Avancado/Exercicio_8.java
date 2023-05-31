package Avancado;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

public class Exercicio_8 {
    public static void main(String[] args) {
        //Exercício 8: Escreva um programa em Java que leia um arquivo de imagem e implemente algoritmos de processamento de imagem,
        // como redimensionamento, rotação, detecção de bordas ou filtragem.

        try {
            // Carrega a imagem do arquivo
            BufferedImage image = ImageIO.read(new File("imagem.jpg"));

            // Exibe informações sobre a imagem original
            System.out.println("Dimensões originais: " + image.getWidth() + "x" + image.getHeight());

            // Redimensiona a imagem
            int newWidth = image.getWidth() / 2;
            int newHeight = image.getHeight() / 2;
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(image, 0, 0, newWidth, newHeight, null);
            g2d.dispose();

            // Salva a imagem redimensionada em um novo arquivo
            File resizedFile = new File("imagem_redimensionada.jpg");
            ImageIO.write(resizedImage, "jpg", resizedFile);

            // Exibe informações sobre a imagem redimensionada
            System.out.println("Dimensões redimensionadas: " + resizedImage.getWidth() + "x" + resizedImage.getHeight());

            // Detecta as bordas na imagem redimensionada
            BufferedImage edgeImage = detectEdges(resizedImage);

            // Salva a imagem com as bordas detectadas em um novo arquivo
            File edgeFile = new File("imagem_com_bordas.jpg");
            ImageIO.write(edgeImage, "jpg", edgeFile);

            System.out.println("Imagem com bordas detectadas salva: " + edgeFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage detectEdges(BufferedImage image) {
        BufferedImage edgeImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        // Aplica o filtro de detecção de bordas na imagem
        float[] edgeKernel = {-1, -1, -1, -1, 8, -1, -1, -1, -1};
        ConvolveOp edgeOp = new ConvolveOp(new Kernel(3, 3, edgeKernel), ConvolveOp.EDGE_NO_OP, null);
        edgeOp.filter(image, edgeImage);

        return edgeImage;
    }
}
