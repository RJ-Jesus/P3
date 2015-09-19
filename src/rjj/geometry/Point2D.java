package rjj.geometry;

public class Point2D {
    private double x, y;

    public Point2D(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%f, %f)", x, y);
    }

    public double distanceTo(Point2D p) {
        if (p == null) throw new IllegalArgumentException("Given point is null.");
        return Math.sqrt(Math.pow(p.getY() - getY(), 2) + Math.pow(p.getX() - getX(), 2));
    }
}
