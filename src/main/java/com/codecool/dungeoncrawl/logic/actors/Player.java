package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;



public class Player extends Actor {
    private int strength = 5;
    public Player(Cell cell) {
        super(cell);
        setStrength(strength);
    }
    public String getTileName() {
        return "player";
    }


}