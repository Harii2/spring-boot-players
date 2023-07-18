package com.example.helloworld.repository;

import com.example.helloworld.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PlayerJpaRepository extends JpaRepository<Player,Integer>{
    
}
