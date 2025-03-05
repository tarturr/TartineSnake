package fr.tartur.snake.displays;

import fr.tartur.snake.displays.components.PlayButton;
import fr.tartur.snake.displays.components.QuitButton;
import fr.tartur.snake.displays.components.TitleLabel;
import fr.tartur.snake.displays.components.TransparentCenteredPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameOverPanel extends JPanel {

    public GameOverPanel(SceneManager scene, int score) {
        super(new GridLayout(6, 1, 0, 15));
        super.setBackground(Color.BLACK);
        super.setBorder(new EmptyBorder(50, 50, 50, 50));

        final TitleLabel gameOverTitle = new TitleLabel("Vous avez perdu !", 25, Color.WHITE);
        final TitleLabel scoreTitle = new TitleLabel("Score atteint : " + score, 15, Color.WHITE);

        final PlayButton replay = new PlayButton("Réessayer", scene, this);
        final QuitButton quit = new QuitButton(scene);

        super.add(Box.createVerticalBox());
        super.add(new TransparentCenteredPanel(gameOverTitle));
        super.add(new TransparentCenteredPanel(scoreTitle));
        super.add(replay);
        super.add(quit);
        super.add(Box.createVerticalBox());
    }

}
