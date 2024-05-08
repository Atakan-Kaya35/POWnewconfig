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
import java.io.IOException;
import java.util.*;

public class App extends Application {

    @FXML
    private Label nameLabel = new Label();

    @FXML
    private Button loginButton = new Button();

    @FXML
    private Button Allahimmmmm = new Button();

    @FXML
    private Button signUPButton2 = new Button();

    @FXML
    private Button signUPButton3 = new Button();

    @FXML
    private Button homePageButton = new Button();

    @FXML
    private Button ordersPageButton = new Button();

    @FXML
    private Button personalInformationButton = new Button();

    @FXML
    private Button quickDiagnosisTestButton = new Button();

    @FXML
    private Button QDTStartButton = new Button();

    @FXML
    private Button QDTNextButton = new Button();

    //pop up will be opened and show recomendation
    @FXML
    private Button QDTNextButton2 = new Button();

    @FXML
    private Button pillsButton = new Button();

    private Stage primaryStage;
    @FXML
    private Button purchaseButton = new Button();

    @FXML
    private Button openCurrentOrdersButton = new Button();

    @FXML
    private TextField userNameLSignUpTextField = new TextField();

    @FXML
    private TextField passwordSignUpTextField = new TextField();

    @FXML
    private TextField nameLogInTextField = new TextField();

    @FXML
    private TextField userNameLogInTextField = new TextField();

    @FXML
    private TextField passwordLogInTextField = new TextField();

    @FXML
    private TextField ageSignUpTextField = new TextField();

    @FXML
    private TextField weightSignUpTextField = new TextField();

    @FXML
    private TextField heightSignUpTextField = new TextField();

    @FXML
    private TextField addressTextField = new TextField();

    @FXML
    private TextField nameLSignUpTextField = new TextField();

    //personal info page text fields
    @FXML
    private TextField IDField = new TextField();

    @FXML
    private TextField nameField = new TextField();

    @FXML
    private TextField ageField = new TextField();

    @FXML
    private TextField addressField = new TextField();

    @FXML
    private TextField weightField = new TextField();

    @FXML
    private TextField heightField = new TextField();


    @FXML
    ComboBox<String> comboBox = new ComboBox<>();

    double totalCost;
    int totalProduct;
    ArrayList<Medicine> purchaseList = new ArrayList<Medicine>();

    private Scene logInPage, signInOccupationPage, signInPage, homePage, pillsPage, personalInfoPage, ordersPage, currentOrdersPage,
    quickDiagnosisPage, yesNoQuestPage, symptomsPage, homePageForOthers, personalInfoPageForOthers, deliveriesPage, currentDeliveryPage; 
    
    User user;

