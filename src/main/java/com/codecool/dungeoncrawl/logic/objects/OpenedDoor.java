package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;

public class OpenedDoor extends Object{
    public OpenedDoor(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "open-door";
    }
}
