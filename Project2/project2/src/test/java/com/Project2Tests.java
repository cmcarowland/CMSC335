package com;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class contains unit tests for the Java OO Shape Tool application.
 *          It includes methods to test the creation and validation of various shapes.
 * FILE: Project1Tests.java
 */

import com.shapes.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class Project2Tests {

    @Test
    public void IsShapeObject() {
        TwoDimensionalShape shape = new Circle();
        assertTrue(shape instanceof Object);
    }

    @Test
    public void Is2DShapeAShape() {
        TwoDimensionalShape shape = new Circle();
        assertEquals(2, shape.getNumberOfDimensions());
        assertTrue(shape instanceof Shape);
    }

    @Test
    public void IsCircle2DShape() {
        Circle shape = new Circle();
        assertTrue(shape instanceof TwoDimensionalShape);
    }

    @Test
    public void IsSquare2DShape() {
        Square shape = new Square();
        assertTrue(shape instanceof TwoDimensionalShape);
    }

    @Test
    public void IsTriangle2DShape() {
        Triangle shape = new Triangle();
        assertTrue(shape instanceof TwoDimensionalShape);
    }

    @Test
    public void IsRectangle2DShape() {
        Rectangle shape = new Rectangle();
        assertTrue(shape instanceof TwoDimensionalShape);
    }

    @Test
    public void Is3DShapeAShape() {
        ThreeDimensionalShape shape = new Sphere();
        assertEquals(3, shape.getNumberOfDimensions());
        assertTrue(shape instanceof Shape);
    }

    @Test
    public void IsSphere3DShape() {
        Sphere shape = new Sphere();
        assertTrue(shape instanceof ThreeDimensionalShape);
    }

    @Test
    public void IsCube3DShape() {
        Cube shape = new Cube();
        assertTrue(shape instanceof ThreeDimensionalShape);
    }

    @Test
    public void IsCone3DShape() {
        Cone shape = new Cone();
        assertTrue(shape instanceof ThreeDimensionalShape);
    }

    @Test
    public void IsCylinder3DShape() {
        Cylinder shape = new Cylinder();
        assertTrue(shape instanceof ThreeDimensionalShape);
    }

    @Test
    public void IsTorus3DShape() {
        Torus shape = new Torus();
        assertTrue(shape instanceof ThreeDimensionalShape);
    }

    @Test
    public void CreateCircle() {
        Circle shape = new Circle();
        shape.setRadius(5);
        assertEquals(5, shape.getRadius(), 0);
        shape.calculate();
        assertEquals(78.54f, shape.getArea(), 0.1f);
        assertTrue(shape.toString().contains("  -Type: Circle\n" + //
                        "    -Radius: 5.00\n" + //
                        "    -Area  : 78.54\n"));
    }

    @Test
    public void CreateCircleWithFloat() {
        Circle shape = new Circle();
        shape.setRadius(7.64f);
        shape.calculate();
        assertEquals(183.37f, shape.getArea(), 0.1f);
    }

    @Test
    public void CreateCircleInvalid() {
        Circle shape = new Circle();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setRadius(-12f));
        assertTrue(e.getMessage().contains("Invalid radius"));
    }

    @Test
    public void CreateRectangle() {
        Rectangle shape = new Rectangle();
        shape.setHeight(5);
        assertEquals(5, shape.getHeight(), 0);
        shape.setWidth(22);
        assertEquals(22, shape.getWidth(), 0);
        shape.calculate();
        assertEquals(110f, shape.getArea(), 0f);
        System.out.println(shape.toString());
        assertTrue(shape.toString().contains("  -Type: Rectangle\n" + //
                        "    -Height: 5.00\n" + //
                        "    -Width : 22.00\n" + //
                        "    -Area  : 110.00\n"));
    }

    @Test
    public void CreateRectangleWithFloat() {
        Rectangle shape = new Rectangle();
        shape.setHeight(7.64f);
        shape.setWidth(31.68f);
        shape.calculate();
        assertEquals(242.0352f, shape.getArea(), 0.01f);
    }

    @Test
    public void CreateRectangleInvalidHeight() {
        Rectangle shape = new Rectangle();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setHeight(-12f));
        assertTrue(e.getMessage().contains("Invalid side length"));
    }

    @Test
    public void CreateRectangleInvalidWidth() {
        Rectangle shape = new Rectangle();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setWidth(-12f));
        assertTrue(e.getMessage().contains("Invalid side length"));
    }

    @Test
    public void CreateSquare() {
        Square shape = new Square();
        shape.setSides(5);
        assertEquals(5, shape.getHeight(), 0);
        assertEquals(5, shape.getWidth(), 0);
        shape.calculate();
        assertEquals(25, shape.getArea(), 0f);
        System.out.println(shape.toString());
        assertTrue(shape.toString().contains(" -Type: Square\n" + //
        "    -Sides : 5.00\n" + //
        "    -Area  : 25.00"));
    }

    @Test
    public void CreateSquareWithFloat() {
        Square shape = new Square();
        shape.setSides(7.64f);
        shape.calculate();
        assertEquals(58.3696f, shape.getArea(), 0.01f);
    }

    @Test
    public void CreateSquareInvalid() {
        Square shape = new Square();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setHeight(-12f));
        assertTrue(e.getMessage().contains("Invalid side length"));
    }

    @Test
    public void CreateSquareInvalidWidth() {
        Square shape = new Square();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setWidth(-12f));
        assertTrue(e.getMessage().contains("Invalid side length"));
    }
   
    @Test
    public void CreateSquareInvalidSides() {
        Square shape = new Square();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setSides(-12f));
        assertTrue(e.getMessage().contains("Invalid side length"));
    }

    @Test
    public void CreateTriangle() {
        Triangle shape = new Triangle();
        shape.setBase(8);
        assertEquals(8, shape.getBase(), 0);
        shape.setHeight(13);
        assertEquals(13, shape.getHeight(), 0);
        shape.calculate();
        assertEquals(52, shape.getArea(), 0f);
        assertTrue(shape.toString().contains("  -Type: Triangle\n" + //
                        "    -Base  : 8.00\n" + //
                        "    -Height: 13.00\n" + //
                        "    -Area  : 52.00\n"));
    }

    @Test
    public void CreateTriangleWithFloat() {
        Triangle shape = new Triangle();
        shape.setBase(6.26f);
        shape.setHeight(9.4f);
        shape.calculate();
        assertEquals(29.42f, shape.getArea(), 0.01f);
    }

    @Test
    public void CreateTriangleInvalid() {
        Triangle shape = new Triangle();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setBase(-1f));
        assertTrue(e.getMessage().contains("Invalid base length"));
        e = assertThrows(IllegalArgumentException.class, () -> shape.setHeight(-1f));
        assertTrue(e.getMessage().contains("Invalid height length"));
    }

    @Test
    public void CreateSphere() {
        Sphere shape = new Sphere();
        shape.setRadius(12);
        assertEquals(12, shape.getRadius(), 0.1f);
        shape.calculate();
        assertEquals(7238.23, shape.getVolume(), 0.1f);
        System.out.println(shape.toString());
        assertTrue(shape.toString().contains("  -Type: Sphere\n" + //
                        "    -Radius : 12.00\n" + //
                        "    -Volume : 7238.23\n"));
    }

    @Test
    public void CreateSphereWithFloat() {
        Sphere shape = new Sphere();
        shape.setRadius(12.27f);
        shape.calculate();
        assertEquals(7737.89f, shape.getVolume(), 0.01f);
    }

    @Test
    public void CreateSphereInvalid() {
        Sphere shape = new Sphere();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setRadius(-1f));
        assertTrue(e.getMessage().contains("Invalid radius"));
    }

    @Test
    public void CreateCube() {
        Cube shape = new Cube();
        shape.setSides(27);
        assertEquals(27f, shape.getSide(), 0.1f);
        shape.calculate();
        assertEquals(19683, shape.getVolume(), 0f);
        System.out.println(shape.toString());
        assertTrue(shape.toString().contains("  -Type: Cube\n" + //
                        "    -Side   : 27.00\n" + //
                        "    -Volume : 19683.00\n"));
    }

    @Test
    public void CreateCubeWithFloat() {
        Cube shape = new Cube();
        shape.setSides(15.7f);
        shape.calculate();
        assertEquals(3869.89f, shape.getVolume(), 0.01f);
    }

    @Test
    public void CreateCubeInvalid() {
        Cube shape = new Cube();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setSides(-1f));
        assertTrue(e.getMessage().contains("Invalid side"));
    }

    @Test
    public void CreateCubeInvalidHeight() {
        Cube shape = new Cube();
        Exception e = assertThrows(UnsupportedOperationException.class, () -> shape.setHeight(1f));
        assertTrue(e.getMessage().contains("Unimplemented method 'setHeight'"));
    }
   
    @Test
    public void CreateCone() {
        Cone shape = new Cone();
        shape.setRadius(62);
        shape.setHeight(7);
        shape.calculate();
        assertEquals(28177.99, shape.getVolume(), 0.1f);
        assertTrue(shape.toString().contains("  -Type: Cone\n" + //
                        "    -Radius : 62.00\n" + //
                        "    -Height : 7.00\n" + //
                        "    -Volume : 28177.99\n"));
    }

    @Test
    public void CreateConeWithFloat() {
        Cone shape = new Cone();
        shape.setRadius(12.56f);
        shape.setHeight(9.7f);
        shape.calculate();
        assertEquals(1602.43f, shape.getVolume(), 0.01f);
    }

    @Test
    public void CreateConeInvalid() {
        Cone shape = new Cone();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setRadius(-1f));
        assertTrue(e.getMessage().contains("Radius must be greater than 0"));
        e = assertThrows(IllegalArgumentException.class, () -> shape.setHeight(-1f));
        assertTrue(e.getMessage().contains("Height must be greater than 0"));
    }
    @Test
    public void CreateCylinder() {
        Cylinder shape = new Cylinder();
        shape.setRadius(4);
        assertEquals(4f, shape.getRadius(), 0.1f);
        shape.setHeight(3);
        assertEquals(3f, shape.getHeight(), 0.1f);
        shape.calculate();
        assertEquals(150.8, shape.getVolume(), 0.1f);
        assertTrue(shape.toString().contains("  -Type: Cylinder\n" + //
                        "    -Radius : 4.00\n" + //
                        "    -Height : 3.00\n" + //
                        "    -Volume : 150.80\n"));
    }

    @Test
    public void CreateCylinderWithFloat() {
        Cylinder shape = new Cylinder();
        shape.setRadius(11.6f);
        shape.setHeight(7.3f);
        shape.calculate();
        assertEquals(3085.95f, shape.getVolume(), 0.01f);
    }

    @Test
    public void CreateCylinderInvalid() {
        Cylinder shape = new Cylinder();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setRadius(-1f));
        assertTrue(e.getMessage().contains("Radius must be greater than 0"));
        e = assertThrows(IllegalArgumentException.class, () -> shape.setHeight(-1f));
        assertTrue(e.getMessage().contains("Height must be greater than 0"));
    }

    @Test
    public void CreateTorus() {
        Torus shape = new Torus();
        shape.setMajorRadius(4);
        assertEquals(4f, shape.getMajorRadius(), 0.1f);
        shape.setMinorRadius(3);
        assertEquals(3f, shape.getMinorRadius(), 0.1f);
        shape.calculate();
        assertEquals(710.61, shape.getVolume(), 0.1f);
        assertTrue(shape.toString().contains("  -Type: Torus\n" + //
                        "    -Major Radius : 4.00\n" + //
                        "    -Minor Radius : 3.00\n" + //
                        "    -Volume       : 710.61\n"));
    }

    @Test
    public void CreateTorusWithFloat() {
        Torus shape = new Torus();
        shape.setMajorRadius(11.6f);
        shape.setMinorRadius(7.3f);
        shape.calculate();
        assertEquals(12202.07f, shape.getVolume(), 0.01f);
    }

    @Test
    public void CreateTorusInvalid() {
        Torus shape = new Torus();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setMajorRadius(-1f));
        assertTrue(e.getMessage().contains("Major Radius must be greater than 0"));
        e = assertThrows(IllegalArgumentException.class, () -> shape.setMinorRadius(-1f));
        assertTrue(e.getMessage().contains("Minor Radius must be greater than 0"));
    }

    @Test
    public void CreateTorusInvalidMinorLess() {
        Torus shape = new Torus();
        shape.setMajorRadius(4.6f);
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setMinorRadius(5.3f));
        assertTrue(e.getMessage().contains("Minor Radius must be less than Major Radius"));
    }
}