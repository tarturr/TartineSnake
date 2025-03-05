package fr.tartur.snake.displays.components;

import fr.tartur.snake.displays.Palette;

public class PartyButton extends ActionButton {

    public PartyButton(String name) {
        super(name, Palette.SNAKE.getColor(), ignored -> {
            System.out.println("Joined party " + name);
        });
    }

}
