package com.example.comp1008assignment2;

public class Player {

    private String name;
    private int jerseyNumber;
    private double averageRating;

    public Player(String name, int jerseyNumber, double averageRating) {
        setName(name);
        setJerseyNumber(jerseyNumber);
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
