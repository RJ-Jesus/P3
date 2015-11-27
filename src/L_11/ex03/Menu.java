package L_11.ex03;

import rjj.util.Date.DayOfWeek;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Menu implements Serializable {
    private static final long serialVersionUID = -7542331343036393223L;

    @SuppressWarnings("unchecked")
    private List<Meal>[] meals = (LinkedList<Meal>[]) new LinkedList<?>[DayOfWeek.size];
    private String name, place;

    public Menu(final String name, final String place) {
        if ((this.name = name) == null)
            throw new NullPointerException("Name can't be null.");
        if ((this.place = place) == null)
            throw new NullPointerException("Place can't be null.");
        for (int i = 0; i < meals.length; i++)
            meals[i] = new LinkedList<>();
    }

    public static void save(final Menu m, final String fname) throws IOException {
        save(m, new File(fname));
    }

    public static void save(final Menu m, final File f) throws IOException {
        final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(m);
        oos.close();
    }

    public static Menu load(final String fname) throws ClassNotFoundException, IOException {
        return load(new File(fname));
    }

    public static Menu load(final File f) throws IOException, ClassNotFoundException {
        final ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        final Menu rtn = (Menu) ois.readObject();
        ois.close();
        return rtn;
    }

    public Object[][] getContents() {
        final Object[][] arr = new Object[meals.length][];
        for (int i = 0; i < arr.length; i++) arr[i] = meals[i].toArray();
        return arr;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public boolean addMeal(final Meal m, final DayOfWeek d) {
        return meals[d.ordinal()].add(m);
    }

    public boolean removeMeal(final Meal m, final DayOfWeek d) {
        return meals[d.ordinal()].remove(m);
    }

    public Meal removeMeal(final int idx, final DayOfWeek d) {
        return meals[d.ordinal()].remove(idx);
    }

    public int indexOf(final Meal m, final DayOfWeek d) {
        return meals[d.ordinal()].indexOf(m);
    }

    @Override
    public String toString() {
        String rtn = "~* Name: " + name + ", Place: " + place + " *~";
        for (int i = 0; i < meals.length; i++) {
            rtn += "\n" + DayOfWeek.values()[i];
            for (final Meal m : meals[i])
                rtn += "\n" + m.toString();
        }
        return rtn;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(meals);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((place == null) ? 0 : place.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Menu other = (Menu) obj;
        if (!Arrays.equals(meals, other.meals))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (place == null) {
            if (other.place != null)
                return false;
        } else if (!place.equals(other.place))
            return false;
        return true;
    }

}
