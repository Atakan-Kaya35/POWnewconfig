package org.example.powwww;


import org.example.powwww.med.*;
import org.example.powwww.Sim.UserMethods;
import org.example.powwww.entity.mobile.physcian.Nurses;
import org.example.powwww.entity.mobile.physcian.Van;
import org.example.powwww.entity.mobile.physcian.Scooter;
import org.example.powwww.entity.stationary.*;
import org.example.powwww.entity.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.*;

public class Applic extends Application {

    @FXML
    public Button loginButton = new Button();
    @FXML
    public Button signUpButton = new Button();
    @FXML
    public TextField userNameTextField = new TextField();
    @FXML
    public TextField passwordTextField = new TextField();
    public Scene logInPage;
    public Stage primaryStage;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLogIn = new FXMLLoader(App.class.getResource("/org/example/powwww/Merhaba.fxml"));
        logInPage = new Scene(fxmlLogIn.load(),600,400);
        primaryStage.setScene(logInPage);

        loginButton.setOnAction(e -> {
            System.out.println("oluyor");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
