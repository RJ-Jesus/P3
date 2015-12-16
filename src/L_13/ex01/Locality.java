package L_13.ex01;

import java.util.Objects;

public class Locality extends Region {
    private TypeLocality typeLocality;

    public Locality(final String name, final int population, final TypeLocality typeLocality) {
        super(name, population);
        this.typeLocality = Objects.requireNonNull(typeLocality);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Locality locality = (Locality) o;

        return typeLocality == locality.typeLocality;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + typeLocality.hashCode();
        return result;
    }

    public TypeLocality getTypeLocality() {
        return typeLocality;
    }

    public void setTypeLocality(TypeLocality typeLocality) {
        this.typeLocality = Objects.requireNonNull(typeLocality);
    }

    @Override
    public String toString() {
        return typeLocality + ": " + super.toString();
    }

    public enum TypeLocality {
        CITY("City"),
        TOWN("Town"),
        VILLAGE("Village");

        private final String name;

        TypeLocality(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
