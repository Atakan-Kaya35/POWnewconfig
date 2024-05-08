package org.example.powwww;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Applic.class.getResource("/org/example/powwww/Merhaba.fxml"));
        FXMLLoader fxmlLogIn = new FXMLLoader(App.class.getResource("/org/example/powwww/Merhaba.fxml"));
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
