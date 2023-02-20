package com.codecool.dungeoncrawl.logic;


import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.logic.actors.Skeleton;

import com.codecool.dungeoncrawl.logic.actors.Ghost;
import com.codecool.dungeoncrawl.logic.actors.Snake;
import com.codecool.dungeoncrawl.logic.items.*;
import com.codecool.dungeoncrawl.logic.objects.ClosedDoor;
import com.codecool.dungeoncrawl.logic.objects.Teleporter;


import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap() {
        InputStream is = MapLoader.class.getResourceAsStream("/game-map.txt");
        assert is != null;
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ' -> cell.setType(CellType.EMPTY);
                        case '#' -> cell.setType(CellType.WALL);
                        case '.' -> cell.setType(CellType.FLOOR);
                        case 's' -> {
                            cell.setType(CellType.FLOOR);
                            map.addSkeleton(new Skeleton(cell));
                        }
                        case '@' -> {
                            cell.setType(CellType.FLOOR);
//                            map.setPlayer(new Player(cell, "Player"));
                            map.setPlayer(new Player(cell));
                        }
                        case '$' -> {
                            cell.setType(CellType.FLOOR);
                            new goldenKey(cell);
                        }
                        case '|' -> {
                            cell.setType(CellType.FLOOR);
                            new sapphireKey(cell);
                        }
                        case '>' -> {
                            cell.setType(CellType.FLOOR);
                            new crimsonKey(cell);
                        }
                        case '*' -> {
                            cell.setType(CellType.FLOOR);
                            new Sword(cell);
                        }
                        case '5' -> {
                            cell.setType(CellType.FLOOR);
                            new Bow(cell);
                        }
                        case '6' -> {
                            cell.setType(CellType.FLOOR);
                            new Snake(cell);
                        }
                        case '7' -> {
                            cell.setType(CellType.FLOOR);
                            new ClosedDoor(cell);
                        }
                        case 'a' -> {
                            cell.setType(CellType.FLOOR);
                            map.setGhost(new Ghost(cell));
                        }
                        case '1' -> {
                            cell.setType(CellType.FLOOR);
                            new chestPlate(cell);
                        }
                        case '2' -> {
                            cell.setType(CellType.FLOOR);
                            new Helmet(cell);
                        }
                        case '3' -> {
                            cell.setType(CellType.FLOOR);
                            new Shield(cell);
                        }
                        case '4' -> {
                            cell.setType(CellType.FLOOR);
                            new Boots(cell);
                        }
                        case 'x' -> {
                            cell.setType(CellType.FLOOR);
                            new Teleporter(cell);
                        }
                        default -> throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
