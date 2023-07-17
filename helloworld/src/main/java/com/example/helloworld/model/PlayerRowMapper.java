package com.example.helloworld.model;

import com.example.helloworld.model.Player;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PlayerRowMapper implements RowMapper<Player> {
    public Player mapRow(ResultSet rs,int rowNum) throws SQLException{
        return new Player(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("jerseyNumber"),
            rs.getString("role")
        );
    }
}
