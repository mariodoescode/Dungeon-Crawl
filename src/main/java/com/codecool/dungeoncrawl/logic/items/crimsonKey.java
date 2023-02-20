package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class crimsonKey extends Item{
    public crimsonKey(Cell cell) {
        super(cell);
    }
    @Override
    public String getTileName() {
        return "crimson-key";
    }
}
