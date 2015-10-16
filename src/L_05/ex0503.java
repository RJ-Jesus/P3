package L_05;

import rjj.human.Person;
import rjj.human.contacts.Contacts;
import rjj.util.Date;

import java.io.File;
import java.io.IOException;

public class ex0503 {

    public static void main(String[] args) throws IOException {
        String file1 = "src/L_05/Static.d/file1.csv", file2 = "src/L_05/Static.d/file2.nokia", file3 = "src/L_05/Static.d/file3.vCard";
        Contacts csv = new Contacts(), nokia = new Contacts(), vCard = new Contacts();
        csv.load(new File(file1));
        nokia.load(new File(file2));
        vCard.load(new File(file3));
        csv.add(new Person("CSV", 0, new Date(1, 1, 2000), 450000000));
        nokia.add(new Person("Nokia", 0, new Date(1, 1, 2000), 450000001));
        vCard.add(new Person("vCard", 0, new Date(1, 1, 2000), 450000002));
        csv.save(new File(file1 + ".backup"), "CSV");
        nokia.save(new File(file2 + ".backup"), "Nokia");
        vCard.save(new File(file3 + ".backup"), "vCard");
    }

}
