package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;

public class SapphireDoorClosed extends Object{
    public SapphireDoorClosed(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "sapphire-door-closed";
    }
}
