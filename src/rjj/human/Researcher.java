package rjj.human;

import rjj.util.Date;

public class Researcher extends Student {
    private double scholarship;

    public Researcher(final String name, final int ccNumber, final Date birthday) {
        super(name, ccNumber, birthday);
    }

    public Researcher(final String name, final int ccNumber, final Date birthday, final Date joiningDate) {
        super(name, ccNumber, birthday, joiningDate);
    }

    public double getScholarship() {
        return scholarship;
    }

    public void setScholarship(final double scholarship) {
        if (scholarship <= 0)
            throw new IllegalArgumentException("A scholarship must be a positive value.");
        this.scholarship = scholarship;
    }

    @Override
    public String toString() {
        return String.format("%s, Scholarship: %.2f€", super.toString(), scholarship);
    }
}
