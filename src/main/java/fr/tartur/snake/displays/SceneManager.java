package fr.tartur.snake.displays;

import javax.swing.*;
import java.awt.*;

public class SceneManager extends JFrame {

    public SceneManager() {
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        super.setSize(500, 500);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setLayout(new CardLayout());
    }

    public void addScene(String name, JComponent component) {
        super.add(name, component);
    }

    public void switchScene(String name) {
        this.getCardLayout().show(this, name);
    }

    private CardLayout getCardLayout() {
        return (CardLayout) super.getLayout();
    }

}
