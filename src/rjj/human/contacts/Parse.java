package rjj.human.contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Parse {

    public static Contacts load(final File f) throws IOException {
        final BufferedReader fbr = new BufferedReader(new FileReader(f));
        final String firstLine = fbr.readLine();
        fbr.close();
        switch (firstLine) {
            case "Nokia":
                return Nokia.load(f);
            case "vCard":
                return vCard.load(f);
            case "CSV":
                return CSV.load(f);
            default:
                throw new IllegalArgumentException("Invalid file format. Nothing was changed.");
        }
    }

    public static boolean save(final Contacts contacts, final File f, final String type) {
        try {
            switch (type) {
                case "Nokia":
                    return Nokia.save(contacts, f);
                case "vCard":
                    return vCard.save(contacts, f);
                case "CSV":
                    return CSV.save(contacts, f);
                default:
                    System.err.println(type + " not supported. Nothing was changed.");
                    return false;
            }
        } catch (final IOException e) {
            return false;
        }
    }

}
