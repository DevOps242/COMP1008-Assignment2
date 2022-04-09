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

    @FXML
    void loadNextPlayer(ActionEvent event) {

    }

    @FXML
    void loadPrevPlayer(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Will be use to show the next players
        int playerCounter = 0;

        // Load in some players.
        ArrayList<Player> playerGenerator = new ArrayList<Player>();

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

        // Set the first random player information;
        playerName.setText(playerGenerator.get(playerCounter).getName());
        playerNumber.setText(Integer.toString(playerGenerator.get(playerCounter).getJerseyNumber()));
        playerPosition.setText(playerGenerator.get(playerCounter).getPosition());
        playerRating.setText(Double.toString(playerGenerator.get(playerCounter).getAverageRating()));

        // Initalize team object;
        Team team = new Team();


    }
}