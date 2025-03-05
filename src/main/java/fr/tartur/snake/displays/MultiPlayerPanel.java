package fr.tartur.snake.displays;

import fr.tartur.snake.displays.components.ActionButton;
import fr.tartur.snake.displays.components.PartyButton;
import fr.tartur.snake.displays.components.TitleLabel;
import fr.tartur.snake.displays.components.TransparentCenteredPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MultiPlayerPanel extends JPanel {

    private final SceneManager scene;

    public MultiPlayerPanel(SceneManager scene) {
        this.scene = scene;
        super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final TitleLabel title = new TitleLabel("Multijoueur - Parties joignables", 20, Color.BLACK);
        title.setBorder(new EmptyBorder(20, 0, 20, 0));
        super.add(new TransparentCenteredPanel(title));

        final JPanel parties = new JPanel();
        parties.setLayout(new GridLayout(20, 1, 0, 10));
        parties.setBorder(new EmptyBorder(15, 15, 15, 15));

        // TODO: Add "main menu" button

        for (int i = 1; i <= 20; i++) {
            final PartyButton button = new PartyButton("Partie n°" + i);
            button.setAlignmentX(CENTER_ALIGNMENT);
            parties.add(button);
        }

        final JScrollPane scroll = new JScrollPane(parties);
        scroll.setBorder(null);
        super.add(scroll);
    }

}
