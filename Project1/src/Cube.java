public class Cube extends ThreeDimensionalShape {
    private float side;

    public Cube() {
        super();
        side = 0;
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        if(isMeasurementValid(side)) {
            this.side = side;
        } else {
            throw new IllegalArgumentException("Invalid side");
        }
    }

    @Override
    public float calculateVolume() {
        return (float) Math.pow(side, 3);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(shapeData);
        sb.append("    -Side   : %.2f\n");
        sb.append("    -Volume : %.2f\n");
        return String.format(sb.toString(), this.getClass().getSimpleName(), side, calculateVolume());
    }
    
}
