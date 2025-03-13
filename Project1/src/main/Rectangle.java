package main;

public class Rectangle extends TwoDimensionalShape {
    protected float height;
    protected float width;
  
    public Rectangle() {
        super();
    }

    @Override
    public float calculateArea() {
        return height * width;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Height: %.2f\n");
        sb.append("    -Width : %.2f\n");
        sb.append("    -Area  : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), width, height, calculateArea());
    }

    public void setHeight(float side) {
        if (isMeasurementValid(side)) {
            this.height = side;
            System.out.println("The height of the " + getClass().getSimpleName() + " has been set to " + height);
        } else {
            throw new IllegalArgumentException("Invalid side length");
        }
    }

    public void setWidth(float side) {
        if (isMeasurementValid(side)) {
            this.width = side;
            System.out.println("The width of the " + getClass().getSimpleName() + " has been set to " + width);
        } else {
            throw new IllegalArgumentException("Invalid side length");
        }
    }
}
