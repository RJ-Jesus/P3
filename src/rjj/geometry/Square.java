package rjj.geometry;

public class Square extends Rectangle {
    public Square(Point2D center, final double side) {
        super(center, side, side);
    }

    public Square(final double x, final double y, double side) {
        this(new Point2D(x, y), side);
    }
}
