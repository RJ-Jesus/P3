package L_11.ex03;

public class DietMeal extends Meal {

    private static final long serialVersionUID = -6456818868292732765L;

    private double maxCalories;

    public DietMeal(final String name, final double maxCalories) {
        super(name);
        if ((this.maxCalories = maxCalories) < 0)
            throw new IllegalArgumentException("Women wish there were negative calories.");
    }

    @Override
    public boolean addFood(final Food f) {
        return f.getCalories() + super.getCalories() <= maxCalories && super.addFood(f);
    }

    public double getMaximumCalories() {
        return maxCalories;
    }

    @Override
    public String toString() {
        return super.toString() + ", Maximum: " + maxCalories;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        final long temp;
        temp = Double.doubleToLongBits(maxCalories);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        final DietMeal other = (DietMeal) obj;
        return Double.doubleToLongBits(maxCalories) == Double.doubleToLongBits(other.maxCalories);
    }
}
