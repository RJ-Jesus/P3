package L_03.lect3;

public class GoodsVehicle extends MotorVehicle {
    private String merchandise;

    public GoodsVehicle(final int displacement, final int enginePower, final int capacity, final int weight, final String merchandise) {
        super(displacement, enginePower, capacity, weight);
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
