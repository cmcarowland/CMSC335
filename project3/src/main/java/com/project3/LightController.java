/**
 * CMSC 335
 * LightController.java
 * DATE: 22 APR 25
 * AUTHOR: Raymond Rowland
 * 
 * A controller for managing the GUI elements of traffic lights at an intersection.
 */
package com.project3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Platform;

public class LightController {
    @FXML
    private CustomGroup group;
    @FXML
    private Circle redLight;
    @FXML
    private Circle yellowLight;
    @FXML
    private Circle greenLight;
    @FXML
    private Text idLabel;

    public Intersection intersection;


    @FXML
    public void initialize() {
        idLabel.textProperty().bind(group.customTextProperty());
    }

    @FXML
    public void onClicked(MouseEvent me) {
        if(me.getButton() == MouseButton.PRIMARY) {
            if(me.getClickCount() == 2) {
                FXMLLoader fxmll = new FXMLLoader(App.class.getResource("light_settings.fxml"));
                try {
                    LightSettingController controller = new LightSettingController();
                    fxmll.setController(controller);
                    GridPane node = (GridPane)fxmll.load();
                    controller.setIntersection(intersection);
                    
                    Stage stage = new Stage();
                    stage.setTitle("Intersection " + intersection.getId());
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.initOwner(group.getScene().getWindow());
                    stage.setScene(new Scene(node));
                    stage.setResizable(false);
                    stage.showAndWait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        } else
        if(me.getButton() == MouseButton.SECONDARY) {
            intersection.disable();
        } 
    }

    public void setRedLightVisible(boolean visible) {
        Platform.runLater(() -> redLight.setOpacity(visible ? 1 : 0.2));
    }
   
    public void setYellowLightVisible(boolean visible) {
        Platform.runLater(() -> yellowLight.setOpacity(visible ? 1 : 0.2));
    }

    public void setGreenLightVisible(boolean visible) {
        Platform.runLater(() -> greenLight.setOpacity(visible ? 1 : 0.2));
    }
    
    public void setVisible(boolean visible) {
        Platform.runLater(() -> group.setVisible(visible));
    }

    public void setIDLabel(String id) {
        Platform.runLater(() -> {
            idLabel.setText(id);
        });
    }
}
