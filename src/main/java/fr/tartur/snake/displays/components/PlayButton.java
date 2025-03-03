package fr.tartur.snake.displays.components;

import fr.tartur.snake.displays.Palette;
import fr.tartur.snake.displays.SnakeGamePanel;

import javax.swing.*;

public class PlayButton extends ActionButton {

    public PlayButton(String text, JFrame window, JPanel old) {
        super(text, Palette.GREEN.getColor(), ignored -> {
            window.setVisible(false);
            window.remove(old);
            window.add(new SnakeGamePanel(window));
            window.setVisible(true);
        });
    }
}
