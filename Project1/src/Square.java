public class Square extends Rectangle {
    public void setSides(float side) {
        if (isMeasurementValid(side)) {
            this.height = side;
            this.width = side;
        } else {
            throw new IllegalArgumentException("Invalid side length");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Sides : %.2f\n");
        sb.append("    -Area  : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), width, calculateArea());
    }
}
