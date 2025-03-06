public abstract class Shape {
    private int numberOfDimensions;
    protected String shapeData = "  -Type: %s\n";

    public Shape(int dimensions) {
        numberOfDimensions = dimensions;
    }

    public int getNumberOfDimensions() {
        return numberOfDimensions;
    }

    public boolean isMeasurementValid(float measurement) {
        return measurement > 0;
    }
}