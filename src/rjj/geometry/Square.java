package rjj.geometry;

import rjj.util.Validate;

public class Square extends Rectangle {
    public Square(final Square square) {
        this(new Point(Validate.notNull(square, "Square is null.").getCenter().getX(), square.getCenter().getY()), square.getHeight());
    }

    public Square(final double side) {
        this(new Point(0, 0), side);
    }

    public Square(final Point center, final double side) {
        super(center, side, side);
    }
}
