package fr.tartur.snake;

import java.awt.*;
import java.util.Random;

public class SnakeGame {

	private final int columnCount;
	private final int lineCount;
	private final Snake snake;
	private final Point apple;

	private int score;

	public SnakeGame() {
		this.columnCount = 20;
		this.lineCount = 20;
		this.snake = new Snake(new Point(10, 15), Direction.UP);
		this.apple = new Point(5, 10);

		this.score = 0;
	}
	
	public void moveForward() {
		if (this.isGameOver()) {
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

	private boolean isGameOver() {
		final Point head = this.snake.getHead();
		final boolean isOutOfColumns = head.x < 0 || head.x >= this.columnCount;
		final boolean isOutOfLines = head.y < 0 || head.y >= this.lineCount;

		return this.snake.collidesTail(head) || isOutOfColumns || isOutOfLines;
	}
	
}