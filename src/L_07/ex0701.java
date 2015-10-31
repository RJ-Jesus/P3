package L_07;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ex0701 {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader airLines_f = new FileReader("src/L_07/Static.d/aula7_material/companhias.txt");
        FileReader flights_f = new FileReader("src/L_07/Static.d/aula7_material/voos.txt");
    }
}
