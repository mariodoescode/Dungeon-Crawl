package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;

public class ClosedDoor extends Object{
    public ClosedDoor(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "closed-door";
    }
}
