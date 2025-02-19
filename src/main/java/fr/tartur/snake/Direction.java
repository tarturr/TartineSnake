package fr.tartur.snake;

import java.awt.*;

public enum Direction {

    UP(new Point(0, -1)),
    LEFT(new Point(-1, 0)),
    DOWN(new Point(0, 1)),
    RIGHT(new Point(1, 0));

    private final Point point;

    Direction(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

}
