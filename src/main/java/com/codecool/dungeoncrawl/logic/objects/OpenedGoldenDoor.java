package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;

public class OpenedGoldenDoor extends Object{
    public OpenedGoldenDoor(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "opened-golden-door";
    }
}
