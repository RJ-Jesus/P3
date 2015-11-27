package L_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ex1101c {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Path p = Paths.get("src/L_11/Static.d/gnu.txt");
        try (BufferedReader bf = Files.newBufferedReader(p)) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words)
                    map.put(word, map.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
    }
}
