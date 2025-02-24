package fr.tartur.snake;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MenuPanel extends JPanel {

    public MenuPanel(JFrame window) {
        final var layout = new GridLayout(3, 1, 0, 20);
        super.setLayout(layout);
        super.setBorder(new EmptyBorder(50, 50, 50, 50));

        final JLabel title = new JLabel("Bienvenue sur le snake de Tartine !");
        title.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);
        super.add(title);

        final JButton play = newButton("Jouer", SnakeGamePanel.GREEN);
        play.addActionListener(_ -> {
            window.setVisible(false);
            window.remove(this);
            window.add(new SnakeGamePanel());
            window.setVisible(true);
        });

        final JButton quit = newButton("Quitter", SnakeGamePanel.DARK_GREEN);
        quit.addActionListener(_ -> window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING)));

        super.add(play);
        super.add(quit);
    }

    private static JButton newButton(String label, Color color) {
        final JButton button = new JButton(label);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        return button;
    }

}
