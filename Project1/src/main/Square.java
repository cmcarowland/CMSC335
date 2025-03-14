package main;

public class Square extends Rectangle {
    public void setSides(float side) {
        try {
            setHeight(side);
            setWidth(side);
        } catch (IllegalArgumentException e) {
            throw e;
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
