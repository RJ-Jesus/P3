package rjj.vehicle;

public class GoodsVehicle extends MotorVehicle {
    private String merchandise;

    public GoodsVehicle(final String baseColor, final int year, final String plate, final int engineDisplacement, final int maxVelocity, final int power,
                        final int consumption, final String fuel, final String merchandise) {
        super(baseColor, 4, year, plate, engineDisplacement, maxVelocity, power, consumption, fuel);
        this.merchandise = merchandise;
    }

    public String getMerchandise() {
        return merchandise;
    }

    @Override
    public String toString() {
        return super.toString() + ", Merchandise: " + merchandise;
    }
}
