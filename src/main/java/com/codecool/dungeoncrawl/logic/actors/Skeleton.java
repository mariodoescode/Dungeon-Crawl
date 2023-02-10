package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell);
        setStrength(2);
    }
//    public void move() {
//        Cell nextCell = cell.getNeighbor(0,3);
//        if (canHeroMove(nextCell)) {
//            cell.setActor(null);
//            nextCell.setActor(this);
//            cell = nextCell;
//        }
//    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
