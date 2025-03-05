package fr.tartur.snake.displays.components;

import fr.tartur.snake.displays.Palette;
import fr.tartur.snake.displays.SceneManager;
import fr.tartur.snake.displays.SnakeGamePanel;

import javax.swing.*;

public class PlayButton extends ActionButton {

    public PlayButton(String text, SceneManager scene, JPanel from) {
        super(text, Palette.GREEN.getColor(), ignored -> scene.switchScene(from, new SnakeGamePanel(scene)));
    }

}
