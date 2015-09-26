package L_02.lect2;

public class Movie {
    private static int counter;
    private final int id;
    private String title;
    private Category category;
    private Age age;

    public Movie(final String title, final Category category, final Age age) {
        if (title == null)
            throw new IllegalArgumentException("Name can't be null.");
        if(category == null)
            throw new IllegalArgumentException("Category can't be null.");
        if(age == null)
            throw new IllegalArgumentException("Age can't be null.");
        id = counter++;
        this.title = title;
        this.category = category;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Category getCategory() {
        return category;
    }

    public Age getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "# " + id + " - Title: " + title + ", " + category + ", " + age;
    }

    public enum Category {
        Action,
        Adventure,
        Comedy,
        Crime,
        Fantasy,
        Historical,
        Historical_Fiction,
        Horror,
        Magical_Realism,
        Mystery,
        Paranoid,
        Philosophical,
        Political,
        Romance,
        Saga,
        Satire,
        Science_Fiction,
        Slice_of_Life,
        Speculative,
        Thriller,
        Urban,
        Other
    }

    public enum Age {
        ALL,
        M6,
        M12,
        M16,
        M18
    }
}
