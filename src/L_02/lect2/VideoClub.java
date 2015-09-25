package L_02.lect2;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class VideoClub {
    private LinkedList<Movie> movies;
    private LinkedHashSet<User> users;

    public VideoClub() {
        movies = new LinkedList<>();
        users = new LinkedHashSet<>();
    }

    public boolean addUser(final User user) {
        if (user == null) throw new IllegalArgumentException("User cannot be null.");
        return users.add(user);
    }

    public boolean removeUser(final User user) {
        return users.remove(user);
    }

    public User[] getUsers() {
        return users.toArray(new User[users.size()]);
    }

    public boolean addMovie(final Movie movie) {
        if (movie == null) throw new IllegalArgumentException("Movie cannot be null.");
        return movies.add(movie);
    }

    public boolean removeMovie(final Movie movie) {
        return movies.remove(movie);
    }

    public Movie[] getMovies() {
        return movies.toArray(new Movie[movies.size()]);
    }
}
