package rjj.util;

import java.util.Scanner;

public class Validate {
    public static void notNull(final Object o, final String msg) {
        if (o == null)
            throw new IllegalArgumentException(msg);
    }

    public static int getInRange(final String msg, final int min, final int max) {
        if (min > max)
            throw new IllegalArgumentException("Invalid range: [" + min + ", " + max + "]");
        while (true) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.print(msg == null ? "" : msg + ": ");
                int toReturn = Integer.parseInt(sc.nextLine());
                if (toReturn >= min && toReturn <= max) return toReturn;
                else System.err.println("Integer out of range: [" + min + ", " + max + "]");
            } catch (NumberFormatException e) {
                System.err.println("Couldn't parse content.");
            }
        }
    }
}
