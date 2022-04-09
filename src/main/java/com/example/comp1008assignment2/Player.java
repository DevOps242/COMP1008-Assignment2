package com.example.comp1008assignment2;

import java.util.Locale;

//https://lucid.app/lucidchart/47dcb37e-3da7-42d6-99e9-4495f77be6c1/edit?beaconFlowId=D277759F349412D4&invitationId=inv_31f324cb-a29a-4b72-a9d6-cbb84053b3d1&page=HWEp-vi-RSFO#
public class Player {

    private String name;
    private int jerseyNumber;
    private int position;
    private double averageRating;
    private String playerImage;

    public Player(String name, int jerseyNumber, int position, double averageRating, String playerImage) {
        setName(name);
        setJerseyNumber(jerseyNumber);
        setPosition(position);
        setAverageRating(averageRating);
        setPlayerImage(playerImage);
    }

    public String getName() {
        return name;
    }

    /**
     * Validate that the name is more than 2 characters
     * @param name
     */
    public void setName(String name) {
        if (name.trim().length() > 2 && !name.isEmpty())
        {
            name = name.substring(0,1).toUpperCase() + name.substring(1) ;
            this.name = name.trim();
        }
        else
            throw new IllegalArgumentException("Name must be at least 2 characters long.");
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    /**
     * Validate that the jersey number is between 0 and 100
     * @param jerseyNumber
     */
    public void setJerseyNumber(int jerseyNumber) {
        if (jerseyNumber >= 0 && jerseyNumber <= 100)
            this.jerseyNumber = jerseyNumber;
        else
            throw new IllegalArgumentException("Jersey Number must be between 0 and 100");
    }

    /**
     * Validates that the position that is pasted is 1 - 5 (1 - Point Guard, 2 -Shooting Guard , 3- Small Forward, 4 - Power Forward, and 5- Center)
     * @param position
     */
    public void setPosition(int position) {
        if (position > 0 && position <= 5 )
            this.position = position;
        else
            throw new IllegalArgumentException("Position must be 1 - 5 {1 - Point Guard, 2 -Shooting Guard , 3- Small Forward, 4 - Power Forward, and 5- Center}");
    }

    /**
     * Method gets the stored int position (1 - Point Guard, 2 -Shooting Guard , 3- Small Forward, 4 - Power Forward, and 5- Center
     * and return the names associated with the int value)
     * @return String Position Name
     */
    public String getPosition() {
        String positionName = "";
        // Using switch case to determine the position name returned.
        switch (this.position) {
            case 1:
                positionName = "Point Guard";
                break;
            case 2:
                positionName = "Shooting Guard";
                break;
            case 3:
                positionName = "Small Forward";
                break;
            case 4:
                positionName = "Power Forward";
                break;
            case 5:
                positionName = "Center";
                break;
        }
        return positionName;
    }

    public double getAverageRating() {
        return averageRating;
    }

    /**
     * Validates that the player rating is between 0 - 100
     * @param averageRating
     */
    public void setAverageRating(double averageRating) {
        if (averageRating >= 0 && averageRating <= 100)
            this.averageRating = averageRating;
        else
            throw new IllegalArgumentException("Player Rating must be betweeen 0 and 100");
    }

    public String getPlayerImage() {
        return playerImage;
    }

    /**
     * Validate thats the player image has the correct path name.
     * @param image
     */
    public void setPlayerImage(String image) {
        if (image.startsWith("/images/players/"))
            this.playerImage = image;
        else
            throw new IllegalArgumentException("Player image provided is invalid");
    }
}
