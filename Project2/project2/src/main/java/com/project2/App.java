package com.project2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private Stage stage;
    private static Scene scene;
    private static MyPane mp;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));

        scene = new Scene(root, 500, 550);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setMinWidth(500);
        stage.setMinHeight(550);
        this.stage = stage;
        stage.setTitle("Raymond Rowland Project 2");
        stage.setScene(scene);
        stage.show();
    }

    Button createButton(String title, double x, double y, MouseClickedInterface mci) {
        var b1 = new Button(title);
        b1.setLayoutX(x);
        b1.setLayoutY(y);
        b1.setOnMouseClicked(e -> mci.execute(e));
        return b1;
    }

    TextField createTextField(double x, double y, double width) {
        var tf = new TextField();
        tf.setLayoutX(x);
        tf.setLayoutY(y);
        tf.setMinWidth(width);
        tf.setMaxWidth(width);
        return tf;
    }

    Label createLabel(String title, double x, double y) {
        var label = new Label(title);
        label.setTextFill(Color.WHITE);
        label.setLayoutX(x);
        label.setLayoutY(y);
        return label;
    }

    void Clicked(MouseEvent me) {
        System.out.println(me);

        Pane p = new Pane();
        BackgroundFill bgf = new BackgroundFill(Color.valueOf("#141414"), null, p.getInsets());
        Background bg = new Background(bgf);
        p.setBackground(bg);

        Scene scene = new Scene(p, 200, 200);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(((Button)me.getSource()).textProperty().getValue());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)me.getSource()).getScene().getWindow());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}