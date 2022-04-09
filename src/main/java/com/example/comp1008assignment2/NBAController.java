package com.example.comp1008assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class NBAController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    // Template information above

    // Initalize team object;
    Team team = new Team();

    // Will be use to show the next players
    private int playerCounter = 0;

    // Load in some players.
    ArrayList<Player> playerGenerator = new ArrayList<Player>();

    // Generate random Team Info.


    @FXML
    private Button addPlayer;

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
    private Label teamRating;

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
     * Adds players to team and removes added player from the draft list.
     * @param event
     */
    @FXML
    void addPlayerToTeam(ActionEvent event) {
        // Add that object to the team.
        team.addPlayer(playerGenerator.get(playerCounter));

        // remove player from the list
        playerGenerator.remove(playerCounter);

        // Load another play who is still in the list.
        playerCounter=0;
        loadPlayer(playerGenerator);

        // Call method that will randomly pick a team for your draft.
        if ( team.getName() == null)
            loadTeam();
    }

    /**
     * Calls the calculate Team Rating method of the team class. gets the average rating from all players on team.
     * @param event
     */
    @FXML
    void calculateTeamRating(ActionEvent event) {
        if (team.getTeamSize() > 0 ) {
            teamRating.setText(Double.toString(team.getTeamRating()) + "%");
        } else {
            throw new IllegalStateException("Team must have at least 2 players to calculate the Ratings.");
        }
    }

    @FXML
    void createPlayer(ActionEvent event) {

    }

    @FXML
    void loadStartingFive(ActionEvent event) {

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

    private void loadTeam() {
        Random rand = new Random();
        int min = 0;
        int max = 5;

        int randomNum = rand.nextInt((max - min) + 1) + min;

        switch (randomNum) {
            case 0:
                team.setName("Lakers");
                team.setState("Los Angeles");
                team.setLogo("");
                break;
            case 1:
                team.setName("Suns");
                team.setState("Phoenix");
                team.setLogo("");
                break;
            case 2:
                team.setName("Celtics");
                team.setState("Boston");
                team.setLogo("");
                break;
            case 3:
                team.setName("Raptors");
                team.setState("Toronto");
                team.setLogo("");
                break;
            case 4:
                team.setName("Nets");
                team.setState("Brooklyn");
                team.setLogo("");
                break;
            case 5:
                team.setName("Bulls");
                team.setState("Chicago");
                team.setLogo("");
                break;

        }
//        teamLogo.setImage();

        teamName.setText(team.getName());

        teamState.setText(team.getState());


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




    }
}