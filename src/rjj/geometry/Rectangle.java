package rjj.geometry;

public class Rectangle extends Shape {
    private double height, width;

    public Rectangle(final Point2D center, final double height, final double width) {
        if (center == null) throw new IllegalArgumentException("Center is null.");
        if (height <= 0) throw new IllegalArgumentException("Height must be positive.");
        if (width <= 0) throw new IllegalArgumentException("Width must me positive.");
        this.center = center;
        this.height = height;
        this.width = width;
    }

    public Rectangle(final double x, final double y, final double height, final double width) {
        this(new Point2D(x, y), height, width);
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
    public String toString() {
        return super.toString() + ", Height: " + height + ", Width=" + width;
    }
}
