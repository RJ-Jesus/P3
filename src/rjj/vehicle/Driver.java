package rjj.vehicle;

import rjj.human.Person;
import rjj.util.Date;

public class Driver extends Person {
    private License license;

    public Driver(final String name, final int cCardNumber, final Date birthday, final License license) {
        super(name, cCardNumber, birthday);
        if (license == null)
            throw new IllegalArgumentException("License is null.");
        this.license = license;
    }

    @Override
    public String toString() {
        return super.toString() + ", License: " + license;
    }

    public License getLicense() {
        return license;
    }

    public enum License {
        A, B, C, D
    }
}
