public abstract class Shape {
    private int numberOfDimensions;

    public Shape(int dimensions) {
        numberOfDimensions = dimensions;
    }

    public int getNumberOfDimensions() {
        return numberOfDimensions;
    }
}