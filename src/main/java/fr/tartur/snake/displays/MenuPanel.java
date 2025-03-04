package fr.tartur.snake.displays;

import fr.tartur.snake.displays.components.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(JFrame window) {
        final var layout = new GridLayout(4, 1, 0, 20);
        super.setLayout(layout);
        super.setBorder(new EmptyBorder(50, 50, 50, 50));

        final TitleLabel title = new TitleLabel("Bienvenue sur le snake de Tartine !", 20, Color.BLACK);
        super.add(new TransparentCenteredPanel(title));

        final PlayButton solo = new PlayButton("Mode Solo", window, this);
        final ActionButton multiplayer = new ActionButton("Mode Multijoueur", Palette.DARK_GREEN.getColor(), ignored -> {
            // ...
        });

        super.add(solo);
        super.add(multiplayer);
        super.add(new QuitButton(window));
    }

}
