package org.example.powwww;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import org.example.powwww.grid.Stationary;
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

import javax.swing.*;
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
<<<<<<< Updated upstream
        try {
=======
>>>>>>> Stashed changes
        FXMLLoader fxmlLogIn = new FXMLLoader(App.class.getResource("/org/example/powwww/Merhaba.fxml"));
        logInPage = new Scene(fxmlLogIn.load(),600,400);

        FXMLLoader fxmlHome = new FXMLLoader(App.class.getResource("/org/example/powwww/HomePage.fxml"));
        Scene homePage = new Scene(fxmlHome.load(), 1080, 720);

        primaryStage.setScene(logInPage);

<<<<<<< Updated upstream
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
=======
        loginButton.setOnAction(e -> {
            System.out.println("oluyor");
            primaryStage.setScene(homePage);
        });
        primaryStage.show();
>>>>>>> Stashed changes
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/


public class Applic{
    public static User currentUser;
    private Scene scene;
    private Stage stage;
    private Parent root;
    public static ArrayList<Stationary> everyOne = new ArrayList<>();
    public static ArrayList<String> usernames = new ArrayList<>();
    public static ArrayList<String> passwords = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();
    @FXML
    public Button loginButton;
    @FXML
    public Button signUpButton;
    @FXML
    public TextField userNameTextField;
    @FXML
    public TextField passwordTextField;
    @FXML
    private void logInTry(ActionEvent event){
        System.out.println("oldu");
    }
    public void start(Stage primaryStage) throws IOException{

        
        FXMLLoader fxmlLogIn = new FXMLLoader(App.class.getResource("/org/example/powwww/Merhaba.fxml"));
        Scene logInPage = new Scene(fxmlLogIn.load(),600,400);

        //logInPage = new Scene(fxmlLogIn.load(),600,400);
        primaryStage.setScene(logInPage);

        /*loginButton.setOnAction(event -> {
            System.out.println("oluyor");
        });

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("oluyor");
            }
        });*/

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

