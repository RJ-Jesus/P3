package L_06.lect6;

public class Meat extends Food {
    private static final long serialVersionUID = -3595372839740544367L;

    private Variety variety;

    public Meat(@SuppressWarnings("LocalCanBeFinal") final double proteins, @SuppressWarnings("LocalCanBeFinal") final double calories, @SuppressWarnings("LocalCanBeFinal") final double weight, @SuppressWarnings("LocalCanBeFinal") final Variety variety) {
        super(proteins, calories, weight);
        this.variety = variety;
    }

    public Variety getVariety() {
        return variety;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((variety == null) ? 0 : variety.hashCode());
        return result;
    }

    @Override
    public boolean equals(@SuppressWarnings("LocalCanBeFinal") final Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Meat other = (Meat) obj;
        return variety == other.variety;
    }

    @Override
    public String toString() {
        return variety + " " + getClass().getSimpleName() + " " + super.toString();
    }

    public enum Variety {
        COW, PIG, TURKEY, CHICKEN, OTHER
    }

}
