package fr.tartur.snake;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SnakeGame {

	private final int columnCount;
	private final int lineCount;
	private final Snake snake;
	private final Point apple;
	private final PropertyChangeSupport support;

	private int score;
	private boolean gameOver;

	public SnakeGame() {
		this.columnCount = 20;
		this.lineCount = 20;
		this.snake = new Snake(new Point(10, 15), Direction.LEFT);
		this.apple = new Point(5, 10);
		this.support = new PropertyChangeSupport(this);

		this.score = 0;
		this.gameOver = false;
    }
	
	public void moveForward() {
		this.updateGameState();

		if (this.gameOver) {
			return;
		}
		
		if (this.snake.forward(this.apple)) {
			Random random = new Random();
			this.apple.setLocation(
					random.nextInt(0, this.columnCount),
					random.nextInt(0, this.lineCount)
			);
			
			++this.score;
		}
	}

	public int getColumnCount() {
		return columnCount;
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getScore() {
		return score;
	}

	public void setDirection(Direction direction) {
		this.snake.setDirection(direction);
	}

	public boolean isSnakeCell(Point position) {
		return this.snake.isBody(position);
	}

	public boolean isAppleCell(Point position) {
		return this.apple.equals(position);
	}

	private void updateGameState() {
		final Point head = this.snake.getHead();
		final boolean isOutOfColumns = head.x < 0 || head.x >= this.columnCount;
		final boolean isOutOfLines = head.y < 0 || head.y >= this.lineCount;

		this.gameOver = this.snake.collidesTail(head) || isOutOfColumns || isOutOfLines;

		if (this.gameOver) {
			this.support.firePropertyChange("gameOver", false, true);
		}
	}

	public void addGameOverListener(PropertyChangeListener listener) {
		this.support.addPropertyChangeListener(listener);
	}
	
}