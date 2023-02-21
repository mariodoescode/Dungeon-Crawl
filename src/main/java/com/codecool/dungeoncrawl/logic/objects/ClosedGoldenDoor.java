package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;

public class ClosedGoldenDoor extends Object{
    public ClosedGoldenDoor(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "closed-golden-door";
    }
}
