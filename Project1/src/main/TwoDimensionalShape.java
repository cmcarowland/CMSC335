package main;

public abstract class TwoDimensionalShape extends Shape {
    public TwoDimensionalShape() {
        super(2);
    }
    
    public abstract float calculateArea();
}
