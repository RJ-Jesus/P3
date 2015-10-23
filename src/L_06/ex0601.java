package L_06;

import L_06.lect6.*;
import rjj.util.Date.DayOfWeek;

import java.io.IOException;
import java.util.Scanner;

public class ex0601 {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        int opt = -1;
        System.out.print("Name for the menu: ");
        String name = sc.nextLine();
        System.out.print("Place: ");
        String place = sc.nextLine();
        Menu menu = new Menu(name, place);
        Food food = null;
        Meal meal = null;
        while (opt != 0) {
            opt = menu();
            switch (opt) {
                case 1:
                    food = createMeat();
                    break;
                case 2:
                    food = createFish();
                    break;
                case 3:
                    food = createCereal();
                    break;
                case 4:
                    food = createVegetable();
                    break;
                case 5:
                    meal = createMeal();
                    break;
                case 6:
                    meal = null;
                    break;
                case 7:
                    showMeal(meal);
                    break;
                case 8:
                    addIngredient(meal, food);
                    break;
                case 9:
                    removeIngredient(meal);
                    break;
                case 10:
                    addMeal(menu, meal);
                    break;
                case 11:
                    removeMeal(menu);
                    break;
                case 12:
                    listMenu(menu);
                    break;
                case 13:
                    saveMenu(menu);
                    break;
                case 14:
                    menu = loadMenu();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Something went wrong. Stopping.");
                    System.exit(1);
            }
        }
    }

    public static int menu() {
        System.out.println("Ingredient");
        System.out.println("  1 - Create meat");
        System.out.println("  2 - Create fish");
        System.out.println("  3 - Create cereal");
        System.out.println("  4 - Create Vegetable");
        System.out.println("Meal");
        System.out.println("  5 - Create meal");
        System.out.println("  6 - Delete meal");
        System.out.println("  7 - Select (show) meal");
        System.out.println("  8 - Add ingredient");
        System.out.println("  9 - Remove ingredient");
        System.out.println("Menu");
        System.out.println(" 10 - Add meal");
        System.out.println(" 11 - Remove meal");
        System.out.println(" 12 - List menu");
        System.out.println(" 13 - Save menu");
        System.out.println(" 14 - Load menu");
        System.out.println("Notice: All actions always refer to the latest created ingredient/meal.");
        System.out.println("  0 - Exit");
        System.out.print("command: ");
        return inRange(0, 14);
    }

    public static Meat createMeat() {
        System.out.println("Proteins: ");
        double proteins = greaterThan(0);
        System.out.println("Calories: ");
        double calories = greaterThan(0);
        System.out.println("Weight: ");
        double weight = greaterThan(0);
        System.out.println("Variety: ");
        Meat.Variety variety = Meat.Variety.valueOf(sc.nextLine());
        return new Meat(proteins, calories, weight, variety);
    }

    public static Fish createFish() {
        System.out.println("Proteins: ");
        double proteins = greaterThan(0);
        System.out.println("Calories: ");
        double calories = greaterThan(0);
        System.out.println("Weight: ");
        double weight = greaterThan(0);
        System.out.println("Type: ");
        Fish.Type type = Fish.Type.valueOf(sc.nextLine());
        return new Fish(proteins, calories, weight, type);
    }

    public static Cereal createCereal() {
        System.out.println("Proteins: ");
        double proteins = greaterThan(0);
        System.out.println("Calories: ");
        double calories = greaterThan(0);
        System.out.println("Weight: ");
        double weight = greaterThan(0);
        System.out.println("Name: ");
        String name = sc.nextLine();
        return new Cereal(proteins, calories, weight, name);
    }

    public static Vegetable createVegetable() {
        System.out.println("Proteins: ");
        double proteins = greaterThan(0);
        System.out.println("Calories: ");
        double calories = greaterThan(0);
        System.out.println("Weight: ");
        double weight = greaterThan(0);
        System.out.println("Variety: ");
        String name = sc.nextLine();
        return new Vegetable(proteins, calories, weight, name);
    }

    public static Meal createMeal() {
        System.out.print("Meal name: ");
        return new Meal(sc.nextLine());
    }

    public static void showMeal(final Meal m) {
        System.out.println(m);
    }

    public static void addIngredient(final Meal m, final Food f) {
        if (m == null) {
            System.err.println("There is no created meal.");
            return;
        }
        if (f == null) {
            System.err.println("There is no created ingredient.");
            return;
        }
        m.addFood(f);
    }

    public static void removeIngredient(final Meal m) {
        if (m == null) {
            System.err.println("There is no created meal.");
            return;
        }
        int i = 0;
        for (Object f : m.getContents())
            System.out.printf("%d - %s\n", i++, f);
        if (i == 0) {
            System.err.println("No ingredients have been added to this meal.");
            return;
        }
        int idx = inRange(0, i - 1);
        m.removeFood(idx);
    }

    public static void addMeal(final Menu mn, final Meal m) {
        System.out.print("Day of week: ");
        mn.addMeal(m, DayOfWeek.valueOf(sc.nextLine()));
    }

    public static void removeMeal(final Menu mn) {
        int i = 0;
        System.out.print("Day of week: ");
        DayOfWeek day = DayOfWeek.valueOf(sc.nextLine());
        System.out.println(day);
        for (Object m : mn.getContents()[day.ordinal()]) {
            System.out.printf("%d - %s\n", i++, m);
        }
        if (i == 0) {
            System.err.println("No meals have been added to this menu.");
            return;
        }
        int idx = inRange(0, i - 1);
        mn.removeMeal((Meal) mn.getContents()[day.ordinal()][idx], day);
    }

    public static void listMenu(final Menu mn) {
        System.out.println(mn);
    }

    public static void saveMenu(final Menu mn) throws IOException {
        System.out.print("File name (ENTER for default): ");
        String fname = sc.nextLine();
        fname = fname.length() == 0 ? "src/L_06/Static.d/menu.ser" : fname;
        Menu.save(mn, fname);
    }

    public static Menu loadMenu() throws ClassNotFoundException, IOException {
        System.out.print("File name (ENTER for default): ");
        String fname = sc.nextLine();
        fname = fname.length() == 0 ? "src/L_06/Static.d/menu.ser" : fname;
        return Menu.load(fname);
    }

    private static int inRange(final int min, final int max) {
        int x = Integer.MIN_VALUE;
        while (x < min || x > max)
            x = Integer.parseInt(sc.nextLine());
        return x;
    }

    private static double greaterThan(final double min) {
        double x = Double.NEGATIVE_INFINITY;
        while (x < min)
            x = Double.parseDouble(sc.nextLine());
        return x;
    }
}
