package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class darkMageBoss extends Actor {

    public darkMageBoss(Cell cell) {
        super(cell);
        int strength = 15;
        setStrength(strength);
        int health = 35;
        setHealth(health);

    }

    @Override
    public String getTileName() {
        return "darkmage-boss";
    }
}
