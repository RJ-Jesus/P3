package L_07.lect7.ex01;

import java.util.Objects;

public class AirLine implements Comparable<AirLine> {
    private String name, initials;

    public AirLine(final String initials, final String name) {
        this.name = Objects.requireNonNull(name);
        this.initials = Objects.requireNonNull(initials);
    }

    public String getName() {
        return name;
    }

    public String getInitials() {
        return initials;
    }

    @Override
    public String toString() {
        return initials + " - " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirLine airLine = (AirLine) o;

        return initials.equals(airLine.initials);

    }

    @Override
    public int hashCode() {
        return initials.hashCode();
    }

    @Override
    public int compareTo(AirLine o) {
        return initials.compareTo(Objects.requireNonNull(o).getInitials());
    }
}
