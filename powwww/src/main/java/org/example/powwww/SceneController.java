package org.example.powwww;

import javafx.collections.FXCollections;
import javafx.event.Event;
import org.example.powwww.DiagnosisTest.*;
import javafx.fxml.Initializable;
import org.example.powwww.Database.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import org.example.powwww.DiagnosisTest.Menu;
import org.example.powwww.MapGridTaslak.GridFrame;
import org.example.powwww.Sim.SimMethods;
import org.example.powwww.Sim.Simulation;
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
import org.example.powwww.grid.Order;
import org.example.powwww.grid.Stationary;
import org.example.powwww.med.Medicine;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static org.example.powwww.Sim.Simulation.pills;


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
    private Button seeMap;
    @FXML
    private TextField userNameTextField;
    @FXML
    private PasswordField passwordTextField;
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
    private Label TotalCost;
    @FXML
    private Label NoOfProducts;
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
    @FXML
    private Label totalCostLabel;
    @FXML
    private Label totalProductLabel;
    @FXML
    private Label totalCostPrev;
    @FXML
    private Label totalProductPrev;
    @FXML
    private Label med1;
    @FXML
    private Label cost1;

    @FXML
    private Label med2;
    @FXML
    private Label cost2;

    @FXML
    private Label med3;
    @FXML
    private Label cost3;

    @FXML
    private Label med4;
    @FXML
    private Label cost4;

    @FXML
    private Label med5;
    @FXML
    private Label cost5;

    @FXML
    private Label med6;
    @FXML
    private Label cost6;

    @FXML
    private Label med7;
    @FXML
    private Label cost7;

    @FXML
    private Label med8;
    @FXML
    private Label cost8;

    @FXML
    private Label med9;
    @FXML
    private Label cost9;

    @FXML
    private Label med10;
    @FXML
    private Label cost10;

    @FXML
    private Label med11;
    @FXML
    private Label cost11;

    @FXML
    private Label med12;
    @FXML
    private Label cost12;

    @FXML
    private Label med13;
    @FXML
    private Label cost13;

    @FXML
    private Label med14;
    @FXML
    private Label cost14;

    @FXML
    private Label med15;
    @FXML
    private Label cost15;

    @FXML
    private Label med16;
    @FXML
    private Label cost16;

    @FXML
    private Label med17;
    @FXML
    private Label cost17;

    @FXML
    private Label med18;
    @FXML
    private Label cost18;

    @FXML
    private Label med19;
    @FXML
    private Label cost19;

    @FXML
    private Label med20;
    @FXML
    private Label cost20;

    @FXML
    private Label med21;
    @FXML
    private Label cost21;

    @FXML
    private Label med22;
    @FXML
    private Label cost22;

    @FXML
    private Label med23;
    @FXML
    private Label cost23;

    @FXML
    private Label med24;
    @FXML
    private Label cost24;

    @FXML
    private Label med0;
    @FXML
    private Label cost0;
    @FXML
    private Button buttonformed0;
    @FXML
    private Button buttonformed1;
    @FXML
    private Button buttonformed2;
    @FXML
    private Button buttonformed3;
    @FXML
    private Button buttonformed4;
    @FXML
    private Button buttonformed5;
    @FXML
    private Button buttonformed6;
    @FXML
    private Button buttonformed7;
    @FXML
    private Button buttonformed8;
    @FXML
    private Button buttonformed9;
    @FXML
    private Button buttonformed10;
    @FXML
    private Button buttonformed11;
    @FXML
    private Button buttonformed12;
    @FXML
    private Button buttonformed13;
    @FXML
    private Button buttonformed14;
    @FXML
    private Button buttonformed15;
    @FXML
    private Button buttonformed16;
    @FXML
    private Button buttonformed17;
    @FXML
    private Button buttonformed18;
    @FXML
    private Button buttonformed19;
    @FXML
    private Button buttonformed20;
    @FXML
    private Button buttonformed21;
    @FXML
    private Button buttonformed22;
    @FXML
    private Button buttonformed23;
    @FXML
    private Button buttonformed24;
    @FXML
    private Text cart1;
    @FXML
    private Text cart2;
    @FXML
    private Text cart3;
    @FXML
    private Text cart4;
    @FXML
    private Text cart5;
    @FXML
    private Text cart6;
    @FXML
    private Text cart7;
    @FXML
    private Text cart8;
    @FXML
    private Text cart9;
    @FXML
    private Text cart10;
    @FXML
    private Text cart11;
    @FXML
    private Text cart12;
    @FXML
    private Text cart13;
    @FXML
    private Text cart14;
    @FXML
    private Text cart15;


    City city = new City(30,20);
    private ArrayList<String> choices = new ArrayList<String>();
    public static ArrayList<Stationary> everyOne = new ArrayList<>();
    public static ArrayList<String> usernames = new ArrayList<>();
    public static ArrayList<String> passwords = new ArrayList<>();
    public static ArrayList<Text> textarr = new ArrayList<>();
    public static String userName;
    public static ArrayList<Medicine> cart = new ArrayList<Medicine>();
    static ArrayList<User> users = new ArrayList<>();
    Patients currentUserPatient;

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
        else {
            usernames.add(SU_Username.getText());
            passwords.add(SU_Password.getText());


            String[] address = SU_Address.getText().split(",");
            int x = Integer.parseInt(address[0]);
            int y = Integer.parseInt(address[1]);
            // Create a new user(address problem)
            Stationary newUser = new Patients(SU_Name.getText(), x, y, city);

            // Add the new user to the list of users
            everyOne.add(newUser);
            SQLTest.addUser(SU_Username.getText(), SU_Password.getText(), Integer.parseInt(SU_Age.getText()), SU_Name.getText(), Integer.parseInt(SU_Weight.getText()), Integer.parseInt(SU_Height.getText()), x, y);
            usernames.add(SU_Username.getText());
            passwords.add(SU_Password.getText());

            System.out.println("User signed up successfully.");
            System.out.println(usernames.get(0));
            fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/Merhaba.fxml"));
            root = fxmlLoader.load();
            scene = new Scene(root);
            scene.setRoot(root);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }
    private static boolean isUsernameTaken(String username) {
        return usernames.contains(username);
    }

    public void switchToHomePageWithLogIn(ActionEvent event) throws IOException {
        //if(UserMethods.login(userNameTextField.getText(), passwordTextField.getText())) {
        userName = userNameTextField.getText();
        currentUserPatient = new Patients();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/powwww/HomePage.fxml"));
        Parent root = loader.load();

        // Set the scene
        Scene scene = new Scene(root);

        // Set the controller
        SceneController controller = loader.getController();

        // Set the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

        // Call setItems() after the ComboBox is initialized
        controller.setInfos();
            /*userName = userNameTextField.getText();
            fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/HomePage.fxml"));
            root = fxmlLoader.load();
            scene = new Scene(root);
            scene.setRoot(root);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            setInfos();*/
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/powwww/HomePage.fxml"));
        Parent root = loader.load();

        // Set the scene
        Scene scene = new Scene(root);

        // Set the controller
        SceneController controller = loader.getController();

        // Set the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

        // Call setItems() after the ComboBox is initialized
        controller.setInfos();
        stage.show();
    }
    public void switchToPersonalInfoPage(ActionEvent event) throws IOException {
        //fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/PersonalInfoPage.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/powwww/PersonalInfoPage.fxml"));
        Parent root = loader.load();

        // Set the scene
        Scene scene = new Scene(root);

        // Set the controller
        SceneController controller = loader.getController();

        // Set the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        controller.setInfos();
        controller.setInfoPIP();

        // Call setItems() after the ComboBox is initialized
        /*controller.setInfos();
        root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        setInfos();*/

        stage.show();
    }
    public void switchToPillsPage(ActionEvent event) throws IOException {
        //fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/PillsPage.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/powwww/PillsPage.fxml"));
        Parent root = loader.load();

        // Set the scene
        Scene scene = new Scene(root);

        // Set the controller
        SceneController controller = loader.getController();

        // Set the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);


        // Call setItems() after the ComboBox is initialized
        controller.setInfos();
        controller.setCost();
        controller.changeTotalCost();
        controller.changeNoOfProducts();
        /*root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        setInfos();*/
        stage.show();
    }
    public void switchToQDTPage(ActionEvent event) throws IOException {
        //fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/WelcomeQDT.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/powwww/WelcomeQDT.fxml"));
        Parent root = loader.load();

        // Set the scene
        Scene scene = new Scene(root);

        // Set the controller
        SceneController controller = loader.getController();

        // Set the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        // Call setItems() after the ComboBox is initialized
        controller.setInfos();
        /*root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        setInfos();*/
        stage.show();
    }
    public void switchToOrdersPage(ActionEvent event) throws IOException {
        //fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/OrdersPage.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/powwww/OrdersPage.fxml"));
        Parent root = loader.load();

        // Set the scene
        Scene scene = new Scene(root);

        // Set the controller
        SceneController controller = loader.getController();

        // Set the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

        // Call setItems() after the ComboBox is initialized
        controller.setInfos();
        /*root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        setInfos();*/
        stage.show();
    }
    public void switchToCurrentOrdersPage(ActionEvent event) throws IOException {
        //fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/CurrentOrdersPage.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/powwww/CurrentOrdersPage.fxml"));
        Parent root = loader.load();

        // Set the scene
        Scene scene = new Scene(root);

        // Set the controller
        SceneController controller = loader.getController();

        // Set the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

        // Call setItems() after the ComboBox is initialized
        controller.setInfos();
        /*root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        setInfos();*/
        stage.show();
    }
    public void Exit(ActionEvent event) throws IOException {
        //fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/powwww/Merhaba.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/powwww/Merhaba.fxml"));
        Parent root = loader.load();

        // Set the scene
        Scene scene = new Scene(root);

        // Set the controller
        SceneController controller = loader.getController();

        // Set the stage
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);

        // Call setItems() after the ComboBox is initialized
        controller.setInfos();
        /*root = fxmlLoader.load();
        scene = new Scene(root);
        scene.setRoot(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);*/
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
        String[] userInfo = SQLTest.getUserInfo(userName);
        String userName_ = userInfo[3];
        A_Name.setText(userName_);
        String weight_ = userInfo[0] + " kg";
        A_Weight.setText(weight_);
        String height_ = userInfo[1] + " cm";
        A_Height.setText(height_);
        String age_ = userInfo[2] + " years";
        A_Age.setText(age_);

        // create the patient as soon as the information is made available
        currentUserPatient = new Patients(userInfo[3], Integer.parseInt(userInfo[4]), Integer.parseInt(userInfo[5]), city);
    }
    public void openQDT(ActionEvent event) {
        // Instantiate a Swing JFrame
        JFrame menuFrame = new Menu();
        menuFrame.setTitle("Pills on Wheels");
        menuFrame.setDefaultCloseOperation(menuFrame.DISPOSE_ON_CLOSE);
        menuFrame.setVisible(true);
    }
    public void openMap(ActionEvent event){
        SimMethods.buildBilkent(city);

        JFrame grid = new GridFrame(city);

        city.viewMap(false);
        ((GridFrame)grid).showTime(10);
        ((GridFrame)grid).getPanel().repaint();
    }
    public void setInfoPIP(){
        String[] userInfo = SQLTest.getUserInfo(userName);
        String bmi = String.format("%,2f",(Integer.parseInt(userInfo[2]) / (Integer.parseInt(userInfo[1]) / 100.0)));
        bmi += ((Integer.parseInt(userInfo[2]) / (Integer.parseInt(userInfo[1]) / 100.0)) < 15 || (Integer.parseInt(userInfo[1]) / (Integer.parseInt(userInfo[2]) / 100.0)) > 25)? "(good)" : " (bad)";
        bmi_p.setText(bmi);
        name_p.setText(userInfo[3]);
        age_p.setText(userInfo[2] + " years");
        address_p.setText(userInfo[4]+userInfo[5]);
        weigth_p.setText(userInfo[0] + " kg");
        height_p.setText(userInfo[1] + " cm");
    }
    public void setCost(){
        cost0.setText(""+ pills.get(0).getPrice());
        cost1.setText(""+ pills.get(1).getPrice());
        cost2.setText(""+ pills.get(2).getPrice());
        cost3.setText(""+ pills.get(3).getPrice());
        cost4.setText(""+ pills.get(4).getPrice());
        cost5.setText(""+ pills.get(5).getPrice());
        cost6.setText(""+ pills.get(6).getPrice());
        cost7.setText(""+ pills.get(7).getPrice());
        cost8.setText(""+ pills.get(8).getPrice());
        cost9.setText(""+ pills.get(9).getPrice());
        cost10.setText(""+ pills.get(10).getPrice());
        cost11.setText(""+ pills.get(11).getPrice());
        cost12.setText(""+ pills.get(12).getPrice());
        cost13.setText(""+ pills.get(13).getPrice());
        cost14.setText(""+ pills.get(14).getPrice());
        cost15.setText(""+ pills.get(15).getPrice());
        cost16.setText(""+ pills.get(16).getPrice());
        cost17.setText(""+ pills.get(17).getPrice());
        cost18.setText(""+ pills.get(18).getPrice());
        cost19.setText(""+ pills.get(19).getPrice());
        cost20.setText(""+ pills.get(20).getPrice());
        cost21.setText(""+ pills.get(21).getPrice());
        cost22.setText(""+ pills.get(22).getPrice());
        cost23.setText(""+ pills.get(23).getPrice());
        cost24.setText(""+ pills.get(24).getPrice());
    }
    public void textArray(){
        textarr.add(cart1);
        textarr.add(cart2);
        textarr.add(cart3);
        textarr.add(cart4);
        textarr.add(cart5);
        textarr.add(cart6);
        textarr.add(cart7);
        textarr.add(cart8);
        textarr.add(cart9);
        textarr.add(cart10);
        textarr.add(cart11);
        textarr.add(cart12);
        textarr.add(cart13);
        textarr.add(cart14);
        textarr.add(cart15);
    }
    public Text getEmptyText(){
        textArray();
        for(Text t : textarr){
            if(t.getText().equals("")){
                return t;
            }
        }
        System.out.println("null hatası salakakk");
        return null;
    }

    public void setMedInCart(int index) {
        String pillName = pills.get(index).getName();
        if (isThereSameMedicine(pillName)) {
            findText(pillName).setText(countOfMedicine(pillName));
            cart.add(pills.get(index));
            changeTotalCost();
            changeNoOfProducts();
        } else {
            getEmptyText().setText(pillName);
            cart.add(pills.get(index));
            changeTotalCost();
            changeNoOfProducts();
        }
    }
    public void setMedInCart0(ActionEvent event) {
        setMedInCart(0);
    }

    public void setMedInCart1(ActionEvent event) {
        setMedInCart(1);
    }

    public void setMedInCart2(ActionEvent event) {
        setMedInCart(2);
    }

    public void setMedInCart3(ActionEvent event) {
        setMedInCart(3);
    }

    public void setMedInCart4(ActionEvent event) {
        setMedInCart(4);
    }

    public void setMedInCart5(ActionEvent event) {
        setMedInCart(5);
    }

    public void setMedInCart6(ActionEvent event) {
        setMedInCart(6);
    }

    public void setMedInCart7(ActionEvent event) {
        setMedInCart(7);
    }

    public void setMedInCart8(ActionEvent event) {
        setMedInCart(8);
    }

    public void setMedInCart9(ActionEvent event) {
        setMedInCart(9);
    }

    public void setMedInCart10(ActionEvent event) {
        setMedInCart(10);
    }

    public void setMedInCart11(ActionEvent event) {
        setMedInCart(11);
    }

    public void setMedInCart12(ActionEvent event) {
        setMedInCart(12);
    }

    public void setMedInCart13(ActionEvent event) {
        setMedInCart(13);
    }

    public void setMedInCart14(ActionEvent event) {
        setMedInCart(14);
    }

    public void setMedInCart15(ActionEvent event) {
        setMedInCart(15);
    }

    public void setMedInCart16(ActionEvent event) {
        setMedInCart(16);
    }

    public void setMedInCart17(ActionEvent event) {
        setMedInCart(17);
    }

    public void setMedInCart18(ActionEvent event) {
        setMedInCart(18);
    }

    public void setMedInCart19(ActionEvent event) {
        setMedInCart(19);
    }

    public void setMedInCart20(ActionEvent event) {
        setMedInCart(20);
    }

    public void setMedInCart21(ActionEvent event) {
        setMedInCart(21);
    }

    public void setMedInCart22(ActionEvent event) {
        setMedInCart(22);
    }

    public void setMedInCart23(ActionEvent event) {
        setMedInCart(23);
    }

    public void setMedInCart24(ActionEvent event) {
        setMedInCart(24);
    }

    
    public boolean isThereSameMedicine(String name){
        for (int i = 0; i < cart.size(); i++) {
            String[] med = textarr.get(i).getText().split(" ");
            if(med[0].equals(name)){
                return true;
            }
        }
        return false;
    }
    public String countOfMedicine(String name){
        int counter = 0;

        for (int i = 0; i < cart.size(); i++) {
            String[] med = textarr.get(i).getText().split(" ");
            if(med.length>1 && med[0].equals(name)){
                counter = Integer.parseInt(med[2]) + 1;
            }
            else if(med[0].equals(name)){
                counter++;
            }
        }
        if(counter == 0){
            return name;
        }
        return name + " x " + (counter);
    }
    public Text findText(String name){
        for (int i = 0; i < cart.size(); i++) {
            String[] med = textarr.get(i).getText().split(" ");
            if(med[0].equals(name)){
                return textarr.get(i);
            }
        }
        return getEmptyText();
    }
    public void changeTotalCost(){
        double totalCost = 0;
        for (int i = 0; i < cart.size(); i++) {
            totalCost += cart.get(i).getPrice();
        }
        TotalCost.setText(""+totalCost );
    }
    public void changeNoOfProducts(){
        NoOfProducts.setText(""+cart.size() );
    }

    public void giveOrder(ActionEvent event){
        Order newOrder = new Order(currentUserPatient, cart);
    }

}
