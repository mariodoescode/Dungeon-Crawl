package com.codecool.dungeoncrawl.dao;

import com.codecool.dungeoncrawl.logic.actors.Player;
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

    public void setup() throws SQLException, IOException {
        DataSource dataSource = connect();
        playerDao = new PlayerDaoJdbc(dataSource);
    }

//    public void savePlayer(Player player) {
//        PlayerModel model = new PlayerModel(player);
//        playerDao.add(model);
//    }

    private DataSource connect() throws SQLException, IOException {
        PGSimpleDataSource dataSource = null;
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


    public static void main(String[] args) {
        System.out.println(System.getenv("DB_NAME"));
        System.out.println(System.getenv("USERNAME"));
        System.out.println(System.getenv("PASSWORD"));
    }


}
