package com.example.helloworld.model;


import jakarta.persistence.*;

@Entity
@Table(name="player")
public class Player {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;
    @Column(name="name")
    private String name;
    @Column(name = "jerseynumber")
    private int jerseyNumber;
    @Column(name = "role")
    private String role ;

    public Player(){
        
    }

    public Player(int id,String name,int no,String role){
        this.playerId = id;
        this.name = name;
        this.jerseyNumber = no;
        this.role = role;
    }

    public int getPlayerId(){
        return this.playerId;
    }

    public void setPlayerId(int id){
        this.playerId = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getJerseyNumber(){
        return this.jerseyNumber;
    }

    public void setJerseyNumber(int no){
        this.jerseyNumber = no;
    }

    public String getRole(){
        return this.role;
    }

    public void setRole(String role){
        this.role = role;
    }
}
