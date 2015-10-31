package L_07.lect7;

import java.util.Objects;

public class AirLine implements Comparable<AirLine> {
    private String name, initials;

    public AirLine(final String name, final String initials) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirLine airLine = (AirLine) o;

        return !(name != null ? !name.equals(airLine.name) : airLine.name != null) &&
                !(initials != null ? !initials.equals(airLine.initials) : airLine.initials != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (initials != null ? initials.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(AirLine o) {
        return initials.compareTo(Objects.requireNonNull(o).getInitials());
    }
}
