package rjj.human;

import rjj.util.Date;

public class Professor extends Academic {

    public Professor(final String name, final int ccNumber, final Date birthday) {
        super(name, ccNumber, birthday, Date.today());
    }

    public Professor(final String name, final int ccNumber, final Date birthday, final Date joiningDate) {
        super(name, ccNumber, birthday, joiningDate);
    }
}
