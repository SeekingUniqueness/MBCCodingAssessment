package com.example.virtualfan;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * The FanController class acts as the controller for the VirtualFan application
 */
public class FanController {
    Fan fan;
    RotateTransition rotation;
    @FXML
    private Label fanSpeed;
    @FXML
    private Label fanDirection;
    @FXML
    private ImageView fanImage;
    @FXML
    private void pullSpeedCord(Event event) {
        fan.pullSpeedString();
        updateRotation();
        event.consume();
    }
    @FXML
    private void pullDirectionCord(Event event) {
        fan.pullDirectionString();
        updateRotation();
        event.consume();
    }
    private void updateRotation() {
        Duration duration = fan.isStopped() ? Duration.ZERO : Duration.millis(4000.0 / fan.getSpeed());
        double angle = fan.getDirection() == Fan.Direction.CLOCKWISE ? 360.0 : -360.0;
        rotation.stop();
        rotation.setDuration(duration);
        rotation.setByAngle(angle);
        if (!fan.isStopped()) {
            rotation.play();
        }
    }

    /**
     * Initializes the controller
     */
    public void initialize(){
        fan = new Fan();
        rotation = new RotateTransition();
        rotation.setNode(fanImage);
        updateRotation();
        rotation.setCycleCount(RotateTransition.INDEFINITE);
        rotation.setInterpolator(Interpolator.LINEAR);
        fanSpeed.textProperty().bind(fan.speedProperty().asString());
        fanDirection.textProperty().bind(fan.directionProperty().asString());
    }

    /**
     * Constructs a new FanController
     */
    public FanController() {}
}