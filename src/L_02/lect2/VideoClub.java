package L_02.lect2;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class VideoClub {
    private HashMap<Integer, Movie> movies;
    private HashMap<Integer, User> users;
    private LinkedList<Requisition> requisitions;

    public VideoClub() {
        movies = new HashMap<>();
        users = new HashMap<>();
        requisitions = new LinkedList<>();
    }

    public boolean addUser(final User user) {
        if (user == null) throw new IllegalArgumentException("User cannot be null.");
        return users.put(user.getId(), user) == null;
    }

    public boolean removeUser(final int userId) {
        return users.remove(userId) == null;
    }

    public boolean removeUser(final User user) {
        if (user == null) throw new IllegalArgumentException("User is null.");
        return removeUser(user.getId());
    }

    public User[] getUsers() {
        return users.values().toArray(new User[users.size()]);
    }

    public boolean addMovie(final Movie movie) {
        if (movie == null) throw new IllegalArgumentException("Movie cannot be null.");
        return movies.put(movie.getId(), movie) == null;
    }

    public boolean removeMovie(final int movieId) {
        return movies.remove(movieId) == null;
    }

    public boolean removeMovie(final Movie movie) {
        if (movie == null) throw new IllegalArgumentException("Movie is null.");
        return removeMovie(movie.getId());
    }

    public Movie[] getMovies() {
        return movies.values().toArray(new Movie[movies.size()]);
    }

    public boolean checkOut(final int movieId, final int userId) {
        if (!containsMovie(movieId))
            throw new NoSuchElementException("Movie doesn't exist.");
        if (!containsUser(userId))
            throw new NoSuchElementException("User doesn't exist.");
        return !isRequested(movieId) && requisitions.add(new Requisition(movieId, userId));
    }

    public boolean isRequested(final int movieId) {
        if (!containsMovie(movieId))
            throw new NoSuchElementException("Movie doesn't exist.");
        for (Requisition r : requisitions)
            if (r.getMovieId() == movieId && r.isActive())
                return true;
        return false;
    }

    public User[] whoRequestedMovie(final int movieId) {
        if (!containsMovie(movieId))
            throw new NoSuchElementException("Movie doesn't exist.");
        LinkedHashSet<User> usersWhoRequested = new LinkedHashSet<>();
        /*
        for(Requisition r : requisitions)
            if(r.getMovieId() == movieId)
                usersWhoRequested.add(users.get(r.getUserId()));
         */
        usersWhoRequested.addAll(requisitions.stream().filter(r -> r.getMovieId() == movieId).map(r -> users.get(r.getUserId())).collect(Collectors.toList()));
        return usersWhoRequested.toArray(new User[usersWhoRequested.size()]);
    }

    public Movie[] wereRequestedByUser(final int userId) {
        if (!containsUser(userId))
            throw new NoSuchElementException("User doesn't exist.");
        LinkedHashSet<Movie> moviesRequestedByUser = new LinkedHashSet<>();
        /*
        for(Requisition r : requisitions)
            if(r.getUserId() == userId)
                moviesRequestedByUser.add(movies.get(r.getMovieId()));
         */
        moviesRequestedByUser.addAll(requisitions.stream().filter(r -> r.getUserId() == userId).map(r -> movies.get(r.getMovieId())).collect(Collectors.toList()));
        return moviesRequestedByUser.toArray(new Movie[moviesRequestedByUser.size()]);
    }

    public boolean containsMovie(final int movieId) {
        return movies.containsKey(movieId);
    }

    public boolean containsUser(final int userId) {
        return users.containsKey(userId);
    }
}
