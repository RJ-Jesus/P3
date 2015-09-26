package L_02;

import L_02.lect2.*;
import rjj.util.Date;
import rjj.util.Validate;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ex0201 {
    static final Scanner sc = new Scanner(System.in);
    static VideoClub vClub = new VideoClub();

    public static void main(String[] args) {
        boolean repeat = true;
        while (repeat) {
            switch (menu()) {
                case 1:
                    addUser();
                    break;
                case 2:
                    removeUser();
                    break;
                case 3:
                    listUsers();
                    break;
                case 4:
                    whoRequestedMovie();
                    break;
                case 5:
                    addMovie();
                    break;
                case 6:
                    removeMovie();
                    break;
                case 7:
                    listMovies();
                    break;
                case 8:
                    wereRequestedByUser();
                    break;
                case 9:
                    movieIsAvailable();
                    break;
                case 10:
                    checkIn();
                    break;
                case 11:
                    checkOut();
                    break;
                case 0:
                    repeat = false;
                    break;
                default:
                    System.err.println("Something odd happened. Please repeat.");
            }
        }
    }

    public static int menu() {
        String[] options = {
                " 1 - Add user", " 2 - Remove user", " 3 - List users", " 4 - List users who requested given movie",
                " 5 - Add movie", " 6 - Remove movie", " 7 - List movies", " 8 - List movies requested by given user",
                " 9 - Check if given movie is available", "10 - Check-in  a movie", "11 - Checkout a movie",
                " 0 - Exit"
        };
        for (String s : options)
            System.out.println(s);
        return Validate.getInRange(sc, "command: ", 0, options.length);
    }

    public static void addUser() {
        vClub.addUser(newUser());
        System.out.println("Successful.");
    }

    public static User newUser() {
        String typeOfUser = "";
        while (!typeOfUser.equals("student") && !typeOfUser.equals("worker")) {
            System.out.println("Create a student or worker?");
            System.out.print("Student/Worker: ");
            typeOfUser = sc.nextLine().toLowerCase();
        }
        System.out.println("* Creating a '" + typeOfUser + "' *");
        System.out.print("Name: ");
        String name = sc.nextLine();
        int ccNumber = Validate.getInRange(sc, "C.C. number: ", 0, 99999999);
        System.out.println("Birthday");
        Date birthday = newDate();
        Date joiningDate = Date.today();
        User toReturn = null;
        switch (typeOfUser) {
            case "student":
                int nMec = Validate.getInRange(sc, "Nº Mec: ", 0, 99999);
                System.out.print("Course: ");
                String course = sc.nextLine();
                toReturn = new Student(name, ccNumber, birthday, joiningDate, nMec, course);
                break;
            case "worker":
                int nWorker = Validate.getInRange(sc, "Nº Worker: ", 0, Integer.MAX_VALUE);
                int NIF = Validate.getInRange(sc, "N.I.F.: ", 0, 999999999);
                toReturn = new Worker(name, ccNumber, birthday, joiningDate, nWorker, NIF);
                break;
            default:
                System.err.println("Something odd happened. Stopping.");
                System.exit(1);
        }
        return toReturn;
    }

    public static void removeUser() {
        vClub.removeUser(getUserId());
        System.out.println("Successful.");
    }

    public static void listUsers() {
        System.out.println("* Users *");
        for (User u : vClub.getUsers())
            System.out.println(u);
    }

    public static void whoRequestedMovie() {
        int movieId = getMovieId();
        System.out.println("* Users who requested: " + movieId + " *");
        for (User u : vClub.whoRequestedMovie(movieId))
            System.out.println(u);
    }

    public static void addMovie() {
        vClub.addMovie(newMovie());
        System.out.println("Successful.");
    }

    public static Movie newMovie() {
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Category: ");
        Movie.Category category = Movie.Category.valueOf(sc.nextLine());
        System.out.print("Age: ");
        Movie.Age age = Movie.Age.valueOf(sc.nextLine());
        return new Movie(title, category, age);
    }

    public static void removeMovie() {
        vClub.removeMovie(getMovieId());
        System.out.println("Successful.");
    }

    public static void listMovies() {
        System.out.println("* Movies *");
        for (Movie m : vClub.getMovies())
            System.out.println(m);
    }

    public static void wereRequestedByUser() {
        int userId = getUserId();
        System.out.println("* Movies that were requested by user #: " + userId + " *");
        for (Movie m : vClub.wereRequestedByUser(userId))
            System.out.println(m);
    }

    public static void movieIsAvailable() {
        System.out.println(vClub.isRequested(getMovieId()) ? "Not available." : "Available.");
    }

    public static void checkIn() {
        vClub.checkIn(getMovieId());
    }

    public static void checkOut() {
        vClub.checkOut(getMovieId(), getUserId());
    }

    public static int getMovieId() {
        int movieId;
        while (true) {
            String in;
            while (true) {
                System.out.print("Movie ID ('l' to list all movies): ");
                in = sc.nextLine();
                try {
                    movieId = Integer.parseInt(in);
                    break;
                } catch (InputMismatchException e) {
                    if (in.equals("l")) listMovies();
                    else {
                        System.err.println("Invalid option: " + in);
                    }
                }
            }
            if (vClub.containsMovie(movieId)) return movieId;
            else System.err.println("Not a valid movie. Please try again.");
        }
    }

    public static int getUserId() {
        int userId;
        while (true) {
            String in;
            while (true) {
                System.out.print("User ID ('l' to list all users): ");
                in = sc.nextLine();
                try {
                    userId = Integer.parseInt(in);
                    break;
                } catch (InputMismatchException | NumberFormatException e) {
                    if (in.equals("l")) listUsers();
                    else {
                        System.err.println("Invalid option: " + in);
                    }
                }
            }
            if (vClub.containsUser(userId)) return userId;
            else System.err.println("Not a valid user. Please try again.");
        }
    }

    public static Date newDate() {
        while (true) {
            try {
                System.out.print("Day: ");
                int day = Integer.parseInt(sc.nextLine());
                System.out.print("Month: ");
                int month = Integer.parseInt(sc.nextLine());
                System.out.print("Year: ");
                int year = Integer.parseInt(sc.nextLine());
                return new Date(day, month, year);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.err.println("Please enter a valid date.");
            }
        }
    }
}
