package L_01;

import human.Person;
import human.PersonList;
import rjj.util.Date;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex0102 {
    static final Scanner sc = new Scanner(System.in);
    static final PersonList l = new PersonList();

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            switch (menu()) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    removePerson();
                    break;
                case 3:
                    l.forEach(System.out::println);
                    break;
                case 4:
                    l.sortByName();
                    break;
                case 5:
                    l.sortByCCNumber();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.err.println("Invalid option.");
            }
        }
    }

    public static int menu() {
        String[] options = {"Add person", "Remove person", "List people in list", "Sort by name", "Sort by C.C. number", "Exit"};
        for (int i = 0, size = options.length; i < size; i++) {
            int idx = i == size - 1 ? 0 : i + 1;
            System.out.println(idx + " - " + options[i]);
        }
        while (true) {
            try {
                System.out.print("command: ");
                return Integer.parseInt(sc.nextLine());
            } catch (InputMismatchException e) {
                System.err.println("Invalid input.");
            }
        }
    }

    public static void addPerson() {
        try {
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("CCNumber: ");
            int ccNumber = Integer.parseInt(sc.nextLine());
            Date birthday = newDate();
            l.add(new Person(name, ccNumber, birthday));
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Couldn't add person to list.");
        }

    }

    public static Date newDate() {
        try {
            System.out.println("Birthday");
            System.out.print("Day: ");
            int day = Integer.parseInt(sc.nextLine());
            System.out.print("Month: ");
            int month = Integer.parseInt(sc.nextLine());
            System.out.print("Year: ");
            int year = Integer.parseInt(sc.nextLine());
            return new Date(day, month, year);
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid date. Couldn't instantiate date object.");
            return null;
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Couldn't instantiate date object.");
            return null;
        }
    }

    public static void removePerson() {
        try {
            System.out.print("Index of person in list: ");
            int idx = Integer.parseInt(sc.nextLine());
            l.remove(idx);
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Couldn't remove person from list.");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Invalid index. Couldn't remove person from list.");
        }
    }
}
