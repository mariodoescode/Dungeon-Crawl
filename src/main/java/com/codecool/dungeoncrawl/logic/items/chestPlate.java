package com.codecool.dungeoncrawl.logic.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class chestPlate extends Item{

    public chestPlate(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "chest-plate";
    }
}

