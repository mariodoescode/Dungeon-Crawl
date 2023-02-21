package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class leprechaunBoss extends Actor {

    public leprechaunBoss(Cell cell) {
        super(cell);
        int strength = 10;
        setStrength(strength);
        int health = 25;
        setHealth(health);

    }

    @Override
    public String getTileName() {
        return "leprechaun-boss";
    }
}
