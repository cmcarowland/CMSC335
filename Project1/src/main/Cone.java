package main;

public class Cone extends Cylinder {

    public Cone() {
        super();
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
