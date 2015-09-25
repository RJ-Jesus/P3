package L_02.lect2;

import rjj.util.Date;

public class User extends rjj.human.Person {
    private static int counter;
    private final int id;
    private Date joiningDate;

    public User(final String name, final int ccNumber, final Date birthday, final Date joiningDate) {
        super(name, ccNumber, birthday);
        if(joiningDate == null)
            throw new IllegalArgumentException("Joining date cannot be null.");
        id = counter++;
        this.joiningDate = joiningDate;
    }

    public int getId() {
        return id;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getId() == user.getId();

    }

    @Override
    public int hashCode() {
        return getId();
    }
}
