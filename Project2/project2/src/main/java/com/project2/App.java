package com.project2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static MyPane mp;

    @Override
    public void start(Stage stage) throws IOException {
        Pane p = new Pane();
        BackgroundFill bgf = new BackgroundFill(Color.valueOf("#141414"), null, p.getInsets());
        Background bg = new Background(bgf);
        p.setBackground(bg);
        
        mp = new MyPane();
        p.getChildren().add(mp);
        p.getChildren().add(createLabel("2D Shapes", 20, 10));
        p.getChildren().add(createButton("Circle", 20, 30, this::Clicked));
        p.getChildren().add(createButton("Square", 20, 70, this::Clicked));
        p.getChildren().add(createButton("Triangle", 20, 110, this::Clicked));
        p.getChildren().add(createButton("Rectangle", 20, 150, this::Clicked));

        p.getChildren().add(createLabel("3D Shapes", 20, 240));
        p.getChildren().add(createButton("Sphere", 20, 260, this::Clicked));
        p.getChildren().add(createButton("Cube", 20, 300, this::Clicked));
        p.getChildren().add(createButton("Cone", 20, 340, this::Clicked));
        p.getChildren().add(createButton("Cylinder", 20, 380, this::Clicked));
        p.getChildren().add(createButton("Torus", 20, 420, this::Clicked));

        scene = new Scene(p, 500, 500);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
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
    }

    public static void main(String[] args) {
        launch();
    }

}