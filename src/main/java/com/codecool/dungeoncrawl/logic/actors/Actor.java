package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (!(canHeroMove(nextCell))) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        } else {
            System.out.println("cant move there");
        }

    }
    private boolean canHeroMove(Cell nextCell) {
        if (nextCell.getActor() != null) return nextCell.getTileName().equals("wall") || nextCell.getActor().getTileName().equals("skeleton");
        return nextCell.getTileName().equals("wall");
    }
    public int getHealth() {
        return health;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

//    public String getActorName() {
//        return
//    }

}
