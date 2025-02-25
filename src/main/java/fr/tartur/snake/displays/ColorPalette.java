package fr.tartur.snake.displays;

import java.awt.*;

public enum ColorPalette {

    DARK_GREEN(114f / 360f, 0.5f, 0.5f),
    GREEN(114f / 360f, 0.5f, 0.8f),
    RED(0f, 0.75f, 0.75f),
    SNAKE(249f / 360f, 0.7f, 1.0f);

    private final Color color;

    ColorPalette(float h, float s, float b) {
        this.color = Color.getHSBColor(h, s, b);
    }

    public Color get() {
        return color;
    }

}
