public class Cone extends ThreeDimensionalShape {
    private float radius;
    private float height;

    public Cone() {
        super();
        radius = 0;
        height = 0;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        if(isMeasurementValid(radius)) {
            this.radius = radius;
            System.out.println("The radius of the Cone's base has been set to " + radius);
        } else {
            throw new IllegalArgumentException("Invalid radius. Please enter a positive value.");
        }
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        if(isMeasurementValid(height)) {
            this.height = height;
            System.out.println("The hight of the Cone have been set to " + height);
        } else {
            throw new IllegalArgumentException("Invalid height. Please enter a positive value.");
        }
    }

    @Override
    public float calculateVolume() {
        return (float) (1.0 / 3.0 * Math.PI * Math.pow(radius, 2) * height);
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
