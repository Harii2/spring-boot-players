package com.example.helloworld.controller;

import java.util.*;
import com.example.helloworld.model.Player;
import com.example.helloworld.service.PlayerH2Service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class PlayerController {
    @Autowired 
    private PlayerH2Service playerService ;

    @GetMapping("/hello")
    public String getHello(){
        return "Hello" ;
    }

    @GetMapping("/players")
    public ArrayList<Player> getPlayers(){
        
        return playerService.getPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId){
        return playerService.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        System.out.print(player.getJerseyNumber());
        return playerService.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId,@RequestBody Player player){
        return playerService.updatePlayer(playerId,player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId){
        playerService.deletePlayer(playerId);
    }
}
