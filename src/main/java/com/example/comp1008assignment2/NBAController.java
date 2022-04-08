package com.example.comp1008assignment2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NBAController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}