package rjj.geometry;

import rjj.util.Validate;

import java.util.List;
import java.util.Optional;

public abstract class Shape implements Comparable<Shape> {
    private Point center;

    public Shape(final Point center) {
        if (center == null)
            throw new IllegalArgumentException("Center is null.");
        this.center = center;
    }

    public static Optional<? extends Shape> biggestArea(final List<? extends Shape> figs) {
        return figs.parallelStream().max(Shape::compareTo);
    }

    public static Optional<? extends Shape> biggestPerimeter(final List<? extends Shape> figs) {
        return figs.parallelStream().max((s1, s2) -> Double.compare(s1.perimeter(), s2.perimeter()));
    }

    public static double totalArea(final List<? extends Shape> figs) {
        return figs.parallelStream().mapToDouble(Shape::area).reduce(0, Double::sum);
    }

    public static double totalArea(final List<? extends Shape> figs, final String type) throws ClassNotFoundException {
        final Class c = Class.forName(type);
        return figs.parallelStream().filter(s -> s.getClass().isInstance(c)).mapToDouble(Shape::area).reduce(0, Double::sum);
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
