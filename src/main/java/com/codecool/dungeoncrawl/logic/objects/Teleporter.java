package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;


public class Teleporter extends Object {
    public Teleporter(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "teleporter";
    }
}
