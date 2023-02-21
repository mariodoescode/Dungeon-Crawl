package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;

public class CrimsonDoor extends Object{
    public CrimsonDoor(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "crimson-door";
    }
}
