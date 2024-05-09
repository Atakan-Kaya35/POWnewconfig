package org.example.powwww;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class SceneController {
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;

    private Stage stage;
    private Scene scene;
    private Parent root ;
    private FXMLLoader fxmlLoader;

    public void switchToSignUpPage(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/SignInPage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
