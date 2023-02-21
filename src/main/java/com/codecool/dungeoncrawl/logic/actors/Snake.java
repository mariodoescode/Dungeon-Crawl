package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Snake extends Actor{
    public Snake(Cell cell) {
        super(cell);
        int strength = 25;
        setStrength(strength);
        int health = 35;
        setHealth(health);
    }

    @Override
    public String getTileName() {
        return "snake";
    }
}
