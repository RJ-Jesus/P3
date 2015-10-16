package rjj.human.contacts;

import rjj.human.Person;
import rjj.util.Date;

import java.io.*;

class vCard extends Parse {

    public static Contacts load(final File f) throws IOException {
        final Contacts contacts = new Contacts();
        final BufferedReader fbr = new BufferedReader(new FileReader(f));
        fbr.readLine();
        String line = fbr.readLine();
        while (line != null) {
            final String[] parts = line.split("#");
            final String name = parts[1];
            final int phoneNumber = Integer.parseInt(parts[2]);
            final Date birthDate = Date.fromString(parts[3]);
            contacts.add(new Person(name, 0, birthDate, phoneNumber));
            line = fbr.readLine();
        }
        fbr.close();
        return contacts;
    }

    public static boolean save(final Contacts contacts, final File f) throws IOException {
        final BufferedWriter fwr = new BufferedWriter(new FileWriter(f));
        fwr.write("vCard\n");
        for (final Person p : contacts)
            fwr.write("#" + p.getName() + "#" + p.getPhoneNumber() + "#" + p.getBirthday() + "\n");
        fwr.close();
        return true;
    }

}
