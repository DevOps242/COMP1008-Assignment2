package com.example.comp1008assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
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

    // Initialize team object;
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
    private Label pfName;

    @FXML
    private Label pfPos;

    @FXML
    private Label pfRating;

    @FXML
    private Label pgName;

    @FXML
    private Label pgPos;

    @FXML
    private Label pgRating;

    @FXML
    private Label sfName;

    @FXML
    private Label sfPos;

    @FXML
    private Label sfRating;

    @FXML
    private Label sgName;

    @FXML
    private Label sgPos;

    @FXML
    private Label sgRating;

    @FXML
    private Label cName;

    @FXML
    private Label cPos;

    @FXML
    private Label cRating;

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

    @FXML
    private Label createRatingView;

    @FXML
    private TextField createPlayerName;

    @FXML
    private TextField createPlayerPosition;

    @FXML
    private Slider createPlayerRating;

    @FXML
    private TextField createrPlayerNumber;

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
            teamRating.setText(Double.toString(Math.round(team.getTeamRating())) + "%");
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error Getting Team Rating.");
            alert.setContentText("There must be at least 2 players on a team to calculate Team Ratings");
            alert.showAndWait();
            throw new IllegalStateException("Team must have at least 2 players to calculate the Ratings.");
        }
    }

    /**
     * Captures the value of the new player ratings.
     */
    @FXML
    void actionCreatePlayerRatingDrag() {
        String ratingView = createRatingView.getText();
        ratingView = ratingView.substring(0,5) + " " + Math.round(createPlayerRating.getValue()) + "%";
        createRatingView.setText(ratingView);
    }


    /**
     * Creates a new player and adds them to the collection of players.
     * @param event
     */
    @FXML
    void createPlayer(ActionEvent event) {
        try {
            Player newPlayer = new Player(createPlayerName.getText(), Integer.parseInt(createrPlayerNumber.getText()), Integer.parseInt(createPlayerPosition.getText()), Math.round(createPlayerRating.getValue()), "/images/players/generic.png");

            // Add to the list of players showing.
            playerGenerator.add(newPlayer);

            // Change the index of the loaded player.
            playerCounter = playerGenerator.size() - 1;

            // Show the new player.
            loadPlayer(playerGenerator);

            // Clear the previous entered information
            createPlayerName.setText("");
            createPlayerPosition.setText("");
            createrPlayerNumber.setText("");
            createPlayerRating.setValue(0);
            createRatingView.setText("Rating:");


        } catch (Exception error) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error Creating Player");
            alert.setContentText(error.toString());
            alert.showAndWait();
            throw new IllegalStateException("There was an issue creating your player");
        }
    }

    /**
     * Removes a player from the Players list.
     * @param event
     */
    @FXML
    void removePlayer(ActionEvent event) {
        if (playerGenerator.size() > 1) {
            // Remove the player at the index.
            playerGenerator.remove(playerCounter);

            // Set the counter to the previous player
            playerCounter = playerGenerator.size() - 1;

            // load the player
            loadPlayer(playerGenerator);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error Removing Player");
            alert.setContentText("Can not remove player because it's the last player left.");
            alert.showAndWait();
        }
    }

    /**
     * Method loads the starting five and displays them to the GUI
     * @param event
     */
    @FXML
    void loadStartingFive(ActionEvent event) {

        //        1. Point Guard
        //        2. Shooting Guard
        //        3. Small Forward
        //        4. Power Forward
        //        5. Center

        // Load in the starting five players.
        ArrayList<Player> startingFivePlayers = team.getStartingFive();
        Player pointGuard = null;
        Player shootingGuard = null;
        Player smallForward = null;
        Player powerForward = null;
        Player center = null;

        // Assign the object to the respectable position
        for (Player item : startingFivePlayers) {
            if (item.getPosition().equals("Point Guard")){
                pointGuard = item;
            }
            if (item.getPosition().equals("Shooting Guard")){
                shootingGuard = item;
            }
            if (item.getPosition().equals("Small Forward")){
                smallForward = item;
            }
            if (item.getPosition().equals("Power Forward")){
                powerForward = item;
            }
            if (item.getPosition().equals("Center")){
                center = item;
            }
        }

        // Load the Point Guard information
        pgName.setText(pointGuard.getName());
        pgRating.setText(Double.toString(pointGuard.getAverageRating()) + "%");

        // Load the Shooting Guard information
        sgName.setText(shootingGuard.getName());
        sgRating.setText(Double.toString(shootingGuard.getAverageRating()) + "%");

        // Load the Small Forward information
        sfName.setText(smallForward.getName());
        sfRating.setText(Double.toString(smallForward.getAverageRating()) + "%");

        // Load the Power Forward information
        pfName.setText(powerForward.getName());
        pfRating.setText(Double.toString(powerForward.getAverageRating()) + "%");

        // Load the Center information
        cName.setText(center.getName());
        cRating.setText(Double.toString(center.getAverageRating()) + "%");
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
        playerRating.setText(Double.toString(players.get(playerCounter).getAverageRating()) + "%");
        // Need to load in their image.
        try {
            playerImg.setImage(new Image(getClass().getResource(players.get(playerCounter).getPlayerImage()).toExternalForm()));
        } catch (Exception error) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error Loading Image");
            alert.setContentText("There was an issue loading your player image: ");
            alert.showAndWait();
            throw new IllegalStateException("There was an issue loading your player image: " + error);
        }

    }

    /**
     * Generates a random number from 0 - 5 and selects a team for you to start building once you hit add player.
     */
    private void loadTeam() {
        Random rand = new Random();
        int min = 0;
        int max = 5;

        int randomNum = rand.nextInt((max - min) + 1) + min;

        switch (randomNum) {
            case 0:
                team.setName("Lakers");
                team.setState("Los Angeles");
                team.setLogo("/images/teams/" + team.getName() + ".png");
                break;
            case 1:
                team.setName("Suns");
                team.setState("Phoenix");
                team.setLogo("/images/teams/" + team.getName() + ".png");
                break;
            case 2:
                team.setName("Celtics");
                team.setState("Boston");
                team.setLogo("/images/teams/" + team.getName() + ".png");
                break;
            case 3:
                team.setName("Raptors");
                team.setState("Toronto");
                team.setLogo("/images/teams/" + team.getName() + ".png");
                break;
            case 4:
                team.setName("Nets");
                team.setState("Brooklyn");
                team.setLogo("/images/teams/" + team.getName() + ".png");
                break;
            case 5:
                team.setName("Bulls");
                team.setState("Chicago");
                team.setLogo("/images/teams/" + team.getName() + ".png");
                break;
        }

        // Set the team name and state
        teamName.setText(team.getName());
        teamState.setText(team.getState());

        //Get the error if the image failed to load.
        try {
            teamLogo.setImage(new Image(getClass().getResource(team.getLogo()).toExternalForm()));
        } catch (Exception error) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error Loading Image");
            alert.setContentText("There was an issue loading your team image: ");
            alert.showAndWait();
            throw new IllegalStateException("There was an issue loading your team image: " + error);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        playerGenerator.add(new Player("Steph Curry", 30, 1, 96, "/images/players/stephcurry.png"));
        playerGenerator.add(new Player("Lebron James", 6, 3, 96, "/images/players/lebronjames.png"));
        playerGenerator.add(new Player("Kevin Durant", 7, 3, 96, "/images/players/kevindurant.png"));
        playerGenerator.add(new Player("John Wall", 1, 1, 83, "/images/players/johnwall.png"));
        playerGenerator.add(new Player("Khem Birch", 24, 5, 76, "/images/players/khembirch.png"));
        playerGenerator.add(new Player("Kyle Anderson", 1, 4, 79, "/images/players/generic.png"));
        playerGenerator.add(new Player("Deandre Ayton", 22, 5, 86, "/images/players/deandreayton.png"));
        playerGenerator.add(new Player("Darius Bazley", 7, 4, 77, "/images/players/generic.png"));
        playerGenerator.add(new Player("Jordan Bell", 20, 4, 71, "/images/players/generic.png"));
        playerGenerator.add(new Player("Joel Ayayi", 17, 2, 68, "/images/players/generic.png"));
        playerGenerator.add(new Player("Cole Anthony", 50, 2, 78, "/images/players/generic.png"));
        playerGenerator.add(new Player("Grayson Allen", 7, 2, 76, "/images/players/generic.png"));
        playerGenerator.add(new Player("John Collings", 20, 4, 83, "/images/players/generic.png"));
        playerGenerator.add(new Player("Delon Wright", 0, 1, 77, "/images/players/delonwright.png"));
        playerGenerator.add(new Player("Skylar Mays", 4, 2, 73, "/images/players/skylarmays.png"));
        playerGenerator.add(new Player("Sharife Cooper", 2, 1, 71, "/images/players/sharifecooper.png"));
        playerGenerator.add(new Player("Kawhi Leonard", 2, 3, 95, "/images/players/generic.png"));
        playerGenerator.add(new Player("Bam Adebayo", 13, 5, 87, "/images/players/generic.png"));
        playerGenerator.add(new Player("Domantas Sabonis", 10, 4, 87, "/images/players/domantassabonis.png"));
        playerGenerator.add(new Player("Pascal Siakam", 43, 4, 87, "/images/players/pascalsiakam.png"));
        playerGenerator.add(new Player("Jaylen Brown", 7, 3, 86, "/images/players/generic.png"));
        playerGenerator.add(new Player("Clint Capela", 15, 5, 85, "/images/players/clintcapela.png"));
        playerGenerator.add(new Player("Robert Williams", 44, 5, 82, "/images/players/generic.png"));
        playerGenerator.add(new Player("Mitchell Robinson", 23, 5, 82, "/images/players/mitchellrobinson.png"));
        playerGenerator.add(new Player("T.J. Warren", 1, 3, 82, "/images/players/generic.png"));
        playerGenerator.add(new Player("Kyle Kuzma", 33, 3, 82, "/images/players/kylekuzma.png"));
        playerGenerator.add(new Player("Ja Morant", 12, 1, 93, "/images/players/jamorant.png"));
        playerGenerator.add(new Player("Jamal Murray", 27, 1, 85, "/images/players/jamalmurray.png"));
        playerGenerator.add(new Player("C.J. McCollum", 3, 2, 87, "/images/players/generic.png"));
        playerGenerator.add(new Player("Dejounte Murray", 5, 1, 87, "/images/players/generic.png"));
        playerGenerator.add(new Player("Bradley Beal", 3, 2, 87, "/images/players/bradleybeal.png"));
        playerGenerator.add(new Player("Derrick Rose", 4, 1, 83, "/images/players/derrickrose.png"));

        Collections.shuffle(playerGenerator);

        loadPlayer(playerGenerator);

    }
}