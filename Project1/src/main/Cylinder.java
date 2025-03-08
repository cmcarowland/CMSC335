package main;

public class Cylinder extends ThreeDimensionalShape {
    private float radius;
    private float height;

    public Cylinder() {
        super();
    }

    public void setRadius(float radius) {
        if (isMeasurementValid(radius)) {
            this.radius = radius;
            System.out.println("Radius of the Cylinder have been set to " + radius);
        } else {
            throw new IllegalArgumentException("Radius must be greater than 0");
        }
    }

    public void setHeight(float height) {
        if (isMeasurementValid(height)) {
            this.height = height;
            System.out.println("Height of the Cylinder have been set to " + height);
        } else {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
    }

    @Override
    public float calculateVolume() {
        return (float) (Math.PI * Math.pow(radius, 2) * height);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Radius : %.2f\n");
        sb.append("    -Height : %.2f\n");
        sb.append("    -Volume : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), radius, height, calculateVolume());
    }
    
}
