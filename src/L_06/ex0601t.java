package L_06;

import L_06.lect6.*;
import rjj.util.Date;

import java.io.IOException;

public class ex0601t {

    public static void main(String[] args) {
        Menu menu = new Menu("Freshmen Special", "Snack UA");
        Meal[] dishes = new Meal[10];
        for (int i = 0; i < dishes.length; i++) {
            dishes[i] = randDish(i);
            int cnt = 0;
            while (cnt < 2) { // Add 2 Ingredients to each dish
                Food aux = randFood();
                if (dishes[i].addFood(aux))
                    cnt++;
                else
                    System.out.println("ERROR: It's not possible to add '" + aux + "' to -> " + dishes[i]);
            }
            menu.addMeal(dishes[i], Date.DayOfWeek.rand());
            // Random day
        }
        System.out.println("\n" + menu);
        String serFName = "src/L_06/Static.d/menu.ser";
        try {
            Menu.save(menu, serFName);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        try {
            Menu dish2 = Menu.load(serFName);
            System.out.println("\n" + (menu != dish2) + " & " + menu.equals(dish2));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    // Returns a random food
    public static Food randFood() {
        switch ((int) (Math.random() * 4)) {
            default:
            case 0:
                return new Meat(22.3, 345.3, 300, Meat.Variety.CHICKEN);
            case 1:
                return new Fish(31.3, 25.3, 200, Fish.Type.FROZEN);
            case 2:
                return new Vegetable(21.3, 22.4, 150, "Cauliflower");
            case 3:
                return new Cereal(19.3, 32.4, 110, "Corn");
        }
    }

    // Returns a random dish
    public static Meal randDish(final int i) {
        switch ((int) (Math.random() * 3)) {
            default:
            case 0:
                return new Meal("Dish N." + i);
            case 1:
                return new VegetarianMeal("Dish N." + i + " (Vegetarian)");
            case 2:
                return new DietMeal("Dish N." + i + " (Diet)", 90.8);
        }
    }

}
