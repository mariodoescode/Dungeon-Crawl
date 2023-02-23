package com.codecool.dungeoncrawl.dao;

import java.util.List;

import com.codecool.dungeoncrawl.model.PlayerInventory;
import com.codecool.dungeoncrawl.model.PlayerModel;

public interface InventoryDao {

    void add(PlayerInventory item);
    void update(PlayerInventory item);
    PlayerInventory get(int id);
    List<PlayerInventory> getAll();
    List<PlayerInventory> getPlayerItems(int player_id);
}
