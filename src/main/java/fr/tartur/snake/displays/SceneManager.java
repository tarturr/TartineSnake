package fr.tartur.snake.displays;

import javax.swing.*;

public class SceneManager extends JFrame {

    public SceneManager() {
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setSize(500, 500);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
    }

    public void switchScene(JComponent from, JComponent to) {
        super.setVisible(false);
        super.remove(from);
        super.add(to);
        super.setVisible(true);
    }

}
