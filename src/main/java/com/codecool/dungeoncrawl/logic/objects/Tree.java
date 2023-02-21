package com.codecool.dungeoncrawl.logic.objects;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.objects.Object;

public class Tree extends Object {
    public Tree(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "tree";
    }
}