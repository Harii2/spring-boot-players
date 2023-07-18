package com.example.helloworld.service;

import com.example.helloworld.model.Player;
import com.example.helloworld.repository.PlayerRepository;
import com.example.helloworld.repository.PlayerJpaRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@Service
public class PlayerJpaService implements PlayerRepository{
    @Autowired
    private PlayerJpaRepository playerJpaRepository ;

    @Override
    public ArrayList<Player> getPlayers(){
        List<Player> playersList = playerJpaRepository.findAll();
        ArrayList<Player> players = new ArrayList<>(playersList);
        return players;
    }

    @Override
    public Player getPlayerById(int playerId){
        try{
            Player player = playerJpaRepository.findById(playerId).get();
            return player;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Player addPlayer(Player player){
        playerJpaRepository.save(player);
        return player;
    }

    @Override
    public Player updatePlayer(int playerId,Player player){
        try{
            Player exisitingPlayer = playerJpaRepository.findById(playerId).get();
            if(player.getName() != null){
                exisitingPlayer.setName(player.getName());
            }
            if(player.getJerseyNumber() >= 0){
                exisitingPlayer.setJerseyNumber(player.getJerseyNumber());
            }
            if(player.getRole() != null){
                exisitingPlayer.setRole(player.getRole());
            }
            playerJpaRepository.save(exisitingPlayer);
            return exisitingPlayer;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePlayer(int playerId){
        try{
            playerJpaRepository.deleteById(playerId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
