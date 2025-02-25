package fr.tartur.snake;

import fr.tartur.snake.displays.MenuPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Tartine's Snake");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(500, 500);
        window.setLocationRelativeTo(null);
        window.add(new MenuPanel(window));
        window.setResizable(false);
        window.setVisible(true);
    }
}