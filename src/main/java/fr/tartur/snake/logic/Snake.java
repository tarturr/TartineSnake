package fr.tartur.snake.logic;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    public static final Color BODY_COLOR = Color.getHSBColor(249f / 360f, 0.7f, 1.0f);

    private final List<Point> body;
    private Direction direction;

    public Snake(Point initialPosition, Direction direction) {
        this.body = new ArrayList<>(List.of(
                initialPosition,
                new Point(initialPosition.x + 1, initialPosition.y),
                new Point(initialPosition.x + 2, initialPosition.y))
        );
        this.direction = direction;
    }

    public boolean forward(Point applePosition) {
        this.body.addFirst(this.getNextPosition());

        if (this.isHead(applePosition)) {
            return true;
        }

        this.body.removeLast();
        return false;
    }

    public Point getHead() {
        return this.body.getFirst();
    }

    public Point getNextPosition() {
        final Point head = this.getHead();
        final Point direction = this.direction.getPoint();

        return new Point(
                head.x + direction.x,
                head.y + direction.y
        );
    }

    public void setDirection(Direction direction) {
        Direction lastDirection = this.direction;
        this.direction = direction;

        if (this.collidesTail(this.getNextPosition())) {
            this.direction = lastDirection;
        }
    }

    public boolean collidesTail(Point position) {
        return this.body.subList(1, this.body.size()).stream()
                .anyMatch(bodyPart -> bodyPart.equals(position));
    }

    public boolean isHead(Point position) {
        return this.getHead().equals(position);
    }

    public boolean isBody(Point position) {
        return this.body.stream().anyMatch(bodyPart -> bodyPart.equals(position));
    }

}
