package L_06.lect6;

public class VegetarianFood extends Food {
    private static final long serialVersionUID = -660914895185683738L;

    private String name;

    public VegetarianFood(final double proteins, final double calories, final double weight, final String name) {
        super(proteins, calories, weight);
        if ((this.name = name) == null)
            throw new NullPointerException("Name for this food can't be null.");
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        VegetarianFood other = (VegetarianFood) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Name: " + name + " " + super.toString();
    }

}
