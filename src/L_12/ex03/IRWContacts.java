package L_12.ex03;

import java.nio.file.Path;

public interface IRWContacts {
    void loadFile(Contacts contacts, Path path);

    void saveFile(Contacts contacts, Path path);
}
