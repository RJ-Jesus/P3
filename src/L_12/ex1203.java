package L_12;

import L_12.ex03.Contacts;
import L_12.ex03.IRWContacts;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ex1203 {

    public static void main(String[] args) {
        Path proxyList = Paths.get("src/L_12/Static.d/reflection/plugins/ex03");
        String fileNameRoot = "src/L_12/Static.d/file";
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(proxyList)) {
            for (Path entry : stream) {
                String startName = entry.getFileName().toString().substring(0,
                        entry.getFileName().toString().lastIndexOf('.'));
                String fileName = fileNameRoot + "." + startName;
                IRWContacts u = Contacts.ExtensionManager.loadPlugin("L_12.ex03." + startName);
                Contacts c = new Contacts();
                if (u != null) {
                    u.loadFile(c, Paths.get(fileName));
                    System.out.println(startName + ":\n" + c);
                    u.saveFile(c, Paths.get(fileName + ".bkp"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}