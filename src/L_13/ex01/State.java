package L_13.ex01;

import java.util.Objects;

public class State extends Region {
    private Capital capital;

    public State(final String name, final int population, final Capital capital) {
        super(name, population);
        this.capital = Objects.requireNonNull(capital);
    }

    public Capital getCapital() {
        return capital;
    }

    public void setCapital(final Capital capital) {
        this.capital = Objects.requireNonNull(capital);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        State state = (State) o;

        return capital.equals(state.capital);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + capital.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", capital: " + capital;
    }
}
