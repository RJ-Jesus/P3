package L_12.ex03;

import rjj.human.Person;
import rjj.util.Date;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSV implements IRWContacts {

    @Override
    public void loadFile(final Contacts c, final Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                String name = parts[0];
                int phoneNumber = Integer.parseInt(parts[1]);
                Date birthDate = Date.fromString(parts[2]);
                c.add(new Person(name, 0, birthDate, phoneNumber));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveFile(final Contacts c, final Path path) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write("CSV\n");
            c.forEach(p -> {
                try {
                    bw.write(p.getName() + "\t" + p.getPhoneNumber() + "\t" + p.getBirthday() + "\n");
                } catch (IOException e) {
                    System.err.println("Couldn't write: " + p);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}