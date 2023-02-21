package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class goldenKey extends Item{
    public goldenKey(Cell cell) {
        super(cell);
    }
    @Override
    public String getTileName() {
        return "golden-key";
    }
}
