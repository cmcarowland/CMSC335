package com.project2;
/**
 * DATE: April 1, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class represents a custom JavaFX Pane that allows users to dynamically 
 *          create and display various shapes (e.g., circles, rectangles, squares, triangles) 
 *          and 3D shape representations (e.g., spheres, cubes, cones, cylinders, toruses) 
 *          on mouse clicks. The shapes are determined by the current selection in the application.
 * FILE: MyPane.java
 */


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;

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
            if(App.shapeType.equals("circle")) {
                Circle circle = new Circle(e.getX(), e.getY(), CircleController.getRadius(), Color.YELLOW);
                getChildren().add(circle);
            }
            if(App.shapeType.equals("rectangle")) {
                Rectangle rect = new Rectangle(RectangleController.getWidth(), RectangleController.getHeight(), Color.YELLOW);
                rect.setX(e.getX() - RectangleController.getWidth() / 2);
                rect.setY(e.getY() - RectangleController.getHeight() / 2);
                getChildren().add(rect);
            }
            if(App.shapeType.equals("square")) {
                Rectangle rect = new Rectangle(SquareController.getSides(), SquareController.getSides(), Color.YELLOW);
                rect.setX(e.getX() - SquareController.getSides() / 2);
                rect.setY(e.getY() - SquareController.getSides() / 2);
                getChildren().add(rect);
            }
            if(App.shapeType.equals("triangle")) {
                System.out.println("Triangle");
                Polygon triangle = new Polygon();
                triangle.setFill(Color.YELLOW);
                double side = TriangleController.getBase() / 2;
                double height = TriangleController.getHeight() / 2;
                triangle.getPoints().addAll(
                    e.getX(), e.getY()-height,
                    e.getX()-side, e.getY()+height,
                    e.getX()+side, e.getY()+height
                );
                
                getChildren().add(triangle);
            }
            if(App.shapeType.equals("sphere")) {
                Image image = new Image(getClass().getResource("Shapes/Sphere1.png").toExternalForm());
                createImageResizeAndInsert(image, SphereController.getRadius(), e);
            }
            if(App.shapeType.equals("cube")) {
                Image image = new Image(getClass().getResource("Shapes/Cube.png").toExternalForm());
                createImageResizeAndInsert(image, CubeController.getSide(), e);
            }
            if(App.shapeType.equals("cone")) {
                Image image = new Image(getClass().getResource("Shapes/Cone_" + ConeController.getDimensions() + ".png").toExternalForm());
                createImageResizeAndInsert(image, 50, e);
            }
            if(App.shapeType.equals("cylinder")) {
                Image image = new Image(getClass().getResource("Shapes/Cylinder_" + CylinderController.getDimensions() + ".png").toExternalForm());
                createImageResizeAndInsert(image, 50, e);
            }
            if(App.shapeType.equals("torus")) {
                System.out.println("Shapes/Torus_" + TorusController.getDimensions() + ".png");
                Image image = new Image(getClass().getResource("Shapes/Torus_" + TorusController.getDimensions() + ".png").toExternalForm());
                createImageResizeAndInsert(image, 50, e);
            }
        }
   }

   private void createImageResizeAndInsert(Image image, double size, MouseEvent e) {
        var iv = new ImageView(image);
        iv.setX(e.getX()-size/2);
        iv.setY(e.getY()-size/2);
        iv.setFitHeight(size);
        iv.setFitWidth(size);
        getChildren().add(iv);
   }
   
   public void clear() {
       getChildren().clear();
   }
}