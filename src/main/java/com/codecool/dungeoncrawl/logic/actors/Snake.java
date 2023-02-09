package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Snake extends Actor{
    public Snake(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "snake";
    }
}
