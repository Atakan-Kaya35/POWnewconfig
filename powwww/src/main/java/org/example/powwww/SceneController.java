package org.example.powwww;

import javafx.collections.FXCollections;
import javafx.event.Event;
import org.example.powwww.DiagnosisTest.*;
import javafx.fxml.Initializable;
import org.example.powwww.Database.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.example.powwww.DiagnosisTest.Menu;
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

import javax.swing.*;
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
    private Button QDTStart;
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
    private Text A_Remainder;
    @FXML
    private TextField name_p;
    @FXML
    private TextField age_p;
    @FXML
    private TextField address_p;
    @FXML
    private TextField weigth_p;
    @FXML
    private TextField height_p;
    @FXML
    private TextField bmi_p;

    City city = new City(20,20);
    private ArrayList<String> choices = new ArrayList<String>();
    public static ArrayList<Stationary> everyOne = new ArrayList<>();
    public static ArrayList<String> usernames = new ArrayList<>();
    public static ArrayList<String> passwords = new ArrayList<>();
    public static String userName;
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
        else{
            usernames.add(SU_Username.getText());
            passwords.add(SU_Password.getText());
        }

        String[] address = SU_Address.getText().split(",");
        int x = Integer.parseInt(address[0]);
        int y = Integer.parseInt(address[1]);
        // Create a new user(address problem)
        Stationary newUser = new Patients(SU_Name.getText(), x, y, city);

        // Add the new user to the list of users
        everyOne.add(newUser);
        SQLTest.userAdder(SU_Username.getText(),SU_Password.getText(),Integer.parseInt(SU_Age.getText()),SU_Name.getText(),Integer.parseInt(SU_Weight.getText()),Integer.parseInt(SU_Height.getText()),x,y);
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

            userName = userNameTextField.getText();
            fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/HomePage.fxml"));
            root = fxmlLoader.load();
            scene = new Scene(root);
            scene.setRoot(root);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            setInfos();
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
        setInfos();
        stage.show();
    }
    public void switchToPersonalInfoPage(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/PersonalInfoPage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        setInfos();
        name_p.setText(SQLTest.getUserInfo(userName)[0]);
        age_p.setText(SQLTest.getUserInfo(userName)[3]);
        address_p.setText(SQLTest.getUserInfo(userName)[4]+SQLTest.getUserInfo(userName)[5]);
        weigth_p.setText(SQLTest.getUserInfo(userName)[1]);
        height_p.setText(SQLTest.getUserInfo(userName)[2]);
        stage.show();
    }
    public void switchToPillsPage(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/PillsPage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        setInfos();
        stage.show();
    }
    public void switchToQDTPage(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/WelcomeQDT.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        setInfos();
        stage.show();
    }
    public void switchToOrdersPage(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/OrdersPage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        setInfos();
        stage.show();
    }
    public void switchToCurrentOrdersPage(ActionEvent event) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/CurrentOrdersPage.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        setInfos();
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
    public void setInfos(){
        String userName_ = SQLTest.getUserInfo(userName)[0];
        A_Name.setText(userName_);
        String weight_ = SQLTest.getUserInfo(userName)[1];
        A_Weight.setText(weight_);
        String height_ = SQLTest.getUserInfo(userName)[2];
        A_Height.setText(height_);
        String age_ = SQLTest.getUserInfo(userName)[3];
        A_Name.setText(age_);
    }
    public void openQDT(ActionEvent event) {
        // Instantiate a Swing JFrame
        JFrame menuFrame = new Menu();
        menuFrame.setTitle("Pills on Wheels");
        menuFrame.setDefaultCloseOperation(menuFrame.DISPOSE_ON_CLOSE);
        menuFrame.setVisible(true);

    }
}
