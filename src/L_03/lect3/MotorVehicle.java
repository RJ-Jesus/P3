package L_03.lect3;

public class MotorVehicle {
    private int displacement;
    private int enginePower;
    private int capacity;
    private int weight;

    public MotorVehicle(final int displacement, final int enginePower, final int capacity, final int weight) {
        if (displacement <= 0)
            throw new IllegalArgumentException("Displacement has to be a positive value.");
        if (enginePower <= 0)
            throw new IllegalArgumentException("Engine power has to be a positive value.");
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity has to be a positive value.");
        if (weight <= 0)
            throw new IllegalArgumentException("Weight has to be a positive value.");
        this.displacement = displacement;
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getDisplacement() {
        return displacement;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Displacement: " + displacement + ", Engine power: " + enginePower + ", Capacity: " + capacity
                + ", Weight: " + weight;
    }
}
