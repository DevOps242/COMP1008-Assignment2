package com.example.comp1008assignment2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    private Team team;
    private Player player;

    @BeforeEach
    void setUp() {
        team = new Team("Raptors", "Toronto", "images/teams/generic.png");
        player = new Player("Derrick Rose", 32, 1, 92, "images/players/generic.png");
        team.addPlayer(player);
    }

    @Test
    void Team() {
        Team teamCon = new Team();
        assertEquals(teamCon, teamCon);
    }

    @Test
    void setName() {
        team.setName("Raptors");
        assertEquals("Raptors", team.getName());
    }

    @Test
    void setNameInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            team.setName("");
        });
    }

    @Test
    void setState() {
        team.setState("Toronto");
        assertEquals("Toronto", team.getState());
    }

    @Test
    void setStateInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            team.setState("");
        });
    }

    @Test
    void setStateInvalid2() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setName("  ");
        });
    }


    @Test
    void setLogo() {
        team.setLogo("images/teams/generic.png");
        assertEquals("images/teams/generic.png", team.getLogo());
    }

    @Test
    void setLogoInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            team.setLogo("generic.png");
        });
    }

    @Test
    void addPlayer() {
        Player player1 = new Player("James Brown", 25, 1, 67, "images/players/generic.png");
        team.addPlayer(player1);

        assertEquals(2, team.getTeamSize());
    }

    @Test
    void addPlayerInvalid() {
        if (team.getTeamSize() > 11) {
            Assertions.assertThrows(IllegalArgumentException.class, ()-> {
                team.addPlayer(player);
            });
        }
    }

    @Test
    void getTeamSize() {
        int teamSize = team.getTeamSize();
        assertEquals(teamSize, team.getTeamSize());
    }

    @Test
    void getPlayers() {
        ArrayList<Player> playersList = team.getPlayers();
        assertEquals(playersList, team.getPlayers());
    }

    @Test
    void getTeamRating() {
       double ratings  = team.getTeamRating();
        assertEquals(ratings, team.getTeamRating());
    }


    @Test
    void getStartingFive() {
        ArrayList<Player> startingFive = new ArrayList<>();
        Player player1 = new Player("Steph Curry", 30, 1, 96, "images/players/stephcurry.png");
        Player player2 = new Player("Joel Ayayi", 17, 2, 68, "images/players/generic.png");
        Player player3 = new Player("Lebron James", 6, 3, 96, "images/players/lebronjames.png");
        Player player4 = new Player("Kyle Anderson", 1, 4, 79, "images/players/kyleanderson.jpg");
        Player player5 = new Player("Deandre Ayton", 22, 5, 86, "images/players/deandreayton.png");

        startingFive.add(player1);
        startingFive.add(player2);
        startingFive.add(player3);
        startingFive.add(player4);
        startingFive.add(player5);

        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        team.addPlayer(player4);
        team.addPlayer(player5);

        assertEquals(startingFive, team.getStartingFive());
    }
}