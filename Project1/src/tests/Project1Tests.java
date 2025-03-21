package tests;

/**
 * DATE: March 14, 2025
 * AUTHOR: Raymond Rowland
 * PURPOSE: This class contains unit tests for the Java OO Shape Tool application.
 *          It includes methods to test the creation and validation of various shapes.
 * FILE: Project1Tests.java
 */

import main.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class Project1Tests {

    @Test
    public void IsShapeObject() {
        TwoDimensionalShape shape = new Circle();
        assertTrue(shape instanceof Object);
    }

    @Test
    public void Is2DShapeAShape() {
        TwoDimensionalShape shape = new Circle();
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
        shape.calculate();
        assertEquals(78.54f, shape.getArea(), 0.1f);
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
        shape.setWidth(22);
        shape.calculate();
        assertEquals(110f, shape.getArea(), 0f);
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
    public void CreateRectangleInvalid() {
        Rectangle shape = new Rectangle();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setHeight(-12f));
        assertTrue(e.getMessage().contains("Invalid side length"));
    }

    @Test
    public void CreateSquare() {
        Square shape = new Square();
        shape.setHeight(5);
        shape.calculate();
        assertEquals(25, shape.getArea(), 0f);
    }

    @Test
    public void CreateSquareWithFloat() {
        Square shape = new Square();
        shape.setHeight(7.64f);
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
    public void CreateTriangle() {
        Triangle shape = new Triangle();
        shape.setBase(8);
        shape.setHeight(13);
        shape.calculate();
        assertEquals(52, shape.getArea(), 0f);
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
        shape.calculate();
        assertEquals(7238.23, shape.getVolume(), 0.1f);
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
        shape.setHeight(27);
        shape.calculate();
        assertEquals(19683, shape.getVolume(), 0f);
    }

    @Test
    public void CreateCubeWithFloat() {
        Cube shape = new Cube();
        shape.setHeight(15.7f);
        shape.calculate();
        assertEquals(3869.89f, shape.getVolume(), 0.01f);
    }

    @Test
    public void CreateCubeInvalid() {
        Cube shape = new Cube();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setHeight(-1f));
        assertTrue(e.getMessage().contains("Invalid side"));
    }
   
    @Test
    public void CreateCone() {
        Cone shape = new Cone();
        shape.setRadius(62);
        shape.setHeight(7);
        shape.calculate();
        assertEquals(28177.99, shape.getVolume(), 0.1f);
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
        shape.setHeight(3);
        shape.calculate();
        assertEquals(150.8, shape.getVolume(), 0.1f);
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
        shape.setMinorRadius(3);
        shape.calculate();
        assertEquals(710.61, shape.getVolume(), 0.1f);
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