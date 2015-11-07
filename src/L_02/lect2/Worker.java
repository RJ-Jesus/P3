package L_02.lect2;

import rjj.util.Date;

public class Worker extends User {
    private int nWorker, NIF;

    public Worker(final String name, final int ccNumber, final Date birthday, final Date joiningDate, final int nWorker, final int NIF) {
        super(name, ccNumber, birthday, joiningDate);
        if (nWorker < 0)
            throw new IllegalArgumentException("Worker ID cannot be a negative number.");
        if (NIF < 0)
            throw new IllegalArgumentException("N.I.F. cannot be a negative value.");
        if (NIF > 999999999)
            throw new IllegalArgumentException("N.I.F. are 9 digits long.");
        this.nWorker = nWorker;
        this.NIF = NIF;
    }

    public int getNWorker() {
        return nWorker;
    }

    public int getNIF() {
        return NIF;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nº Worker: " + nWorker + ", N.I.F.: " + NIF;
    }
}
