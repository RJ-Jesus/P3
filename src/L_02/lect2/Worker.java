package L_02.lect2;

import rjj.util.Date;

public class Worker extends User {
    private int wNum, NIF;

    public Worker(final String name, final int ccNumber, final Date birthday, final Date joiningDate, final int wNum, final int NIF) {
        super(name, ccNumber, birthday, joiningDate);
        if(wNum < 0)
            throw new IllegalArgumentException("Worker ID cannot be a negative number.");
        if(NIF < 0)
            throw new IllegalArgumentException("N.I.F. cannot be a negative value.");
        if(NIF > 999999999)
            throw new IllegalArgumentException("N.I.F. are 9 digits long.");
        this.wNum = wNum;
        this.NIF = NIF;
    }

    public int getWNum() {
        return wNum;
    }

    public int getNIF() {
        return NIF;
    }
}
