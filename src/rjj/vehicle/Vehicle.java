package rjj.vehicle;

import java.util.regex.Pattern;

public class Vehicle implements Comparable<Vehicle> {
    private String baseColor;
    private int nWheels;
    private int year;

    public Vehicle(final String baseColor, final int nWheels, final int year) {
        if (baseColor == null)
            throw new NullPointerException();
        if (year < 0)
            throw new IllegalArgumentException("Year can't take negative values.");
        this.baseColor = baseColor;
        this.nWheels = nWheels;
        this.year = year;
    }

    protected static boolean checkPlate(final String plate) {
        return Pattern.matches("([A-Z]{2}-[0-9]{2}-[0-9]{2})|([0-9]{2}-[A-Z]{2}-[0-9]{2})|([0-9]{2}-[0-9]{2}-[A-Z]{2})", plate);
    }

    public String getBaseColor() {
        return baseColor;
    }

    public int getNumberWheels() {
        return nWheels;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(final Vehicle o) {
        return year - o.year;
    }

    @Override
    public String toString() {
        return "Base Color: " + baseColor + ", # Wheels: " + nWheels + ", Year: " + year;
    }

}
