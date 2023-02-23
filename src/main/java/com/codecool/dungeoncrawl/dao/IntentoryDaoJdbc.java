package com.codecool.dungeoncrawl.dao;

import com.codecool.dungeoncrawl.model.PlayerInventory;

import javax.sql.DataSource;
import java.util.List;

public class IntentoryDaoJdbc implements InventoryDao{
    public IntentoryDaoJdbc(DataSource dataSource, PlayerDao playerDao) {
    }

    @Override
    public void add(PlayerInventory item) {

    }

    @Override
    public void update(PlayerInventory item) {

    }

    @Override
    public PlayerInventory get(int id) {
        return null;
    }

    @Override
    public List<PlayerInventory> getAll() {
        return null;
    }

    @Override
    public List<PlayerInventory> getPlayerItems(int player_id) {
        return null;
    }
}
