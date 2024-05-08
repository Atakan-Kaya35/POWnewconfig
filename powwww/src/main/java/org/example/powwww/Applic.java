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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

import static javafx.application.Application.launch;
import static org.example.powwww.Sim.UserMethods.*;

/*public class Applic extends Application {

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
    public void start(Stage primaryStage) throws Exception {
        try {
        FXMLLoader fxmlLogIn = new FXMLLoader(App.class.getResource("/org/example/powwww/Merhaba.fxml"));
        logInPage = new Scene(fxmlLogIn.load(),600,400);
        primaryStage.setScene(logInPage);

        @FXML
        void initialize(){
            loginButton.setOnAction(e -> {
                System.out.println("oluyor");
            });
        }


        primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/


public class Applic extends Application{

    @FXML
    public Button loginButton = new Button();
    @FXML
    public Button signUpButton = new Button();
    @FXML
    public TextField userNameTextField = new TextField();
    @FXML
    public TextField passwordTextField = new TextField();
    public Scene logInPage;
    public void start(Stage primaryStage) throws IOException{

        FXMLLoader fxmlLogIn = new FXMLLoader(App.class.getResource("/org/example/powwww/Merhaba.fxml"));
        logInPage = new Scene(fxmlLogIn.load(),600,400);
        primaryStage.setScene(logInPage);

        loginButton.setOnAction(event -> {
            System.out.println("oluyor");
            login(userNameTextField.getText(),passwordTextField.getText());

        });
    }

    private boolean login(String username, String password) {
            // Check if the username exists
            int index = usernames.indexOf(username);
            if (index == -1) {
                System.out.println("Username not found.");
                return false;
            }

            // Check if the password matches
            if (!passwords.get(index).equals(password)) {
                System.out.println("Incorrect password.");
                return false;
            }

            System.out.println("Login successful. Welcome, " + everyOne.get(index).getName() + "!");
            return true;

    }
    public static void main(String[] args) {
        launch(args);
    }

}

