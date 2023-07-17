package com.example.helloworld.service;

import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.helloworld.model.Player;
import com.example.helloworld.model.PlayerRowMapper;
import com.example.helloworld.repository.PlayerRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlayerH2Service implements PlayerRepository{
    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Player> getPlayers(){
        List<Player> players = db.query("SELECT * FROM PLAYER;", new PlayerRowMapper());
        
        ArrayList<Player> p = new ArrayList<>(players);
        return p;
    }

    @Override
    public Player getPlayerById(int playerId){
        try{
            Player p = db.queryForObject("SELECT * FROM PLAYER WHERE ID = ?;",new PlayerRowMapper(),playerId);
            return p;
        }
        
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    @Override
    public Player addPlayer(Player player){
        db.update("INSERT INTO PLAYER(name,jerseyNumber,role) VALUES(?,?,?);",player.getName(),player.getJerseyNumber(),player.getRole());
        Player p = db.queryForObject("SELECT * FROM PLAYER WHERE name = ? AND jerseyNumber = ? ;",new PlayerRowMapper(),player.getName(),player.getJerseyNumber());
        return p;
    }

    @Override
    public  Player updatePlayer(int playerId,Player player){
        if(player.getName() != null){
            db.update("UPDATE PLAYER SET name = ? WHERE id = ?", player.getName(),playerId);
        }

        if(player.getJerseyNumber() >= 0){
            db.update("update player set jerseyNumber = ? where id = ?", player.getJerseyNumber(),playerId);
        }

        if(player.getRole() != null){
            db.update("update player set role = ? where id = ?", player.getRole(),playerId);
        }

        return getPlayerById(playerId);
    }

    @Override
    public void deletePlayer(int playerId){
        db.update("DELETE  from player where id = ?",playerId);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
