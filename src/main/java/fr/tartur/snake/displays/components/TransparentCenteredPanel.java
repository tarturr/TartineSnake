package fr.tartur.snake.displays.components;

import javax.swing.*;
import java.awt.*;

public class TransparentCenteredPanel extends JPanel {

    public TransparentCenteredPanel(JComponent component) {
        super(new FlowLayout());
        super.add(component);
        super.setBackground(null);
    }

}
