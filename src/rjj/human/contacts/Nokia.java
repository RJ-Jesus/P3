package rjj.human.contacts;

import rjj.human.Person;
import rjj.util.Date;

import java.io.*;

class Nokia extends Parse {

    public static Contacts load(final File f) throws IOException {
        final Contacts contacts = new Contacts();
        final BufferedReader fbr = new BufferedReader(new FileReader(f));
        fbr.readLine();
        String line = "";
        while (line != null) {
            final String name = fbr.readLine();
            if (name == null) break;
            final int phoneNumber = Integer.parseInt(fbr.readLine());
            final Date birthDate = Date.fromString(fbr.readLine());
            contacts.add(new Person(name, 0, birthDate, phoneNumber));
            line = fbr.readLine();
        }
        fbr.close();
        return contacts;
    }

    public static boolean save(final Contacts contacts, final File f) throws IOException {
        final BufferedWriter fwr = new BufferedWriter(new FileWriter(f));
        fwr.write("Nokia");
        for (final Person p : contacts)
            fwr.write("\n" + p.getName() + "\n" + p.getPhoneNumber() + "\n" + p.getBirthday() + "\n");
        fwr.close();
        return true;
    }

}
