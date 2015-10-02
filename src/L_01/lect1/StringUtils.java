package L_01.lect1;

public class StringUtils {
    private char[] s;

    public StringUtils(final String s) {
        if (s == null)
            throw new IllegalArgumentException("String is null.");
        this.s = s.toCharArray();
    }

    public int getNumberDigits() {
        int counter = 0;
        for (final char c : s)
            if (Character.isDigit(c))
                counter++;
        return counter;
    }

    public boolean isLowerCase() {
        for (final char c : s)
            if (Character.isUpperCase(c))
                return false;
        return true;
    }

    public boolean isUpperCase() {
        for (final char c : s)
            if (Character.isLowerCase(c))
                return false;
        return true;
    }

    public int getNumberWords() {
        return getWords().length;
    }

    public String[] getWords() {
        return toString().split("\\s+");
    }

    @Override
    public String toString() {
        return new String(s);
    }

    public String getSwitched2by2() {
        String rtn = "";
        for (int i = 1; i < s.length; i += 2)
            rtn += "" + s[i] + s[i - 1];
        int length = s.length;
        if (length % 2 != 0)
            rtn += "" + s[length - 1];
        return rtn;
    }
}
