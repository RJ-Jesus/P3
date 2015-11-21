package L_10;

import rjj.collections.DynamicArray;
import rjj.collections.DynamicList;
import rjj.geometry.*;
import rjj.human.Person;
import rjj.util.Date;

import java.util.Iterator;

public class ex1001 {
    public static void main(String[] args) {
        DynamicArray<Person> vp = new DynamicArray<>();
        for (int i = 0; i < 10; i++)
            vp.add(new Person("Baby in Vector " + i, 1000 + i, Date.today(), 910000000));
        Iterator<Person> vec = vp.iterator();
        printSet(vp);
        DynamicList<Person> lp = new DynamicList<>();
        while (vec.hasNext())
            lp.add(vec.next());
        for (Person aLp : lp) System.out.println(aLp);
        DynamicList<Shape> figList = new DynamicList<>();
        figList.add(new Circle(new Point(1, 3), 1));
        figList.add(new Square(new Point(3, 4), 2));
        figList.add(new Rectangle(new Point(1, 2), 2, 5));
        printSet(figList);
        System.out.println("Sum of areas at the list of Shapes: " + sumArea(figList));
        // Assuming Square extends Rectangle:
        DynamicList<Rectangle> quadList = new DynamicList<>();
        quadList.add(new Square(new Point(3, 4), 2));
        quadList.add(new Rectangle(new Point(1, 2), 2, 5));
        System.out.println("Sum of areas at the list of Rectangles: " + sumArea(quadList));
    }

    public static double sumArea(Iterable<? extends Shape> itr) {
        double sum = 0;
        for (Shape sh : itr)
            sum += sh.area();
        return sum;
    }

    public static <E> void printSet(Iterable<E> itr) {
        itr.forEach(System.out::println);
    }
}
