package fr.tartur.snake.logic;

import java.awt.*;
import java.util.Random;

public class Apple extends Point {

    private final int columnCount;
    private final int lineCount;
    private final Random random;

    public Apple(int columnCount, int lineCount) {
        this.columnCount = columnCount;
        this.lineCount = lineCount;
        this.random = new Random();
        this.randomize();
    }

    public void randomize() {
        this.setLocation(
                this.random.nextInt(0, this.columnCount),
                this.random.nextInt(0, this.lineCount)
        );
    }

}
