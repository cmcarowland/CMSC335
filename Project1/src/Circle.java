public class Circle extends TwoDimensionalShape {
    private float radius;

    public Circle() {
        super();
        this.radius = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Radius: %.2f\n");
        sb.append("    -Area  : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), radius, calculateArea());
    }

    public float calculateArea() {
        return (float)(Math.PI * Math.pow(radius, 2));
    }

    public float getRadius() {
        return radius;
    }
    
    public void setRadius(float r) {
        if(isMeasurementValid(r)) {
            radius = r;
        } else {
            throw new IllegalArgumentException("Invalid radius");
        }
    }
}
