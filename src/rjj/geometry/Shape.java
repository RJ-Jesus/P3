package rjj.geometry;

public abstract class Shape {
    private Point center;

    public Shape(final Point center) {
        if (center == null)
            throw new IllegalArgumentException("Center is null.");
        this.center = center;
    }

    abstract public double area();

    abstract public double perimeter();

    public Point getCenter() {
        return center;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " Center: " + center;
    }
}
