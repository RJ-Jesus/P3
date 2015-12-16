package L_13.ex01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Country {
    private String name;
    private Capital capital;
    private Set<Region> regions;

    public Country(final String name) {
        this(name, null);
    }

    public Country(final String name, final Capital capital) {
//        if(Objects.requireNonNull(capital).getTypeLocality() != Locality.TypeLocality.CITY)
//            throw new IllegalArgumentException("Invalid capital: Not a city.");
        this.name = Objects.requireNonNull(name);
        this.capital = capital;
        this.regions = new HashSet<>();
    }

    public boolean addRegion(final Region region) {
        return regions.add(region);
    }

    public boolean addRegions(final Region... regions) {
        return regions.length > 0 && this.regions.addAll(Arrays.asList(regions));
    }

    public String getName() {
        return name;
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(final Capital capital) {
        this.capital = capital;
    }

    public Set<Region> getRegions() {
        return regions;
    }

    public int getPopulation() {
        return regions.parallelStream().mapToInt(Region::getPopulation).reduce(0, (p1, p2) -> p1 + p2);
    }

    @Override
    public String toString() {
        return "Country: " + name +
                ", Population: " + getPopulation() +
                " (Capital: " + (capital == null ? "undef" : capital) + ')';
    }
}