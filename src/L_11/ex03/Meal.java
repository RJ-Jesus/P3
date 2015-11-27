package L_11.ex03;

import java.util.LinkedList;
import java.util.List;

public class Meal implements java.io.Serializable {
    private static final long serialVersionUID = 7549595275301127580L;

    private List<Food> contents;
    private String name;
    private double calories, proteins, weight;

    public Meal(final String name) {
        if ((this.name = name) == null)
            throw new NullPointerException("Name can't be null.");
        this.contents = new LinkedList<>();
    }

    public Object[] getContents() {
        return contents.toArray();
    }

    public Food[] getContents(final Food[] arr) {
        return contents.toArray(arr);
    }

    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public double getWeight() {
        return weight;
    }

    public boolean addFood(final Food f) {
        calories += f.getCalories();
        proteins += f.getProteins();
        weight += f.getWeight();
        contents.add(f);
        return true;
    }

    public boolean removeFood(final Food f) {
        final boolean rtn = contents.remove(f);
        if (rtn) {
            calories -= f.getCalories();
            proteins -= f.getProteins();
            weight -= f.getWeight();
        }
        return rtn;
    }

    public Food removeFood(final int idx) {
        final Food rtn = contents.remove(idx);
        if (rtn != null) {
            calories -= rtn.getCalories();
            proteins -= rtn.getProteins();
            weight -= rtn.getWeight();
        }
        return rtn;
    }

    @Override
    public String toString() {
        return name + ", No. Ingredients: " + contents.size() + ". Total Calories: " + calories;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(calories);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((contents == null) ? 0 : contents.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        temp = Double.doubleToLongBits(proteins);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Meal other = (Meal) obj;
        if (Double.doubleToLongBits(calories) != Double.doubleToLongBits(other.calories))
            return false;
        if (contents == null) {
            if (other.contents != null)
                return false;
        } else if (!contents.equals(other.contents))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return Double.doubleToLongBits(proteins) == Double.doubleToLongBits(other.proteins) && Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
    }

}
