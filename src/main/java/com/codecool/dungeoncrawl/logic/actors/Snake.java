package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Snake extends Actor{
    private final int strength = 4;
    private final int health = 10;
    public Snake(Cell cell) {
        super(cell);
        setStrength(strength);
        setHealth(health);
    }

    @Override
    public String getTileName() {
        return "snake";
    }
}
