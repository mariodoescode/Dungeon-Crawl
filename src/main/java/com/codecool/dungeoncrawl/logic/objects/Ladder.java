package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;


public class Ladder extends Object {
    public Ladder(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "ladder";
    }
}
