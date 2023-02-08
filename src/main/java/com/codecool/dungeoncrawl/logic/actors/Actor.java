package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.Arrays;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;
    private int strength = 2;
    private Item[] inventory = new Item[0];

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (!(canHeroMove(nextCell))) {
            if (nextCell.getActor() != null) {
                battle(cell, nextCell);
                if (nextCell.getActor().getHealth() <= 0 & cell.getActor().getHealth() > 0) {
                    cell.setActor(null);
                    nextCell.setActor(this);
                    cell = nextCell;
                }
            } else {
                cell.setActor(null);
                nextCell.setActor(this);
                cell = nextCell;
            }

        } else {
            System.out.println("cant move there");
        }

    }

    private void battle(Cell playerCell, Cell monsterCell) {
        if ((playerHasSword())) {
            playerCell.getActor().setStrength(10);
        } else {
            playerCell.getActor().setStrength(5);
        }
        int monsterHealth = monsterCell.getActor().getHealth() - playerCell.getActor().getStrength();
        int playerHealth = playerCell.getActor().getHealth() - monsterCell.getActor().getStrength();

        monsterCell.getActor().setHealth(monsterHealth);
        playerCell.getActor().setHealth(playerHealth);
    }

    private boolean playerHasSword() {
        for (Item item : inventory) {
            if (item.getTileName().equals("sword")) return true;
        }
        return false;
    }

    private boolean canHeroMove(Cell nextCell) {
        return nextCell.getTileName().equals("wall");
    }
    public int getHealth() {
        return health;
    }
    public int getStrength(){
        return strength;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
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

    public void addItem(Item item) {
        Item[] array = Arrays.copyOf(inventory,inventory.length+1);
        array[inventory.length] = item;
        inventory = array;
    }

    public StringBuilder getInventory(){
        StringBuilder items = new StringBuilder();
        for( int i=0; i < inventory.length; i++) {
            items.append(inventory[i].getTileName());
            items.append(" ");
        }
        return items;
    }
    public Item[] getItems() {
        return inventory;
    }

}
