package org.example.powwww;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.powwww.Sim.UserMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.powwww.Sim.UserMethods;
import org.example.powwww.entity.User;
import org.example.powwww.entity.stationary.Patients;
import org.example.powwww.grid.City;
import org.example.powwww.grid.Stationary;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


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
    private Button homePage;
    @FXML
    private Button personalInfoPage;
    @FXML
    private Button pillsPage;
    @FXML
    private Button QDT;
    @FXML
    private Button Purchase;
    @FXML
    private Button history;
    @FXML
    private Button exit;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField SU_Name;
    @FXML
    private TextField SU_Username;
    @FXML
    private TextField SU_Password;
    @FXML
    private TextField SU_Age;
    @FXML
    private TextField SU_Weight;
    @FXML
    private TextField SU_Height;
    @FXML
    private TextField SU_Address;
    @FXML
    private ComboBox<String> occupationSelectionBox;
    @FXML
    private Label A_Name;
    @FXML
    private Label A_Age;
    @FXML
    private Label A_Weight;
    @FXML
    private Label A_Height;
    @FXML
    private Label A_Remainder;
    City city = new City(20,20);
    private ArrayList<String> choices = new ArrayList<String>();
    public static ArrayList<Stationary> everyOne = new ArrayList<>();
    public static ArrayList<String> usernames = new ArrayList<>();
    public static ArrayList<String> passwords = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();

    private Stage stage;
    private Scene scene;
    private Parent root ;
    private FXMLLoader fxmlLoader;
    public void switchToSignUpPage(ActionEvent event) throws IOException {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/powwww/SignInForNursesAndCourier.fxml"));
        Parent root = loader.load();

        // Set the scene
        Scene scene = new Scene(root);

        // Set the controller
        SceneController controller = loader.getController();

        // Set the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

        // Call setItems() after the ComboBox is initialized
        controller.setItems();

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
        //creating user

        if (isUsernameTaken(SU_Username.getText())) {
            System.out.println("Username is already taken.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Username is already taken.");
            alert.showAndWait();
        }

        // Check if password meets length requirement
        if (SU_Password.getText().length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Password must be at least 8 characters long.");
            alert.showAndWait();
        }

        String[] address = SU_Address.getText().split(",");
        int x = Integer.parseInt(address[0]);
        int y = Integer.parseInt(address[1]);
        // Create a new user(address problem)
        Stationary newUser = new Patients(SU_Name.getText(), x, y, city);

        // Add the new user to the list of users
        everyOne.add(newUser);
        usernames.add(SU_Username.getText());
        passwords.add(SU_Password.getText());

        System.out.println("User signed up successfully.");
        System.out.println(usernames.get(0));
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/Merhaba.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    private static boolean isUsernameTaken(String username) {
        return usernames.contains(username);
    }
    public void switchToHomePageWithLogIn(ActionEvent event) throws IOException {
        //if(UserMethods.login(userNameTextField.getText(), passwordTextField.getText())) {
            fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/HomePage.fxml"));
            root = fxmlLoader.load();
            scene = new Scene(root);
            scene.setRoot(root);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        //}
        /*else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Check your personal information, and try to Login");
            alert.setContentText("You might type wrong user name or password");
            alert.setHeaderText("Information Error");
            alert.showAndWait();
        }*/
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
    public void switchToPersonalInfoPage(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/PersonalInfoPage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToPillsPage(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/PillsPage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToQDTPage(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/WelcomeQDT.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToOrdersPage(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/OrdersPage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToCurrentOrdersPage(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/CurrentOrdersPage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void Exit(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/Merhaba.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void setItems(){
        choices.add("Nurse");
        choices.add("Patient");
        choices.add("Courier");
        occupationSelectionBox.getItems().addAll(choices);
        System.out.println("sevgi");
    }
}
