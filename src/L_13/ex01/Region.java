package L_13.ex01;

import java.util.Objects;

public class Region {
    private String name;
    private int population;

    public Region(final String name, final int population) {
        this.name = Objects.requireNonNull(name);
        if (population < 0)
            throw new IllegalArgumentException("Population has to be non-negative.");
        else
            this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        return population == region.population && name.equals(region.name);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + population;
        return result;
    }

    public boolean setPopulation(final int population) {
        if (population < 0)
            return false;
        this.population = population;
        return true;
    }

    @Override
    public String toString() {
        return name + ", population: " + population;
    }
}
