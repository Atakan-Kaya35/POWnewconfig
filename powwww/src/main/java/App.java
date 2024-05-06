import org.example.powwww.med.*;
import org.example.powwww.DiagnosisTest.*;
import org.example.powwww.DiagnosisTest.Menu;
import org.example.powwww.entity.mobile.physcian.Nurses;
import org.example.powwww.entity.mobile.physcian.Van;
import org.example.powwww.entity.mobile.physcian.Scooter;
import org.example.powwww.entity.stationary.*;
import org.example.powwww.entity.*;
import javax.swing.*;
import java.awt.event.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;

public class App extends Application {

    @FXML
    private Label nameLabel;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    @FXML
    private Button signUPButton2;

    @FXML
    private Button signUPButton3;

    @FXML
    private Button homePageButton;

    @FXML
    private Button ordersPageButton;

    @FXML
    private Button personalInformationButton;

    @FXML
    private Button quickDiagnosisTestButton;

    @FXML
    private Button QDTStartButton;

    @FXML
    private Button QDTNextButton;

    //pop up will be opened and show recomendation
    @FXML
    private Button QDTNextButton2;

    @FXML
    private Button pillsButton;

    private Stage primaryStage;
    @FXML
    private Button purchaseButton;

    @FXML
    private Button openCurrentOrdersButton;

    @FXML
    private TextField userNameLSignUpTextField;

    @FXML
    private TextField passwordSignUpTextField;

    @FXML
    private TextField nameLogInTextField;

    @FXML
    private TextField userNameLogInTextField;

    @FXML
    private TextField ageSignUpTextField;

    @FXML
    private TextField weightSignUpTextField;

    @FXML
    private TextField heightSignUpTextField;

    //personal info page text fields
    @FXML
    private TextField IDField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField ageField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField weightField;

    @FXML
    private TextField heightField;


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
        logInPage = new Scene(fxmlLogIn.load(),1080,720);
        primaryStage.setScene(logInPage);
        
        comboBox.getItems().addAll("Customer", "Nurse", "Scooter", "Van");

        FXMLLoader fxmlHome = new FXMLLoader(App.class.getResource("/org/example/powwww/HomePage.fxml"));
        homePage = new Scene(fxmlHome.load(),1080,720);

        FXMLLoader fxmlPersInfo = new FXMLLoader(App.class.getResource("/org/example/powwww/PersonalInfoPage.fxml"));
        personalInfoPage = new Scene(fxmlPersInfo.load(),1080,720);

        FXMLLoader fxmlQuickDiag = new FXMLLoader(App.class.getResource("/org/example/powwww/WelcomeQDT.fxml"));
        quickDiagnosisPage = new Scene(fxmlQuickDiag.load(),1080,720);

        FXMLLoader fxmlSymptoms = new FXMLLoader(App.class.getResource("/org/example/powwww/SymptomQDT.fxml"));
        symptomsPage = new Scene(fxmlSymptoms.load(),1080,720);

        FXMLLoader fxmlYesNo = new FXMLLoader(App.class.getResource("/org/example/powwww/YesNoQuestQDT.fxml"));
        yesNoQuestPage = new Scene(fxmlYesNo.load(),1080,720);

        FXMLLoader fxmlPills = new FXMLLoader(App.class.getResource("/org/example/powwww/PillsPage.fxml"));
        pillsPage = new Scene(fxmlPills.load(),1080,720);

        //sign up
        signUpButton.setOnAction(e -> {
            primaryStage.setScene(signInOccupationPage);
            String selected = comboBox.getSelectionModel().getSelectedItem();
            //User user; 
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
                user.setName(nameLogInTextField.getText());
                user.setAge(Integer.parseInt(ageSignUpTextField.getText()));
                user.setAge(Integer.parseInt(ageSignUpTextField.getText()));
                user.setWeight(Integer.parseInt(weightSignUpTextField.getText()));
                user.setHeight(Integer.parseInt(heightSignUpTextField.getText()));
                user.setHeight(Integer.parseInt(addressSignUpTextField.getText()));

                //enter home page
                loginButton.setOnAction(eee -> {
                    primaryStage.setScene(homePage);
                }); 
            }); 
        });

        //enter home page
        loginButton.setOnAction(e -> {
            primaryStage.setScene(homePage);
        }); 

        signUPButton3.setOnAction(e -> {
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
            openCurrentOrdersButton.setOnAction(e -> {
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