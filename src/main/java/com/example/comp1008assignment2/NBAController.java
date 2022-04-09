package com.example.comp1008assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.ResourceBundle;

public class NBAController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    // Template information above

    // Will be use to show the next players
    private int playerCounter = 0;

    // Load in some players.
    ArrayList<Player> playerGenerator = new ArrayList<Player>();


    @FXML
    private Button addPlayer;

    @FXML
    private Button calculateWinRate;

    @FXML
    private Button createPlayer;

    @FXML
    private Button genStartingFive;

    @FXML
    private Button playerCycleNext;

    @FXML
    private Button playerCyclePrev;

    @FXML
    private ImageView playerImg;

    @FXML
    private Label playerName;

    @FXML
    private Label playerNumber;

    @FXML
    private Label playerPosition;

    @FXML
    private Label playerRating;

    @FXML
    private ImageView teamLogo;

    @FXML
    private Label teamName;

    @FXML
    private Label teamState;

    @FXML
    private Label teamWinRate;

    /**
     * Cycles through the generated players - going forward.
     * @param event
     */
    @FXML
    void loadNextPlayer(ActionEvent event) {
        if (playerCounter == playerGenerator.size() - 1) {
            playerCounter = 0;
        } else {
            playerCounter = playerCounter + 1;
        }

        this.loadPlayer(playerGenerator);
    }

    /**
     * Cycles through the generated players - going backwards.
     * @param event
     */
    @FXML
    void loadPrevPlayer(ActionEvent event) {
        if (playerCounter > 0) {
            playerCounter = playerCounter - 1;
        } else {
            playerCounter = playerGenerator.size() - 1;
        }
        this.loadPlayer(playerGenerator);
    }

    /**
     * Loads the players to choose from.
     * @param players
     */
    private void loadPlayer(ArrayList<Player> players) {
        // Set the first random player information;
        playerName.setText(players.get(playerCounter).getName());
        playerNumber.setText(Integer.toString(players.get(playerCounter).getJerseyNumber()));
        playerPosition.setText(players.get(playerCounter).getPosition());
        playerRating.setText(Double.toString(players.get(playerCounter).getAverageRating()));
        // Need to load in there image.
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        playerGenerator.add(new Player("Steph Curry", 30, 1, 96));
        playerGenerator.add(new Player("Lebron James", 6, 3, 96));
        playerGenerator.add(new Player("Kevin Durant", 7, 3, 96));
        playerGenerator.add(new Player("John Wall", 1, 1, 83));
        // Get ratings for the below
        playerGenerator.add(new Player("Steven Adams", 5, 5, 96));
        playerGenerator.add(new Player("Kyle Anderson", 1, 4, 96));
        playerGenerator.add(new Player("Deandre Ayton", 22, 5, 96));
        playerGenerator.add(new Player("Mo Bamba", 5, 5, 96));
        Collections.shuffle(playerGenerator);

        loadPlayer(playerGenerator);

        // Initalize team object;
        Team team = new Team();


    }
}