public class Circle extends TwoDimensionalShape {
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getRadius() {
        return radius;
    }
}
