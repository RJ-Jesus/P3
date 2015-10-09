package rjj.geometry;

import rjj.util.Validate;

public class Rectangle extends Shape {
    private double height, width;

    public Rectangle(final Rectangle rectangle) {
        this(new Point(Validate.notNull(rectangle, "Rectangle is null.").getCenter().getX(), rectangle.getCenter().getY()), rectangle.getHeight(), rectangle.getWidth());
    }

    public Rectangle(final double height, final double width) {
        this(new Point(0, 0), height, width);
    }

    public Rectangle(final Point center, final double height, final double width) {
        super(center);
        if (height <= 0)
            throw new IllegalArgumentException("Height must be positive.");
        if (width <= 0)
            throw new IllegalArgumentException("Width must me positive.");
        this.height = height;
        this.width = width;
    }

    @Override
    public double area() {
        return height * width;
    }

    @Override
    public double perimeter() {
        return 2 * height + 2 * width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Rectangle rectangle = (Rectangle) o;

        return Double.compare(rectangle.height, height) == 0 && Double.compare(rectangle.width, width) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", Height: " + height + ", Width: " + width;
    }
}
