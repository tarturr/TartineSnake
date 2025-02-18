package fr.tartur.snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGame {
	private final int columnCount;
	private final int lineCount;
	private final List<Point> snake;
	private final Point apple;

	private Point direction;
	private int score;

	public SnakeGame() {
		this.columnCount = 30;
		this.lineCount = 20;
		this.score = 0;

		this.snake = new ArrayList<>();
		this.snake.add(new Point(10, 15));
		this.snake.add(new Point(10, 16));
		this.snake.add(new Point(10, 17));

		this.apple = new Point(5, 10);
		this.direction = new Point(1, 0);
	}
	
	public void moveForward() {
		if (this.isGameOver()) {
			return;
		}

		Point next = this.getNextSnakeHeadPosition();
		this.snake.addFirst(next);
		
		if (this.isSnakeHead(this.apple)) {
			Random random = new Random();
			this.apple.setLocation(
					random.nextInt(0, this.columnCount),
					random.nextInt(0, this.lineCount)
			);
			
			++this.score;
		} else {
			this.snake.removeLast();
		}
	}

	public int getColumnCount() {
		return columnCount;
	}

	public int getLineCount() {
		return lineCount;
	}

	public Point getSnakeHead() {
		return this.snake.getFirst();
	}

	public Point getSnakeNeck() {
		return this.snake.get(1);
	}

	private Point getNextSnakeHeadPosition() {
		final Point head = this.getSnakeHead();
		final int nextX = head.x + this.direction.x;
		final int nextY = head.y + this.direction.y;

		return new Point(nextX, nextY);
	}

	public int getScore() {
		return score;
	}

	public void setDirection(Point direction) {
		Point lastDirection = this.direction;
		this.direction = direction;

		if (this.getNextSnakeHeadPosition().equals(this.getSnakeNeck())) {
			this.direction = lastDirection;
		}
	}

	public boolean isSnakeCell(Point position) {
		for (Point bodyPosition : this.snake) {
			if (bodyPosition.equals(position)) {
				return true;
			}
		}

		return false;
	}

	public boolean isAppleCell(Point position) {
		return this.apple.equals(position);
	}

	public boolean isBlackCell(Point position) {
		boolean cellIsBlack;
		
		if (position.y % 2 == 0) {
			cellIsBlack = position.x % 2 == 0;
		} else {
			cellIsBlack = position.x % 2 != 0;
		}
		
		return cellIsBlack;
	}
	
	public boolean isGrayCell(Point position) {
		return !this.isBlackCell(position);
	}

	public boolean isSnakeHead(Point position) {
		return this.getSnakeHead().equals(position);
	}

	private boolean isGameOver() {
		final Point head = this.getSnakeHead();
		final boolean isOutOfColumns = head.x < 0 || head.x >= this.columnCount;
		final boolean isOutOfLines = head.y < 0 || head.y >= this.lineCount;

		boolean isHeadOnBody = false;

		// On ne peut pas utiliser this.isSnakeCell() car cette méthode vérifie également si la position donnée est
		// celle de la tête du serpent. Si on l'utilisait, cela serait toujours true.
		// Je commence donc à l'index 1 pour éviter la position de la tête.
		for (int i = 1; i < this.snake.size(); i++) {
			final Point bodyPart = this.snake.get(i);

			if (head.equals(bodyPart)) {
				isHeadOnBody = true;
				break;
			}
		}

		return isHeadOnBody || isOutOfColumns || isOutOfLines;
	}
	
}