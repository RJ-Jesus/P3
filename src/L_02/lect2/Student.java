package L_02.lect2;

import rjj.util.Date;

public class Student extends User {
    private int nMec;
    private String course;

    public Student(final String name, final int ccNumber, final Date birthday, final Date joiningDate, final int nMec, final String course) {
        super(name, ccNumber, birthday, joiningDate);
        if(course == null)
            throw new IllegalArgumentException("Course can't be null.");
        if(nMec < 0)
            throw new IllegalArgumentException("Nº Mec can't be negative.");
        this.nMec = nMec;
        this.course = course;
    }

    public int getNMec() {
        return nMec;
    }

    public String getCourse() {
        return course;
    }
}
