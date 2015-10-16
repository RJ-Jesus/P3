package rjj.geometry;

import rjj.util.Validate;

public abstract class Shape implements Comparable<Shape> {
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shape shape = (Shape) o;

        return !(center != null ? !center.equals(shape.center) : shape.center != null);

    }

    @Override
    public int hashCode() {
        return center != null ? center.hashCode() : 0;
    }

    @Override
    public int compareTo(final Shape s) {
        Validate.notNull(s, "Shape to compare to is null.");
        return Double.compare(this.area(), s.area());
    }
}
