package L_11.ex03;

public class Food implements Comparable<Food>, java.io.Serializable {
    private static final long serialVersionUID = 3686629975419499958L;

    private double proteins;
    private double calories;
    private double weight;

    public Food(final double proteins, final double calories, final double weight) {
        if ((this.proteins = proteins) < 0)
            throw new IllegalArgumentException("There is no such thing as negative proteins.");
        if ((this.calories = calories) < 0)
            throw new IllegalArgumentException("Women wish there were negative calories.");
        if ((this.weight = weight) < 0)
            throw new IllegalArgumentException(
                    "Lets not jump into tough Physics (with the Casimir effect and such). Nonnegative weight only.");
    }

    public double getProteins() {
        return proteins;
    }

    public double getCalories() {
        return calories;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(final Food other) {
        return Double.compare(calories, other.calories);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(calories);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        final Food other = (Food) obj;
        return Double.doubleToLongBits(calories) == Double.doubleToLongBits(other.calories) &&
                Double.doubleToLongBits(proteins) == Double.doubleToLongBits(other.proteins) &&
                Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
    }

    @Override
    public String toString() {
        return calories + " Cal";
    }

}
