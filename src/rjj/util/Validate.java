package rjj.util;

public class Validate {
    public static void notNull(final Object o, final String msg) {
        if(o == null)
            throw new IllegalArgumentException(msg);
    }
}
