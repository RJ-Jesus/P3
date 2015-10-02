package L_03;

import rjj.geometry.Circle;
import rjj.geometry.Point;
import rjj.geometry.Rectangle;
import rjj.geometry.Square;

public class ex0302 {

    public static void main(String[] args) {
        Circle c1 = new Circle(2);
        Circle c2 = new Circle(new Point(1, 3), 2);
        Circle c3 = new Circle(c2);
        System.out.println(c1 + " has area: " + c1.area() + " and perimeter: " + c1.perimeter());
        System.out.println(c3 + " has area: " + c3.area() + " and perimeter: " + c3.perimeter());
        System.out.println("c1 equals to c3? -> " + c1.equals(c3)); // True
        Square q1 = new Square(2);
        Square q2 = new Square(new Point(3, 4), 2);
        Square q3 = new Square(q2);
        System.out.println(q1 + " has area: " + q1.area() + " and perimeter: " + q1.perimeter());
        System.out.println(q3 + " has area: " + q3.area() + " and perimeter: " + q3.perimeter());
        System.out.println("q1 equals to q3? -> " + q1.equals(q3)); // False
        Rectangle r1 = new Rectangle(2, 3);
        Rectangle r2 = new Rectangle(new Point(3, 4), 2, 3);
        Rectangle r3 = new Rectangle(r2);
        System.out.println(r1 + " has area: " + r1.area() + " and perimeter: " + r1.perimeter());
        System.out.println(r3 + " has area: " + r3.area() + " and perimeter: " + r3.perimeter());
        System.out.println("r2 equals to r3? -> " + r2.equals(r3)); // True
    }
}
