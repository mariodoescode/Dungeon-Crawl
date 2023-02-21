package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class golemBoss extends Actor {


    public golemBoss(Cell cell) {
        super(cell);
        int strength = 5;
        setStrength(strength);
        int health = 15;
        setHealth(health);

    }

    @Override
    public String getTileName() {
        return "golem-boss";
    }
}