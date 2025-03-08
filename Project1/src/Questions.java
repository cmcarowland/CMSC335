public enum Questions {
    Radius,
    Height,
    Width,
    Base,
    MajorMinorRadius;

    public int getStatusFlagValue(){
        return 1 << this.ordinal();
    } 
}
