public class Sphere extends ThreeDimensionalShape {
    private float radius;

    public Sphere() {
        super();
        radius = 0;
    }

    public void setRadius(float radius) {
        if(isMeasurementValid(radius)) {
            this.radius = radius;
            System.out.println("The radius of the Sphere has been set to " + radius);
        } else {
            throw new IllegalArgumentException("Invalid radius");
        }
    }

    @Override
    public float calculateVolume() {
        return (float) (4.0 / 3.0 * Math.PI * Math.pow(radius, 3));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Radius : %.2f\n");
        sb.append("    -Volume : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), radius, calculateVolume());
    }
    
}
