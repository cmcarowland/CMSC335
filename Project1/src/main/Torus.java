package main;

public class Torus extends ThreeDimensionalShape {
    private float majorRadius;
    private float minorRadius;

    public Torus() {
        super();
    }

    public float getMajorRadius() {
        return majorRadius;
    }

    public void setMajorRadius(float majorRadius) {
        if (isMeasurementValid(majorRadius)) {
            this.majorRadius = majorRadius;
            System.out.println("Major Radius of the Torus have been set to " + majorRadius);
        } else {
            throw new IllegalArgumentException("Major Radius must be greater than 0");
        }
    }

    public void setMinorRadius(float minorRadius) {
        if (isMeasurementValid(minorRadius)) {
            this.minorRadius = minorRadius;
            System.out.println("Minor Radius of the Torus have been set to " + minorRadius);
        } else {
            throw new IllegalArgumentException("Minor Radius must be greater than 0");
        }
    }

    @Override
    public float calculateVolume() {
        return (float) (2 * Math.PI * Math.PI * majorRadius * Math.pow(minorRadius, 2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Major Radius : %.2f\n");
        sb.append("    -Minor Radius : %.2f\n");
        sb.append("    -Volume       : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), majorRadius, minorRadius, calculateVolume());
    }
    
}
