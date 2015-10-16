package rjj.vehicle;

public class Motorcycle extends MotorVehicle {

    public Motorcycle(final String baseColor, final int year, final String plate, final int engineDisplacement, final int maxVelocity, final int power,
                      final int consumption, final String fuel) {
        super(baseColor, 4, year, plate, engineDisplacement, maxVelocity, power, consumption, fuel);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
