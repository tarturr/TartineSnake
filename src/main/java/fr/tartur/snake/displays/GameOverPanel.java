package fr.tartur.snake.displays;

import fr.tartur.snake.displays.components.PlayButton;
import fr.tartur.snake.displays.components.QuitButton;
import fr.tartur.snake.displays.components.TransparentCenteredPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameOverPanel extends JPanel {

    public GameOverPanel(JFrame window, int score) {
        super(new GridLayout(6, 1, 0, 15));
        super.setBackground(Color.BLACK);
        super.setBorder(new EmptyBorder(50, 50, 50, 50));

        final JLabel gameOver = new JLabel("Vous avez perdu !");
        gameOver.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        gameOver.setForeground(Color.WHITE);

        final JLabel scoreDisplay = new JLabel("Score atteint : " + score);
        scoreDisplay.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        scoreDisplay.setForeground(Color.WHITE);

        final PlayButton replay = new PlayButton("Réessayer", window, this);

        super.add(Box.createVerticalBox());
        super.add(new TransparentCenteredPanel(gameOver));
        super.add(new TransparentCenteredPanel(scoreDisplay));
        super.add(replay);
        super.add(new QuitButton(window));
        super.add(Box.createVerticalBox());
    }

}
