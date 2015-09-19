package rjj.geometry;

public abstract class Shape {
    protected Point2D center;

    abstract public double area();

    abstract public double perimeter();

    public Point2D getCenter() {
        return center;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "| Center: " + center;
    }
}
