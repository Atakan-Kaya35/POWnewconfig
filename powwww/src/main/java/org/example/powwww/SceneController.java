package org.example.powwww;

import javafx.scene.control.Alert;
import org.example.powwww.Sim.UserMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.powwww.Sim.UserMethods;

import java.io.IOException;


public class SceneController {
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    @FXML
    private Button signUpButtonTwo;
    @FXML
    private Button signUpButtonThree;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;

    private Stage stage;
    private Scene scene;
    private Parent root ;
    private FXMLLoader fxmlLoader;

    public void switchToSignUpPage(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/SignInForNursesAndCourier.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSignUpPage2(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/SignInPage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSignUpPagetoLogIn(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/Merhaba.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToHomePageWithLogIn(ActionEvent event) throws IOException {
        if(UserMethods.login(userNameTextField.getText(), passwordTextField.getText())) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/HomePage.fxml"));
            root = fxmlLoader.load();
            scene = new Scene(root);
            scene.setRoot(root);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Check your personal information, and try to Login");
            alert.setContentText("You might type wrong user name or password");
            alert.setHeaderText("Information Error");
            alert.showAndWait();
        }
    }
    public void switchToHomePageInApp(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/HomePage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
