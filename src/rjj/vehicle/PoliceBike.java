package rjj.vehicle;

public class PoliceBike extends Bicycle implements PoliceVehicle {
    private Type type;
    private String ID;

    public PoliceBike(final String baseColor, final int year, final String ID, final Type type) {
        super(baseColor, year);
        if (ID == null)
            throw new NullPointerException();
        this.ID = ID;
        this.type = type;
    }

    @Override
    public String getType() {
        return type.toString();
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return super.toString() + ", ID: " + ID + ", Type: " + type;
    }

}