    public void start(Stage primaryStage) throws IOException{

        FXMLLoader fxmlLogIn = new FXMLLoader(App.class.getResource("/org/example/powwww/Merhaba.fxml"));
        logInPage = new Scene(fxmlLogIn.load(),600,400);
        primaryStage.setScene(logInPage);
        
        comboBox.getItems().addAll("Customer", "Nurse", "Scooter", "Van");

        FXMLLoader fxmlHome = new FXMLLoader(App.class.getResource("/org/example/powwww/HomePage.fxml"));
        homePage = new Scene(fxmlHome.load(),1080,720);

        FXMLLoader fxmlSignInOccupation = new FXMLLoader(App.class.getResource("/org/example/powwww/SignInOccupationPage.fxml"));
        signInOccupationPage = new Scene(fxmlSignInOccupation.load(), 600, 400);


        FXMLLoader fxmlPersInfo = new FXMLLoader(App.class.getResource("/org/example/powwww/PersonalInfoPage.fxml"));
        personalInfoPage = new Scene(fxmlPersInfo.load(),1080,720);

        FXMLLoader fxmlQuickDiag = new FXMLLoader(App.class.getResource("/org/example/powwww/WelcomeQDT.fxml"));
        quickDiagnosisPage = new Scene(fxmlQuickDiag.load(),1080,720);

        /*FXMLLoader fxmlSymptoms = new FXMLLoader(App.class.getResource("/org/example/powwww/SymptomQDT.fxml"));
        symptomsPage = new Scene(fxmlSymptoms.load(),1080,720);
*/
        /*FXMLLoader fxmlYesNo = new FXMLLoader(App.class.getResource("/org/example/powwww/YesNoQuestQDT.fxml"));
        yesNoQuestPage = new Scene(fxmlYesNo.load(),1080,720);*/

        /*FXMLLoader fxmlPills = new FXMLLoader(App.class.getResource("/org/example/powwww/PillsPage.fxml"));
        pillsPage = new Scene(fxmlPills.load(),1080,720);*/

        //sign up

        Allahimmmmm.setOnAction(e -> {
            primaryStage.setScene(signInOccupationPage);
            String selected = comboBox.getSelectionModel().getSelectedItem();
            User user;
            if(selected.equals("Customer")){
                user = new Patients();
            }
            else if(selected.equals("Nurse")){

                user = new Nurses();
            }
            else if(selected.equals("Scooter")){
                user = new Scooter();
            }
            else{
                user = new Van();
            }

            signUPButton2.setOnAction(ee -> {
                primaryStage.setScene(signInPage);

                user.setUserName(userNameLSignUpTextField.getText());
                user.setPassword(passwordSignUpTextField.getText());
                user.setName(nameLSignUpTextField.getText());
                user.setAddress(addressTextField.getText());
                user.setAge(Integer.parseInt(ageSignUpTextField.getText()));
                user.setAge(Integer.parseInt(ageSignUpTextField.getText()));
                user.setWeight(Integer.parseInt(weightSignUpTextField.getText()));
                user.setHeight(Integer.parseInt(heightSignUpTextField.getText()));
                String[] coord = new String[2];
                coord = addressTextField.getText().split(",");
                //UserMethods.signUp(user.getName(),Integer.parseInt(coord[0]), Integer.parseInt(coord[1]), user.getUserName(), user.getPassword());
                signUPButton2.setOnAction(eee -> {
                            primaryStage.setScene(logInPage);
                });
                    //enter home page
                    loginButton.setOnAction(eeee -> {
                        primaryStage.setScene(homePage);
                });
            });
        });

        //enter home page
        loginButton.setOnAction(e -> {
            UserMethods.login(userNameLogInTextField.getText(), passwordLogInTextField.getText());
            primaryStage.setScene(homePage);
        });

        homePageButton.setOnAction(e -> {
            primaryStage.setScene(homePage);
        });

        //enter personal info page
        personalInformationButton.setOnAction(e -> {
            primaryStage.setScene(personalInfoPage);

            TextField IDfield = new TextField();
            IDfield.setText("" + user.getID());
            IDfield.setEditable(true);

            TextField nameField = new TextField();
            nameField.setText("" + user.getName());
            nameField.setEditable(true);

            TextField ageField = new TextField();
            ageField.setText("" + user.getAge());
            ageField.setEditable(true);

            TextField addressField = new TextField();
            addressField.setText("" + user.getAddress());
            addressField.setEditable(true);

            TextField weightField = new TextField();
            weightField.setText("" + user.getWeight());
            weightField.setEditable(true);

            TextField heightField = new TextField();
            heightField.setText("" + user.getHeight());
            heightField.setEditable(true);
        }); 

        //quick diagnosis test
        quickDiagnosisTestButton.setOnAction(e -> {
            primaryStage.setScene(quickDiagnosisPage);
        }); 

        QDTStartButton.setOnAction(e -> {
            primaryStage.setScene(symptomsPage);
        });

        QDTNextButton.setOnAction(e -> {
            primaryStage.setScene(yesNoQuestPage);
        });

        pillsButton.setOnAction(e -> {
            primaryStage.setScene(pillsPage);
        });

        ordersPageButton.setOnAction(e -> {
            primaryStage.setScene(ordersPage);
            // TODO: add order history
            openCurrentOrdersButton.setOnAction(ee -> {
                primaryStage.setScene(currentOrdersPage);
                // TODO: add current order

            });
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}