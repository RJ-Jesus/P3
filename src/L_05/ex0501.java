package L_05;

import rjj.geometry.*;
import rjj.util.Compare;

public class ex0501 {
    public static void main(String[] args) {
        Circle c1 = new Circle(2);
        Circle c2 = new Circle(new Point(1, 3), 2);
        Square q1 = new Square(2);
        Square q2 = new Square(new Point(3, 4), 2);
        Rectangle r1 = new Rectangle(2, 3);
        Rectangle r2 = new Rectangle(new Point(3, 4), 2, 3);
        ShapeSet col = new ShapeSet(42.0);          // MaxArea
        System.out.println(col.addShape(c2));       // true
        System.out.println(col.addShape(r1));       // true
        System.out.println(col.addShape(r1));       // false
        System.out.println(col.addShape(r2));       // true
        System.out.println(col.addShape(c1));       // true
        System.out.println(col.addShape(q2));       // true
        System.out.println(col.addShape(q1));       // false
        System.out.println(col.removeShape(r1));    // true
        System.out.println(col.addShape(q1));       // true

        System.out.println("\nTotal area of shape's set: " + col.totalArea());
        Shape[] shapeSet = col.getShapes();
        System.out.println("\nList of shapes:");
        for (Shape f : shapeSet)
            System.out.println(f);

        System.out.println("\nComparison of first shape's area with others");
        for (int i = 0; i < shapeSet.length; i++) {
            System.out.printf("%2d %12s of area %6.2f compareTo(shapeSet[0]) = %2d\n", i,
                    shapeSet[i].getClass().getSimpleName(),
                    shapeSet[i].area(),
                    shapeSet[i].compareTo(shapeSet[0]));
        }
        System.out.println("\nShape with greater area: " + Compare.findMax(shapeSet));
        // Sort (increasingly) the array of Shapes according to their area
        Compare.sortArray(shapeSet);
        System.out.println("\nList of shapes ordered by area:");
        for (Shape f : shapeSet)
            System.out.println(f + " -> area: " + String.format("%2.2f", f.area()) +
                    " and perimeter: " + String.format("%2.2f", f.perimeter()));

    }
}
