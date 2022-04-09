package com.example.comp1008assignment2;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private String state;
    private String logo;
    private ArrayList<Player> players;

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
        if(name.length() < 2 )
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
        if(state.length() < 2)
            this.state = state;
        else
            throw new IllegalArgumentException("Team State must be at least two characters");
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * This method accepts a Player object and adds it to the team
     * @param player
     */
    public void addPlayer(Player player){
        if (players.size() <= 11)
            players.add(player);
        else
            throw new IllegalArgumentException("Team is full there can only be up to 11 players");
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


    public ArrayList<Player> getStartingFive() {
        ArrayList<Player> startingFivePlayers = new ArrayList<>();

        // temp data
        startingFivePlayers.add(players.get(1));
        startingFivePlayers.add(players.get(2));

        Player tempPlayer;
        for(Player player: players){
//            for(int i = 0; i < 5; i++){
////                if (player.getPosition() == i) {
////
////                }
//            }

        }

        return startingFivePlayers;
    }
}
