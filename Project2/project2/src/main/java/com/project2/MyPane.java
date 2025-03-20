package com.project2;
/*
* Raymond Rowland
* Project 4
* 10/6/24
* 
*
* The MyPane class extends Pane to create a custom drawing area for a 
* JavaFX application. It sets a dark background and handles mouse click 
* events to add vertices to the graph. When a vertex is added, it 
* visually represents it as a yellow circle with a label. The class also 
* provides a method to draw edges between vertices, represented as white 
* lines connecting the corresponding vertex positions in the pane.
*/

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

// import javafx.scene.control.Label;
// import javafx.scene.shape.Circle;
// import javafx.scene.shape.Line;

public class MyPane extends Pane {
   public MyPane () {
       BackgroundFill bgf = new BackgroundFill(Color.valueOf("#202020"), null, getInsets());
       Background bg = new Background(bgf);
       setBackground(bg);
       setLayoutX(100);
       setPrefWidth(400);
       setPrefHeight(500);
       setOnMouseClicked(event -> reactToMouseClick(event));
   }

   private void reactToMouseClick(MouseEvent e) {
       if(e.getButton() == MouseButton.PRIMARY) {
          
       }
   }   
}