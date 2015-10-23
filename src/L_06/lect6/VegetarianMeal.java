package L_06.lect6;

public class VegetarianMeal extends Meal {
    private static final long serialVersionUID = 6328014886427375921L;

    public VegetarianMeal(final String name) {
        super(name);
    }

    @Override
    public boolean addFood(final Food f) {
        return !(f instanceof VegetarianFood) && super.addFood(f);
    }

    @Override
    public boolean removeFood(final Food f) {
        if (f instanceof VegetarianFood)
            throw new IllegalArgumentException(f + " is not a vegetarian food.");
        return super.removeFood(f);
    }

}
