package fr.tartur.snake.displays.components;

import fr.tartur.snake.displays.ColorPalette;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class QuitButton extends ActionButton {

    public QuitButton(JFrame window) {
        super("Quitter", ColorPalette.RED.get(),
                ignored -> window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING)));
    }

}
