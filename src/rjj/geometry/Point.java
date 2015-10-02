package rjj.geometry;

public class Point {
    private double[] coordinates;

    public Point(final double x, final double... others) {
        coordinates = new double[others.length + 1];
        coordinates[0] = x;
        System.arraycopy(others, 0, coordinates, 1, others.length);
    }

    public double getX() {
        return get(0);
    }

    public double getY() {
        return get(1);
    }

    public double getZ() {
        return get(2);
    }

    public double get(final int i) {
        if (coordinates.length <= i)
            throw new IllegalArgumentException("Point is in " + coordinates.length + " dimensions. Coordinate \"" + i + "\" is thus invalid.");
        return coordinates[i];
    }

    public int length() {
        return coordinates.length;
    }

    @Override
    public String toString() {
        String s = "(";
        for (final double coordinate : coordinates)
            s += coordinate + ", ";
        return s.substring(0, s.length() - 2) + ")";
    }

    public double distanceTo(final Point p) {
        if (p == null)
            throw new IllegalArgumentException("Given point is null.");
        if (p.length() != length())
            throw new IllegalArgumentException("Points have different dimensions.");
        double sum = 0;
        for (int i = 0, size = coordinates.length; i < size; i++)
            sum += Math.pow(p.get(i) - get(i), 2);
        return Math.sqrt(sum);
    }
}
