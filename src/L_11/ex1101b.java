package L_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ex1101b {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        int nWords = 0;
        Path p = Paths.get("src/L_11/Static.d/gnu.txt");
        try (BufferedReader bf = Files.newBufferedReader(p)) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] words = line.split("\\s+");
                set.addAll(Arrays.asList(words));
                nWords += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("Total of words: %d\n", nWords);
        System.out.printf("Total of unique words: %d\n", set.size());
    }
}
