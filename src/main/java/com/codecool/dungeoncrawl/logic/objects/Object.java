package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Object implements Drawable {
    private Cell cell;

    public Object(Cell cell) {
        this.cell = cell;
        this.cell.setObject(this);
    }

}
