package fr.tartur.snake.displays;

import fr.tartur.snake.displays.components.PlayButton;
import fr.tartur.snake.displays.components.QuitButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(JFrame window) {
        final var layout = new GridLayout(3, 1, 0, 20);
        super.setLayout(layout);
        super.setBorder(new EmptyBorder(50, 50, 50, 50));

        final JLabel title = new JLabel("Bienvenue sur le snake de Tartine !");
        title.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);
        super.add(title);

        final PlayButton play = new PlayButton("Jouer", window, this);

        super.add(play);
        super.add(new QuitButton(window));
    }

}
