package rjj.human;

import rjj.util.Date;

public class Academic extends Person {
    private static int counter = 100;
    private final int nMec;
    private Date joiningDate;

    public Academic(final String name, final int ccNumber, final Date birthday) {
        this(name, ccNumber, birthday, Date.today());
    }

    public Academic(final String name, final int ccNumber, final Date birthday, final Date joiningDate) {
        super(name, ccNumber, birthday);
        nMec = counter++;
        this.joiningDate = joiningDate;
    }

    public int getNMec() {
        return nMec;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nº Mec.: " + getNMec() + ", joined at " + getJoiningDate();

    }
}
