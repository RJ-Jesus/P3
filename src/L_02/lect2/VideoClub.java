package L_02.lect2;

import java.util.*;
import java.util.stream.Collectors;

public class VideoClub {
    private final int maxRequisitions;
    private HashMap<Integer, Movie> movies;
    private HashMap<Integer, User> users;
    private LinkedList<Requisition> requisitions;

    public VideoClub(final int maxRequisitions) {
        if (maxRequisitions <= 0)
            throw new IllegalArgumentException("Maximum amount of requisitions can only be a positive integer.");
        movies = new HashMap<>();
        users = new HashMap<>();
        requisitions = new LinkedList<>();
        this.maxRequisitions = maxRequisitions;
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

    public boolean checkIn(final int movieId, final int rating) {
        if (!containsMovie(movieId))
            throw new NoSuchElementException("Movie doesn't exist.");
        if (rating < 1 || rating > 10)
            throw new IllegalArgumentException("Rating value must be an integer between 1 and 10.");
        for (final Requisition r : requisitions)
            if (r.getMovieId() == movieId && r.isActive()) {
                movies.get(movieId).addReview(rating);
                users.get(r.getUserId()).deliveredMovie();
                r.checkIn();
                return true;
            }
        return false;
    }

    public boolean checkOut(final int movieId, final int userId) {
        if (!containsMovie(movieId))
            throw new NoSuchElementException("Movie doesn't exist.");
        if (!containsUser(userId))
            throw new NoSuchElementException("User doesn't exist.");
        User user = users.get(userId);
        if (!isRequested(movieId) && user.getNumberOfRequisitions() < maxRequisitions) {
            requisitions.add(new Requisition(movieId, userId));
            user.requestedMovie();
            return true;
        } else return false;
    }

    public boolean isRequested(final int movieId) {
        if (!containsMovie(movieId))
            throw new NoSuchElementException("Movie doesn't exist.");
        for (final Requisition r : requisitions)
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

    public double averageRatingOf(final int movieId) {
        return movies.get(movieId).getAverageRating();
    }

    public Movie[] getMoviesSortedByRating() {
        /*
        TreeSet<Movie> sortedMovies = new TreeSet<>(new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return Double.compare(m2.getAverageRating(), m1.getAverageRating());
            }
        });
         */
        TreeSet<Movie> sortedMovies = new TreeSet<>((m1, m2) -> {
            return Double.compare(m2.getAverageRating(), m1.getAverageRating());
        });
        sortedMovies.addAll(movies.values());
        return sortedMovies.toArray(new Movie[sortedMovies.size()]);
    }
}
