package fr.tartur.snake.displays.components;

import javax.swing.*;
import java.awt.*;

public class TitleLabel extends JLabel {

    public TitleLabel(String text, int size, Color color) {
        super(text);

        super.setFont(new Font(Font.SANS_SERIF, Font.BOLD, size));
        super.setForeground(color);
    }
    
}
