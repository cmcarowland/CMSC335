package tests;

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
        assertEquals(78.54f, shape.calculateArea(), 0.1f);
    }

    @Test
    public void CreateCircleWithFloat() {
        Circle shape = new Circle();
        shape.setRadius(7.64f);
        assertEquals(183.37f, shape.calculateArea(), 0.1f);
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
        assertEquals(110f, shape.calculateArea(), 0f);
    }

    @Test
    public void CreateRectangleWithFloat() {
        Rectangle shape = new Rectangle();
        shape.setHeight(7.64f);
        shape.setWidth(31.68f);
        assertEquals(242.0352f, shape.calculateArea(), 0.01f);
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
        shape.setSides(5);
        assertEquals(25, shape.calculateArea(), 0f);
    }

    @Test
    public void CreateSquareWithFloat() {
        Square shape = new Square();
        shape.setSides(7.64f);
        assertEquals(58.3696f, shape.calculateArea(), 0.01f);
    }

    @Test
    public void CreateSquareInvalid() {
        Square shape = new Square();
        Exception e = assertThrows(IllegalArgumentException.class, () -> shape.setHeight(-12f));
        assertTrue(e.getMessage().contains("Invalid side length"));
    }

    

}