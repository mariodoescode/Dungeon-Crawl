package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.objects.Object;

public class Grass extends Object {
    public Grass(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "grass";
    }
}
