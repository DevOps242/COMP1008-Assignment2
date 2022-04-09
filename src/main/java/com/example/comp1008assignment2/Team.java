package com.example.comp1008assignment2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;

public class Team {
    private String name;
    private String state;
    private String logo;
    private ArrayList<Player> players = new ArrayList<Player>();

    public Team(String name, String state, String logo) {
        setName(name);
        setState(state);
        setLogo(logo);
        players = new ArrayList<>();
    }

    public Team() {

    }

    public String getName() {
        return name;
    }

    /**
     * Validate name must be 2 characters or more.
     * @param name
     */
    public void setName(String name) {
        if(name.trim().length() > 2 )
            this.name = name;
        else
            throw new IllegalArgumentException("Team name must be at least two characters");
    }

    public String getState() {
        return state;
    }

    /**
     * Validate state must be 2 characters or more.
     * @param state
     */
    public void setState(String state) {
        if(state.trim().length() > 2)
            this.state = state;
        else
            throw new IllegalArgumentException("Team State must be at least two characters");
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        if(logo.startsWith("images/teams/"))
            this.logo = logo;
        else
            throw new IllegalArgumentException("Teams Image is an invalid image");
    }

    /**
     * This method accepts a Player object and adds it to the team
     * @param player
     */
    public void addPlayer(Player player) {
        if (players.size() <= 11) {
            players.add(player);
        }
        else
            throw new IllegalArgumentException("Team is full there can only be up to 11 players");
    }

    /**
     *
     * @return The size of the team.
     */
    public int getTeamSize() {
        return players.size();
    }

    /**
     * Gets the Teams Ratings by adding all the players ratings and diving by the size of the team.
     * @return
     */
    public double getTeamRating() {
        double average = 0;

        for (Player player: players){
            average += player.getAverageRating();
        }

        average = (average / players.size());

        return average;
    }

    /**
     * Returns an array list of all players.
     * @return
     */
    public ArrayList<Player> getPlayers(){
        return players;
    }

    /**
     * Method that filters the players and select the highest rating player for the position.
     * @return
     */
    public ArrayList<Player> getStartingFive() {
        ArrayList<Player> startingFivePlayers = new ArrayList<>();

        // Create temp array list with all the player with the same position on the team.
        ArrayList<Player> pointGuards = new ArrayList<>();
        ArrayList<Player> shootingGuards = new ArrayList<>();
        ArrayList<Player> smallForwards = new ArrayList<>();
        ArrayList<Player> powerForwards = new ArrayList<>();
        ArrayList<Player> centers = new ArrayList<>();

        // Filter and get all points guards on the team.
        AtomicReference<Double> tempRating = new AtomicReference<>((double) 0);
        players.stream().filter(player -> player.getPosition().equals("Point Guard")).forEach(
                item -> {

                    // Get the higher rating.
                    if ( item.getAverageRating() > tempRating.get())
                    {
                        tempRating.set(item.getAverageRating());
                        // Add the new one.
                        pointGuards.add(item);
                    }
                }
        );
        // Set the tempRating back to 0
        tempRating.set(0.0);


        // Filter and get all points guards on the team.
        players.stream().filter(player -> player.getPosition().equals("Shooting Guard")).forEach(
                item -> {

                    // Get the higher rating.
                    if ( item.getAverageRating() > tempRating.get())
                    {
                        tempRating.set(item.getAverageRating());
                        // Add the new one.
                        shootingGuards.add(item);
                    }
                }
        );
        // Set the tempRating back to 0
        tempRating.set(0.0);

        // Filter and get all points guards on the team.
        players.stream().filter(player -> player.getPosition().equals("Small Forward")).forEach(
                item -> {

                    // Get the higher rating.
                    if ( item.getAverageRating() > tempRating.get())
                    {
                        tempRating.set(item.getAverageRating());
                        // Add the new one.
                        smallForwards.add(item);
                    }
                }
        );
        // Set the tempRating back to 0
        tempRating.set(0.0);

        // Filter and get all points guards on the team.
        players.stream().filter(player -> player.getPosition().equals("Power Forward")).forEach(
                item -> {

                    // Get the higher rating.
                    if ( item.getAverageRating() > tempRating.get())
                    {
                        tempRating.set(item.getAverageRating());
                        // Add the new one.
                        powerForwards.add(item);
                    }
                }
        );
        // Set the tempRating back to 0
        tempRating.set(0.0);

        // Filter and get all points guards on the team.
        players.stream().filter(player -> player.getPosition().equals("Center")).forEach(
                item -> {

                    // Get the higher rating.
                    if ( item.getAverageRating() > tempRating.get())
                    {
                        tempRating.set(item.getAverageRating());
                        // Add the new one.
                        centers.add(item);
                    }

                }
        );

        try {
            // Filter the arrays and get the highest rating person for each position
            startingFivePlayers.add(Collections.max(pointGuards, Comparator.comparing(item -> item.getAverageRating())));
            startingFivePlayers.add(Collections.max(shootingGuards, Comparator.comparing(item -> item.getAverageRating())));
            startingFivePlayers.add(Collections.max(smallForwards, Comparator.comparing(item -> item.getAverageRating())));
            startingFivePlayers.add(Collections.max(powerForwards, Comparator.comparing(item -> item.getAverageRating())));
            startingFivePlayers.add(Collections.max(centers, Comparator.comparing(item -> item.getAverageRating())));
        } catch (Exception error) {
            throw new IllegalStateException("Could not get your starting five");
        }

        return startingFivePlayers;
    }
}
