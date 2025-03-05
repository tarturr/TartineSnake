package fr.tartur.snake.displays;

import fr.tartur.snake.logic.ArrowKeyHandler;
import fr.tartur.snake.logic.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Timer;
import java.util.TimerTask;

public class SnakeGamePanel extends JPanel implements PropertyChangeListener {

	private final JLabel label;
	private final int borderSize;
    private final SceneManager scene;

	private SnakeGame game;
	private Timer gameScheduler;

    public SnakeGamePanel(SceneManager scene) {
		this.start();
        this.scene = scene;
		this.label = new JLabel("Score actuel : " + game.getScore());
		this.borderSize = 10;

		super.setFocusable(true);
		super.addKeyListener(new ArrowKeyHandler(this.game));
	}

	protected void paintComponent(Graphics graphics) {
		graphics.clearRect(0, 0, super.getWidth(), super.getHeight());
		
		for (int line = 0; line < game.getLineCount(); line++) {
			for (int column = 0; column < game.getColumnCount(); column++) {
				drawCell(graphics, new Point(column, line));
			}
		}

		graphics.setFont(Font.getFont(Font.SANS_SERIF));
		graphics.setColor(Color.BLACK);
		
		super.add(label);
	}

	private void drawCell(Graphics g, Point position) {
		final int cellWidth = this.getCellWidth();
		final int cellHeight = this.getCellHeight();

		final int cellX = this.getCellX(cellWidth, position.x);
		final int cellY = this.getCellY(cellHeight, position.y);

		Color cellColor = Palette.DARK_GREEN.getColor();
		label.setText("Score actuel : " + game.getScore());

		if (game.isSnakeCell(position)) {
			cellColor = Palette.SNAKE.getColor();
		} else if (game.isAppleCell(position)) {
			cellColor = Color.RED;
		} else if ((position.x + position.y) % 2 != 0) {
			cellColor = Palette.GREEN.getColor();
		}

		g.setColor(cellColor);
		g.fillRect(cellX, cellY, cellWidth, cellHeight);
	}
	
	private int getBorderSize() {
		return this.borderSize;
	}

	private int getCellWidth() {
		return (super.getWidth() - this.getBorderSize() * 2) / game.getColumnCount();
	}

	private int getCellHeight() {
		return (super.getHeight() - this.getBorderSize() * 2) / game.getLineCount();
	}

	private int getCellX(int cellWidth, int column) {
		return cellWidth * column + this.getBorderSize();
	}

	private int getCellY(int cellHeight, int line) {
		return cellHeight * line + this.getBorderSize();
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equals("gameOver")) {
			this.gameScheduler.cancel();
			this.scene.switchScene(this, new GameOverPanel(this.scene, this.game.getScore()));
		}
	}

	public void start() {
		this.game = new SnakeGame();
		this.game.addGameOverListener(this);

		this.gameScheduler = new Timer();
		this.gameScheduler.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				game.moveForward();
				repaint();
			}
		}, 1000, 200);
	}
}