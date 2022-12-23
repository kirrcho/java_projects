package com.example.javafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML // fx:id="operators"
    private ComboBox<String> operators;

    @FXML
    private TextField result;

    @FXML
    private TextField firstElement;

    @FXML
    private TextField secondElement;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        operators.getItems().setAll("+", "-", "*", "/");

        firstElement.setText("0");
        secondElement.setText("0");

        result.setEditable(false);
    }

    @FXML
    protected void onCalculateButtonCLick() {
        switch (operators.getValue()) {
            case "+":
                result.setText(String.format("%f",Double.parseDouble(firstElement.getText()) + Double.parseDouble(secondElement.getText())));
                break;
            case "-":
                result.setText(String.format("%f",Double.parseDouble(firstElement.getText()) - Double.parseDouble(secondElement.getText())));
                break;
            case "*":
                result.setText(String.format("%f",Double.parseDouble(firstElement.getText()) * Double.parseDouble(secondElement.getText())));
                break;
            case "/":
                result.setText(String.format("%f",Double.parseDouble(firstElement.getText()) / Double.parseDouble(secondElement.getText())));
                break;
        }
    }
}