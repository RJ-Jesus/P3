package L_02.lect2;

public class Requisition {
    private final int movieId;
    private final int userId;
    private boolean isActive;

    public Requisition(final int movieId, final int userId) {
        this.movieId = movieId;
        this.userId = userId;
        isActive = true;
    }

    public int getMovieId() {
        return movieId;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean checkIn() {
        if (!isActive)
            return false;
        else {
            isActive = false;
            return true;
        }
    }
}
