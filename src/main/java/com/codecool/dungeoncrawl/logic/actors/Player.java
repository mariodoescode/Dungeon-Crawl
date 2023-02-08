package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.items.Key;

import java.lang.reflect.Array;
import java.util.Arrays;


public class Player extends Actor {
    public Player(Cell cell) {
        super(cell);
    }
    public String getTileName() {
        return "player";
    }


}