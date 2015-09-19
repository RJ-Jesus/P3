package L_01;

import rjj.geometry.Circle;
import rjj.geometry.Point2D;
import rjj.geometry.Rectangle;
import rjj.geometry.Square;

import java.util.Scanner;

public class ex0103 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Point2D center;
        System.out.print("Shape (circle, rectangle, square): ");
        switch (sc.nextLine().toLowerCase()) {
            case "circle":
                center = newCenter();
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                Circle c = new Circle(center, radius);
                System.out.println("Area: " + c.area());
                System.out.println("Perimeter: " + c.perimeter());
                break;
            case "rectangle":
                center = newCenter();
                System.out.print("Height: ");
                double height = sc.nextDouble();
                System.out.print("Wdith: ");
                double width = sc.nextDouble();
                Rectangle r = new Rectangle(center, height, width);
                System.out.println("Area: " + r.area());
                System.out.println("Perimeter: " + r.perimeter());
                System.out.println(r);
                break;
            case "square":
                center = newCenter();
                System.out.print("Side: ");
                double side = sc.nextDouble();
                Square s = new Square(center, side);
                System.out.println("Area: " + s.area());
                System.out.println("Perimeter: " + s.perimeter());
                break;
            default:
                System.err.println("Shape not supported.");
        }
    }

    public static Point2D newCenter() {
        System.out.println("Center");
        System.out.print("x: ");
        double x = sc.nextDouble();
        System.out.print("y: ");
        double y = sc.nextDouble();
        return new Point2D(x, y);
    }
}
