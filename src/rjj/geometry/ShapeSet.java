package rjj.geometry;

import java.util.LinkedHashSet;

public class ShapeSet extends LinkedHashSet<Shape> {
    private final double maxArea;
    private double currentArea;

    public ShapeSet(final double maxArea) {
        if (maxArea <= 0)
            throw new IllegalArgumentException("Area as to be a positive value.");
        this.maxArea = maxArea;
    }

    public boolean addShape(final Shape s) {
        if (currentArea + s.area() > maxArea)
            return false;
        if (!add(s))
            return false;
        currentArea += s.area();
        return true;
    }

    public boolean removeShape(final Shape s) {
        if (!remove(s))
            return false;
        currentArea -= s.area();
        return true;
    }

    public double totalArea() {
        return currentArea;
    }

    public Shape[] getShapes() {
        return toArray(new Shape[size()]);
    }

    public Point[] getCenters() {
        Point[] p = new Point[size()];
        int i = 0;
        for (Shape s : this)
            p[i++] = s.getCenter();
        return p;
    }
}
