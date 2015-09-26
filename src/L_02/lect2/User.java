package L_02.lect2;

import rjj.util.Date;

public class User extends rjj.human.Person {
    private static int counter;
    private final int id;
    private Date joiningDate;
    private int numberOfRequisitions;

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

    public void requestedMovie() {
        numberOfRequisitions++;
    }

    public void deliveredMovie() {
        if (numberOfRequisitions <= 0)
            throw new IllegalStateException("Can't hand in more movies than those requested.");
        numberOfRequisitions--;
    }

    public int getNumberOfRequisitions() {
        return numberOfRequisitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "# " + id + " - " + super.toString() + ", joined at " + joiningDate;
    }
}
