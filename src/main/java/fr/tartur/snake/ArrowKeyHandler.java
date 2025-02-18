package fr.tartur.snake;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ArrowKeyHandler extends KeyAdapter {

    private final SnakeGame game;

    public ArrowKeyHandler(SnakeGame game) {
        this.game = game;
    }

    public void keyPressed(KeyEvent event) {
        final Point orientation = switch (event.getKeyCode()) {
            case KeyEvent.VK_UP    -> new Point(0, -1);
            case KeyEvent.VK_DOWN  -> new Point(0,  1);
            case KeyEvent.VK_LEFT  -> new Point(-1, 0);
            case KeyEvent.VK_RIGHT -> new Point(1,  0);
            default -> null;
        };

        if (orientation != null) {
            this.game.setDirection(orientation);
        }
    }

}
