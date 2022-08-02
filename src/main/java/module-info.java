/**
 * This module contains a single package allowing the implementation of a virtual ceiling fan.
 */
module com.example.virtualfan {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.virtualfan to javafx.fxml;
    exports com.example.virtualfan;
}