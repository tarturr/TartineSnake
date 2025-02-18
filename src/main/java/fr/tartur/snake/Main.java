package fr.tartur.snake;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Tartine's Snake");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(500, 500);
        window.setLocationRelativeTo(null);
        window.add(new SnakeGamePanel());
        window.setResizable(false);
        window.setVisible(true);
    }
}