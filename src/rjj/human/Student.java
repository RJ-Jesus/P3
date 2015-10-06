package rjj.human;

import rjj.util.Date;

public class Student extends Academic {

    public Student(final String name, final int ccNumber, final Date birthday) {
        super(name, ccNumber, birthday);
    }

    public Student(final String name, final int ccNumber, final Date birthday, final Date joiningDate) {
        super(name, ccNumber, birthday, joiningDate);
    }

}
