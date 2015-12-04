package L_12.ex03;

import rjj.human.Person;
import rjj.util.Date;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Nokia implements IRWContacts {

    @Override
    public void loadFile(final Contacts c, final Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            while (br.readLine() != null) {
                String name = br.readLine();
                int phoneNumber = Integer.parseInt(br.readLine());
                Date birthDate = Date.fromString(br.readLine());
                c.add(new Person(name, 0, birthDate, phoneNumber));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveFile(final Contacts c, final Path path) {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            bw.write("Nokia\n");
            c.forEach(p -> {
                try {
                    bw.write("\n" + p.getName() + "\n" + p.getPhoneNumber() + "\n" + p.getBirthday() + "\n");
                } catch (IOException e) {
                    System.err.println("Couldn't write: " + p);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}