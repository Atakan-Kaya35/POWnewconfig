package org.example.powwww;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.powwww.Sim.Simulation;

import java.io.IOException;

public class Applic extends Application implements Runnable {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/example/powwww/Merhaba.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Create a separate thread for your simulation
        Thread simulationThread = new Thread(new Simulation());
        simulationThread.start();

        // Launch the JavaFX application
        launch(args);
    }

    @Override
    public void run() {
        // Your custom behavior for the simulation goes here
        // This method will be executed in a separate thread
        Simulation.runThisShit(); // Assuming this method exists in your code
    }
}

