package fr.tartur.snake.displays.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ActionButton extends JButton {

    public ActionButton(String text, Color color, ActionListener action) {
        super(text);
        super.setBackground(color);
        super.addActionListener(action);
        super.setFocusPainted(false);
        super.setBorderPainted(false);
        super.setForeground(Color.WHITE);
        super.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
    }

}
