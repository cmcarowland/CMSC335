package main;

public abstract class ThreeDimensionalShape extends Shape {
    public ThreeDimensionalShape() {
        super(3);
    }

    public abstract float calculateVolume();
}
