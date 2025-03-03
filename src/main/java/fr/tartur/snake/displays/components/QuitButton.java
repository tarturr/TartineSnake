package fr.tartur.snake.displays.components;

import fr.tartur.snake.displays.Palette;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class QuitButton extends ActionButton {

    public QuitButton(JFrame window) {
        super("Quitter", Palette.RED.getColor(),
                ignored -> window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING)));
    }

}
