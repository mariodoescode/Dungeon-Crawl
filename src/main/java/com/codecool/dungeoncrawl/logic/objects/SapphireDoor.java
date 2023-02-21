package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;

public class SapphireDoor extends Object{
    public SapphireDoor(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "sapphire-door";
    }
}
