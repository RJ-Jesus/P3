package L_09;

import L_09.ex03.BFIterator;
import L_09.ex03.DynamicArray;
import L_09.ex03.DynamicList;
import rjj.human.Person;
import rjj.util.Date;

public class ex0903 {
    public static void main(String[] args) {
        DynamicArray<Person> vp = new DynamicArray<>();
        for (int i = 0; i < 10; i++)
            vp.add(new Person("Baby in Vector " + i, 1000 + i, Date.today(), 990000000));
        DynamicList<Person> lp = new DynamicList<>();
        for (int i = 0; i < 10; i++)
            lp.add(new Person("Baby in List " + i, 2000 + i, Date.today(), 990000000));

        BFIterator<Person> arrayItr = vp.iterator();
        BFIterator<Person> listItr = lp.iterator();

        System.out.println("Array and List (as inserted):");
        while (arrayItr.hasNext())
            System.out.println(arrayItr.next());
        while (listItr.hasNext())
            System.out.println(listItr.next());

        System.out.println("Array and List (reversed):");
        while (arrayItr.hasPrevious())
            System.out.println(arrayItr.previous());
        while (listItr.hasPrevious())
            System.out.println(listItr.previous());
    }
}
