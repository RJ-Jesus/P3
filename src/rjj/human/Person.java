package rjj.human;

import rjj.util.Date;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int ccNumber;
    private Date birthday;
    private int phoneNumber;

    public Person(final String name, final int ccNumber, final Date birthday, final int phoneNumber) {
        if(name == null)
            throw new IllegalArgumentException("Name is null.");
        if(ccNumber < 0 || ccNumber > 99999999)
            throw new IllegalArgumentException("Invalid citizen's card number.");
        if(birthday == null)
            throw new IllegalArgumentException("Birthday is null.");
        if (phoneNumber < 100000000 || phoneNumber > 999999999)
            throw new IllegalArgumentException("Invalid phone number.");
        this.name = name;
        this.ccNumber = ccNumber;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getCCNumber() {
        return ccNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + ", C.C.: " + ccNumber + ", Birthday: " + birthday;
    }

    @Override
    public int compareTo(final Person o) {
        return name.compareTo(Objects.requireNonNull(o, "Person to compare to can't be null.").getName());
    }
}
