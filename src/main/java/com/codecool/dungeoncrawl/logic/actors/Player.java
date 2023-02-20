package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;


public class Player extends Actor {
    private String name;

    public Player(Cell cell) {
            super(cell);
            setStrength(5);
        }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTileName() {
        return "player";
    }
}
