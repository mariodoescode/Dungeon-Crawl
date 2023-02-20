package com.codecool.dungeoncrawl.logic;


import com.codecool.dungeoncrawl.logic.actors.Ghost;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;

import java.util.ArrayList;


public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;
    private Ghost ghost;
    private ArrayList<Skeleton> skeletons = new ArrayList<>();


    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setGhost(Ghost ghost) {
        this.ghost = ghost;
    }
    public void addSkeleton(Skeleton skeleton) {
        skeletons.add(skeleton);
    }


    public Player getPlayer() {
        return player;
    }

    public Ghost getGhost() {
        return ghost;
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public ArrayList<Skeleton> getSkeleton() {
        return skeletons;
    }

}
