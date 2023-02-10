package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.Arrays;

public abstract class Actor implements Drawable {
    Cell cell;
    private int health = 10;
    private int strength;
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

        }
    }

    private void battle(Cell playerCell, Cell monsterCell) {
        if (playerHasWeapon("sword")) {
            playerCell.getActor().setStrength(5);
        } else if (playerHasWeapon("bow")) {
            playerCell.getActor().setStrength(10);
        }
        int monsterHealth = monsterCell.getActor().getHealth() - playerCell.getActor().getStrength();
        int playerHealth = playerCell.getActor().getHealth() - monsterCell.getActor().getStrength();
        monsterCell.getActor().setHealth(monsterHealth);
        if (monsterHealth > 0) playerCell.getActor().setHealth(playerHealth);


    }

    private boolean playerHasWeapon(String weapon) {
        for (Item item : inventory) {
            if (item.getTileName().equals(weapon)) return true;
        }
        return false;
    }

    boolean canHeroMove(Cell nextCell) {
        if (nextCell.getObject() != null) return nextCell.getTileName().equals("wall") || nextCell.getObject().getTileName().equals("closed-door");
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
        this.strength += strength;
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
        for (Item item : inventory) {
            items.append(item.getTileName());
            items.append(" ");
        }
        return items;
    }
    public Item[] getItems() {
        return inventory;
    }

}
