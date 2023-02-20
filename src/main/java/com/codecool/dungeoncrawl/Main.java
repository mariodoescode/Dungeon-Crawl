package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.dao.GameDatabaseManager;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;

import com.codecool.dungeoncrawl.logic.actors.Player;
import javafx.application.Application;

import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.objects.OpenedDoor;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.Arrays;

import java.sql.SQLException;




public class Main extends Application {
    Stage window;
    public static int VISIBLE_TILES_SIZE = 14;
    GameMap map = MapLoader.loadMap();
    Canvas canvas = new Canvas(
            VISIBLE_TILES_SIZE * Tiles.TILE_WIDTH,
            VISIBLE_TILES_SIZE * Tiles.TILE_WIDTH);

    GraphicsContext context = canvas.getGraphicsContext2D();
    Label healthLabel = new Label();
    Button pickUpButton = new Button("Pick up");
    Label inventory = new Label();
    GameDatabaseManager dbManager;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setupDbManager();
        GridPane ui = new GridPane();
        ui.setPrefWidth(200);
        ui.setPadding(new Insets(10));

        ui.add(new Label("Health: "), 0, 0);
        ui.add(healthLabel, 1, 0);
        ui.add(new Label("Inventory:"), 0,3);
        ui.add(inventory, 0, 4);

        ui.add(pickUpButton, 0,2);
        pickUpButton.setDisable(true);

        BorderPane borderPane = new BorderPane();

        borderPane.setCenter(canvas);
        borderPane.setRight(ui);

        Scene scene = new Scene(borderPane);
        window = primaryStage;
        window.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);

        window.setTitle("Dungeon Crawl");

        window.show();
        primaryStage.setScene(scene);
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
        scene.setOnKeyReleased(this::onKeyReleased);

        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();
    }

    private void onKeyReleased(KeyEvent keyEvent) {
        KeyCombination exitCombinationMac = new KeyCodeCombination(KeyCode.W, KeyCombination.SHORTCUT_DOWN);
        KeyCombination exitCombinationWin = new KeyCodeCombination(KeyCode.F4, KeyCombination.ALT_DOWN);
        if (exitCombinationMac.match(keyEvent)
                || exitCombinationWin.match(keyEvent)
                || keyEvent.getCode() == KeyCode.ESCAPE) {
            exit();
        }
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                map.getPlayer().move(0, -1);
                refresh();
                break;
            case DOWN:
                map.getPlayer().move(0, 1);
                refresh();
                break;
            case LEFT:
                map.getPlayer().move(-1, 0);
                refresh();
                break;
            case RIGHT:

                map.getPlayer().move(1, 0);
                refresh();
                break;
            case S:
                Player player = map.getPlayer();
//                dbManager.savePlayer(player);
                break;

        }
    }

    private void refresh() {
        Player player = map.getPlayer();
        int playerX = player.getX();
        int playerY = player.getY();
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < VISIBLE_TILES_SIZE; x++) {
            for (int y = 0; y < VISIBLE_TILES_SIZE; y++) {
                int middleX = playerX;
                int middleY = playerY;
                if (playerX - VISIBLE_TILES_SIZE / 2 < 0) {
                    middleX = VISIBLE_TILES_SIZE / 2;
                } else if (playerX + VISIBLE_TILES_SIZE / 2 > map.getWidth()) {
                    middleX = map.getWidth() - VISIBLE_TILES_SIZE / 2;
                }
                if (playerY - VISIBLE_TILES_SIZE / 2 < 0) {
                    middleY = VISIBLE_TILES_SIZE / 2;
                } else if (playerY + VISIBLE_TILES_SIZE / 2 > map.getHeight()) {
                    middleY = map.getHeight() - VISIBLE_TILES_SIZE / 2;
                }

                Cell cell = map.getCell(middleX - VISIBLE_TILES_SIZE / 2 + x, middleY - VISIBLE_TILES_SIZE / 2 + y);
                if (cell.getActor() != null) {
                    if (cell.getActor().getHealth() > 0) {
                        Tiles.drawTile(context, cell.getActor(), x, y);
                    } else {
                        window.close();
                    }
                } else if (cell.getItem() != null) {
                    Tiles.drawTile(context, cell.getItem(), x, y);
                } else if (cell.getObject() != null) {
                    if (map.getPlayer().getItems().length > 0) {
                        for (Item item:map.getPlayer().getItems()) {
                            if (item.getTileName().equals("key")) {
                                Tiles.drawTile(context, new OpenedDoor(cell), x, y);
                            } else {
                                Tiles.drawTile(context, cell.getObject(), x, y);
                            }
                        }
                    } else {
                        Tiles.drawTile(context, cell.getObject(), x, y);
                    }
                }
                else {
                    Tiles.drawTile(context, cell, x, y);
                }
                if (cell.getActor() != null & cell.getItem() != null) {
                    pickUpButton.setDisable(false);
                    pickUpButton.setOnAction(e -> {
                        cell.getActor().addItem(cell.getItem());
                        cell.removeItem();
                        pickUpButton.setDisable(true);});

                }
            }
            healthLabel.setText("" + map.getPlayer().getHealth());
            inventory.setText("" + map.getPlayer().getInventory());
        }
    }


    private void setupDbManager() {
        dbManager = new GameDatabaseManager();
        try {
            dbManager.setup();
        } catch (SQLException ex) {
            System.out.println("Cannot connect to database.");
        }
    }

    private void exit() {
        try {
            stop();
        } catch (Exception e) {
            System.exit(1);
        }
        System.exit(0);
    }

}
