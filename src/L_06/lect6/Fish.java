package L_06.lect6;

public class Fish extends Food {
    private static final long serialVersionUID = -7794452661007977734L;

    private Type type;

    public Fish(final double proteins, final double calories, final double weight, final Type type) {
        super(proteins, calories, weight);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        Fish other = (Fish) obj;
        return type == other.type;
    }

    @Override
    public String toString() {
        return type + " " + getClass().getSimpleName() + " " + super.toString();
    }

    public enum Type {
        FROZEN, FRESH
    }

}
