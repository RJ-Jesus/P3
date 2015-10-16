package rjj.vehicle;

public class PassengersVehicle extends MotorVehicle {
    public PassengersVehicle(final String baseColor, final int year, final String plate, final int engineDisplacement, final int maxVelocity, final int power,
                             final int consumption, final String fuel) {
        super(baseColor, 4, year, plate, engineDisplacement, maxVelocity, power, consumption, fuel);
    }
}
