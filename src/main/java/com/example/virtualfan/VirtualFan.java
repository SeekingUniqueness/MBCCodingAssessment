package com.example.virtualfan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The VirtualFan class represents a graphical view of a virtual fan
 */
public class VirtualFan extends Application {

    /**
     * Starts the loading of the VirtualFan application
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws IOException if it fails to load the FXML view
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VirtualFan.class.getResource("fan-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMinWidth(325);
        stage.setMinHeight(400);
        stage.setTitle("Virtual Fan Application");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Constructs a new VirtualFan
     */
    public VirtualFan() {}

    /**
     * The entry point for the application
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}