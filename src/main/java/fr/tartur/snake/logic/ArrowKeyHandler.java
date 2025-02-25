package fr.tartur.snake.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ArrowKeyHandler extends KeyAdapter {

    private final SnakeGame game;

    public ArrowKeyHandler(SnakeGame game) {
        this.game = game;
    }

    public void keyPressed(KeyEvent event) {
        final Direction orientation = switch (event.getKeyCode()) {
            case KeyEvent.VK_UP    -> Direction.UP;
            case KeyEvent.VK_DOWN  -> Direction.DOWN;
            case KeyEvent.VK_LEFT  -> Direction.LEFT;
            case KeyEvent.VK_RIGHT -> Direction.RIGHT;
            default -> null;
        };

        if (orientation != null) {
            this.game.setDirection(orientation);
        }
    }

}
