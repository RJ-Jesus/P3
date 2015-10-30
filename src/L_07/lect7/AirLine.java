package L_07.lect7;

import java.util.Objects;

public class AirLine {
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
}
