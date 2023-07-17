package com.example.helloworld.repository;

import com.example.helloworld.model.Player;
import java.util.*;

public interface PlayerRepository {
    ArrayList<Player> getPlayers();

    Player getPlayerById(int playerId);

    Player addPlayer(Player player);

    Player updatePlayer(int playerId,Player player); 

    void deletePlayer(int playerId);
}
