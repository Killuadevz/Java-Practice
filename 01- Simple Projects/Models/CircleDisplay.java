package Models;

import java.awt.*;
import javax.swing.*;

public class CircleDisplay extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);

        int x = (getWidth() - 100) / 2;
        int y = (getHeight() - 100) / 2;

        int largura = 100;
        int altura = 100;

        g.fillOval(x, y, largura, altura);
    }

    public static void main(String[] args) {
        JFrame janela = new JFrame("Exibir Círculo");
        CircleDisplay painel = new CircleDisplay();


        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(400, 400);
        janela.add(painel);
        janela.setVisible(true);
    }
}
