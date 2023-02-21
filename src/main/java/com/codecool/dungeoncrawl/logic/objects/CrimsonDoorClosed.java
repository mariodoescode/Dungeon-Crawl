package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;

public class CrimsonDoorClosed extends Object{
    public CrimsonDoorClosed(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "crimson-door-closed";
    }
}
