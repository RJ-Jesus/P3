package rjj.human.contacts;

import rjj.human.Person;

import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

public class Contacts extends TreeSet<Person> {

    public boolean load(final File f) {
        try {
            Parse.load(f).forEach(this::add);
            return true;
        } catch (IOException | NullPointerException e) {
            return false;
        }
    }

    public boolean save(final File f, final String type) {
        return Parse.save(this, f, type);
    }

}
