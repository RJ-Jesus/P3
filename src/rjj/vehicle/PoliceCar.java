package rjj.vehicle;

public class PoliceCar extends Car implements PoliceVehicle {
    private Type type;
    private String ID;

    public PoliceCar(final String baseColor, final int year, final String plate, final int engineDisplacement, final int maxVelocity, final int power,
                     final int consumption, final String fuel, final String ID, final Type type) {
        super(baseColor, year, plate, engineDisplacement, maxVelocity, power, consumption, fuel);
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
