package human;

import rjj.util.Date;

public class Person {
    private String name;
    private int ccNumber;
    private Date birthday;

    public Person(final String name, final int ccNumber, final Date birthday) {
        if(name == null)
            throw new IllegalArgumentException("Name is null.");
        if(ccNumber < 0 || ccNumber > 99999999)
            throw new IllegalArgumentException("Invalid citizen's card number.");
        if(birthday == null)
            throw new IllegalArgumentException("Birthdate is null.");
        this.name = name;
        this.ccNumber = ccNumber;
        this.birthday = birthday;
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

    @Override
    public String toString() {
        return name + ", C.C.: " + ccNumber + ", Birthday: " + birthday;
    }
}
