package tests;

import main.*;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import main.TwoDimensionalShape;

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
}