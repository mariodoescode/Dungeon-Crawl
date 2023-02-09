package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.logic.items.Item;
import com.codecool.dungeoncrawl.logic.objects.OpenedDoor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application {
    Stage window;
    GameMap map = MapLoader.loadMap();
    Canvas canvas = new Canvas(
            1080,720);
    GraphicsContext context = canvas.getGraphicsContext2D();
    Label healthLabel = new Label();
    Button pickUpButton = new Button("Pick up");
    Label inventory = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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
                map.getPlayer().move(1,0);
                refresh();
                break;
        }
    }

    private void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Cell cell = map.getCell(x, y);
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
}
