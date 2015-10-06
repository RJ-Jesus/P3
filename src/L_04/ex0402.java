package L_04;

import rjj.geometry.*;

public class ex0402 {
    public static void main(String[] args) {
        Circle c1 = new Circle(2);
        Circle c2 = new Circle(new Point(1, 3), 2);
        Square q1 = new Square(2);
        Square q2 = new Square(new Point(3, 4), 2);
        Rectangle r1 = new Rectangle(2, 3);
        Rectangle r2 = new Rectangle(new Point(3, 4), 2, 3);
        ShapeSet col = new ShapeSet(42.0);
        System.out.println(col.addShape(c2));
        System.out.println(col.addShape(r1));
        System.out.println(col.addShape(r1));
        System.out.println(col.addShape(r2));
        System.out.println(col.addShape(c1));
        System.out.println(col.addShape(q2));
        System.out.println(col.addShape(q1));
        System.out.println(col.removeShape(r1));
        System.out.println(col.addShape(q1));
        System.out.println("\nTotal area of shapes' set: " + col.totalArea());
        System.out.println("\nList of shapes:");
        for (Shape f : col.getShapes())
            System.out.println(f);
        System.out.println("\n\nCircles in shapes' set:");
        for (Shape f : col.getShapes())
            if (f instanceof Circle)
                System.out.println(f);
        System.out.println("\n\nCenters of shapes:");
        for (Point p : col.getCenters())
            System.out.println(p);

    }
}
