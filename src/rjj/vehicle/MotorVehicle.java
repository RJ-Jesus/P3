package rjj.vehicle;

public class MotorVehicle extends Vehicle {
    private int consumption;
    private int engineDisplacement;
    private String fuel;
    private int maxVelocity;
    private String plate;
    private int power;

    public MotorVehicle(final String baseColor, final int nWheels, final int year, final String plate, final int engineDisplacement, final int maxVelocity,
                        final int power, final int consumption, final String fuel) {
        super(baseColor, nWheels, year);
        if (plate == null)
            throw new NullPointerException("Plate is null.");
        if (!Vehicle.checkPlate(plate))
            throw new IllegalArgumentException(plate + " is not a valid portuguese plate.");
        if (fuel == null)
            throw new NullPointerException("Fuel name is null.");
        this.plate = plate;
        this.engineDisplacement = engineDisplacement;
        this.maxVelocity = maxVelocity;
        this.power = power;
        this.consumption = consumption;
        this.fuel = fuel;
    }

    public int getConsumption() {
        return consumption;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public String getFuel() {
        return fuel;
    }

    public int getMaximumVelocity() {
        return maxVelocity;
    }

    public String getPlate() {
        return plate;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return super.toString() + ", Consumption: " + consumption + ", Engine Displacement: " + engineDisplacement + ", Fuel: "
                + fuel + ", Maximum Velocity: " + maxVelocity + ", Plate: " + plate + ", Power: " + power;
    }

}
