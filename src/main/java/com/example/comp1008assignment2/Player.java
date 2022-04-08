package com.example.comp1008assignment2;

//https://lucid.app/lucidchart/47dcb37e-3da7-42d6-99e9-4495f77be6c1/edit?beaconFlowId=D277759F349412D4&invitationId=inv_31f324cb-a29a-4b72-a9d6-cbb84053b3d1&page=HWEp-vi-RSFO#
public class Player {

    private String name;
    private int jerseyNumber;
    private int position;
    private double averageRating;

    public Player(String name, int jerseyNumber, int position, double averageRating) {
        setName(name);
        setJerseyNumber(jerseyNumber);
        setPosition(position);
        setAverageRating(averageRating);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    @Override
    public String toString() {
        return String.format("");
    }
}
