package rjj.human;

import java.util.Comparator;
import java.util.LinkedList;

public class PersonList extends LinkedList<Person> {
    public void sortByName() {
        this.sort(new Comparator<Person>() {
            @Override
            public int compare(final Person p1, final Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
    }

    public void sortByCCNumber() {
        this.sort(new Comparator<Person>() {
            @Override
            public int compare(final Person p1, final Person p2) {
                return Integer.compare(p1.getCCNumber(), p2.getCCNumber());
            }
        });
    }
}
