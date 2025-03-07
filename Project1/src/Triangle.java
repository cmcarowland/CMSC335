public class Triangle extends TwoDimensionalShape {
    private float base;
    private float height;

    public Triangle() {
        super();
        this.base = 0;
        this.height = 0;
    }

    @Override
    public float calculateArea() {
        return (base * height) / 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Base  : %.2f\n");
        sb.append("    -Height: %.2f\n");
        sb.append("    -Area  : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), base, height, calculateArea());
    }

    public void setBase(float base) {
        if (isMeasurementValid(base)) {
            this.base = base;
            System.out.println("The base of the Triangle has been set to " + base);
        } else {
            throw new IllegalArgumentException("Invalid base length");
        }
    }

    public void setHeight(float height) {
        if (isMeasurementValid(height)) {
            this.height = height;
            System.out.println("The height of the Triangle has been set to " + height);
        } else {
            throw new IllegalArgumentException("Invalid height length");
        }
    }
}
