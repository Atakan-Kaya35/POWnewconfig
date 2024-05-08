package org.example.powwww;

import com.almasb.fxgl.cutscene.dialogue.BranchNode;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Applic extends Application {
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/powwww/Merhaba.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void logInTry(ActionEvent event) {
        System.out.println("Log in attempt");
    }

    @FXML
    private void openSignUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/SignInPage.fxml"));
        Parent root = fxmlLoader.getRoot();

        Stage stage = new Stage();
        Scene signUpScene = new Scene(root, 600, 400);
        stage.setScene(signUpScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
