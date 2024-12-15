package Models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RotatingCube extends JPanel {
    private double[][] vertices = {
            {-1, -1, -1}, {-1, -1, 1}, {-1, 1, -1}, {-1, 1, 1},
            {1, -1, -1}, {1, -1, 1}, {1, 1, -1}, {1, 1, 1}
    };

    private int[][] edges = {
            {0, 1}, {1, 3}, {3, 2}, {2, 0}, // Front face
            {4, 5}, {5, 7}, {7, 6}, {6, 4}, // Back face
            {0, 4}, {1, 5}, {2, 6}, {3, 7}  // Side edges
    };

    private double angle = 0; // Rotation angle

    public RotatingCube() {
        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 0.05; // Increment rotation angle
                repaint(); // Redraw the cube
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 3D projection transformations
        double[][] projected = new double[8][2];
        for (int i = 0; i < vertices.length; i++) {
            double x = vertices[i][0];
            double y = vertices[i][1];
            double z = vertices[i][2];

            // Rotation around the Y axis
            double newX = x * Math.cos(angle) - z * Math.sin(angle);
            double newZ = x * Math.sin(angle) + z * Math.cos(angle);
            x = newX;
            z = newZ;

            // 3D to 2D projection
            projected[i][0] = x * 100 / (z + 4) + getWidth() / 2;
            projected[i][1] = -y * 100 / (z + 4) + getHeight() / 2;
        }

        // Draw the edges
        for (int[] edge : edges) {
            int x1 = (int) projected[edge[0]][0];
            int y1 = (int) projected[edge[0]][1];
            int x2 = (int) projected[edge[1]][0];
            int y2 = (int) projected[edge[1]][1];
            g2d.drawLine(x1, y1, x2, y2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Rotating 3D Cube");
        RotatingCube panel = new RotatingCube();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(panel);
        frame.setVisible(true);
    }
}
