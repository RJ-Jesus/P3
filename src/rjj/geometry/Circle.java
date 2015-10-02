package rjj.geometry;

import rjj.util.Validate;

public class Circle extends Shape {
    private double radius;

    public Circle(final Circle other) {
        this(new Point(Validate.notNull(other, "Circle is null.").getCenter().getX(), other.getCenter().getY()), other.getRadius());
    }

    public Circle(final double radius) {
        this(new Point(0, 0), radius);
    }

    public Circle(final Point center, final double radius) {
        super(center);
        if (radius <= 0)
            throw new IllegalArgumentException("Radius must be a positive value.");
        this.radius = radius;
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
    public boolean equals(final Object o) {
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

    public boolean intercept(final Circle c) {
        return c != null && getCenter().distanceTo(c.getCenter()) <= getRadius() + c.getRadius();
    }
}
