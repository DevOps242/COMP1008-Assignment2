package com.example.comp1008assignment2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Derrick Rose", 32, 1, 92, "images/players/generic.png");
    }


    @Test
    void setName() {
        player.setName("Micheal Brown");
        assertEquals("Micheal Brown", player.getName());
    }

    @Test
    void setNameInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setName("");
        });
    }

    @Test
    void setNameInvalid2() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setName("   ");
        });
    }

    @Test
    void setJerseyNumber() {
        player.setJerseyNumber(21);
        assertEquals(21, player.getJerseyNumber());
    }

    @Test
    void setJerseyNumberInvalidLow(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setJerseyNumber(-21);
        });
    }

    @Test
    void setJerseyNumberInvalidHigh(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setJerseyNumber(101);
        });
    }

    @Test
    void setPosition1() {
        player.setPosition(1);

        int playersPG = 0;
        String playerPosName = "";

        if (player.getPosition().equals("Point Guard")) {
            playersPG = 1;
            playerPosName = "Point Guard";
        }
        assertEquals(playerPosName, player.getPosition());
    }

    @Test
    void setPosition2() {
        player.setPosition(2);

        String playerPosName = "";

        if (player.getPosition().equals("Shooting Guard")) {
            playerPosName = "Shooting Guard";
        }
        assertEquals(playerPosName, player.getPosition());
    }

    @Test
    void setPosition3() {
        player.setPosition(3);

        String playerPosName = "";

        if (player.getPosition().equals("Small Forward")) {
            playerPosName = "Small Forward";
        }
        assertEquals(playerPosName, player.getPosition());
    }

    @Test
    void setPosition4() {
        player.setPosition(4);
        String playerPosName = "";

        if (player.getPosition().equals("Power Forward")) {
            playerPosName = "Power Forward";
        }
        assertEquals(playerPosName, player.getPosition());
    }

    @Test
    void setPosition5() {
        player.setPosition(5);
        String playerPosName = "";

        if (player.getPosition().equals("Center")) {
            playerPosName = "Center";
        }
        assertEquals(playerPosName, player.getPosition());
    }

    @Test
    void setPositionInvalidLow(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setPosition(0);
        });
    }

    @Test
    void setPositionInvalidHigh(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setPosition(6);
        });
    }

    @Test
    void setAverageRating() {
        player.setAverageRating(54);
        assertEquals(54, player.getAverageRating());
    }

    @Test
    void setAverageRatingInvalidLow(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setAverageRating(-1);
        });
    }

    @Test
    void setAverageRatingInvalidHigh(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            player.setAverageRating(101);
        });
    }

    @Test
    void setPlayerImage() {
        player.setPlayerImage("images/players/generic.png");
        assertEquals("images/players/generic.png", player.getPlayerImage());
    }

    @Test
    void setPlayerImageInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            player.setPlayerImage("generic.png");
        });
    }

}