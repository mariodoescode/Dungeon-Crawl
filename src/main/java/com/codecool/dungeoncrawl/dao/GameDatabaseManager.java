package com.codecool.dungeoncrawl.dao;

import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Player;
import com.codecool.dungeoncrawl.model.GameState;
import com.codecool.dungeoncrawl.model.PlayerInventory;
import com.codecool.dungeoncrawl.model.PlayerModel;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class GameDatabaseManager {
    private PlayerDao playerDao;
    private GameStateDao gameStateDao;
    private InventoryDao inventoryDao;

    public void setup() throws SQLException, IOException {
        DataSource dataSource = connect();
        playerDao = new PlayerDaoJdbc(dataSource);
        gameStateDao = new GameStateDaoJdbc(dataSource, playerDao);
        inventoryDao = new IntentoryDaoJdbc(dataSource, playerDao);
    }


    private DataSource connect() {
        PGSimpleDataSource dataSource;
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/connection.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);

            dataSource = new PGSimpleDataSource();
            String dbName = (String) properties.get("DB_NAME");
            String user = (String) properties.get("USERNAME");
            String password = (String) properties.get("PASSWORD");

            dataSource.setDatabaseName(dbName);
            dataSource.setUser(user);
            dataSource.setPassword(password);

            System.out.println("Trying to connect");
            dataSource.getConnection().close();
            System.out.println("Connection ok.");

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }


    public void saveGameState(GameMap map) {
        PlayerModel playerModel = new PlayerModel(map.getPlayer());
        String currentMap = map.getFileName();
        java.sql.Date saved_at = new java.sql.Date(System.currentTimeMillis());
        GameState gameState = new GameState(currentMap,saved_at,playerModel);
        PlayerInventory playerInventory = new PlayerInventory(map.getPlayer().getItems());
        playerDao.add(playerModel);
        gameStateDao.add(gameState);
        inventoryDao.add(playerInventory);
    }
}
