package L_13.ex01;

import java.util.Objects;

public class Province extends Region {
    private String governor;

    public Province(final String name, final int population, final String governor) {
        super(name, population);
        this.governor = Objects.requireNonNull(governor);
    }

    public String getGovernor() {
        return governor;
    }

    public void setGovernor(final String governor) {
        this.governor = Objects.requireNonNull(governor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Province province = (Province) o;

        return governor.equals(province.governor);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + governor.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", governor: " + governor;
    }
}
