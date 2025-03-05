package fr.tartur.snake;

import fr.tartur.snake.displays.MenuPanel;
import fr.tartur.snake.displays.SceneManager;

public class Main {

    public static void main(String[] args) {
        SceneManager scene = new SceneManager();
        scene.add(new MenuPanel(scene));
        scene.setVisible(true);
    }

}