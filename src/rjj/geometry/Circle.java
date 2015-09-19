package rjj.geometry;

public class Circle extends Shape {
    private double radius;

    public Circle(final Point2D center, final double radius) {
        if (center == null)
            throw new IllegalArgumentException("Center is null.");
        if (radius <= 0)
            throw new IllegalArgumentException("Radius must be a positive value.");
        this.center = center;
        this.radius = radius;
    }

    public Circle(final double x, final double y, final double radius) {
        this(new Point2D(x, y), radius);
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return super.toString() + ", Radius: " + radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(getRadius());
        return (int) (temp ^ (temp >>> 32));
    }

    public double getRadius() {
        return radius;
    }

    public boolean intercept(Circle c) {
        return c != null && getCenter().distanceTo(c.getCenter()) <= getRadius() + c.getRadius();
    }
}
