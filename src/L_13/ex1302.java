package L_13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ex1302 {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> pairs_of_words = new TreeMap<>();

        String text = "";
        Path f_in = Paths.get("src/L_13/Static.d/Policarpo.txt");
        try (BufferedReader br = Files.newBufferedReader(f_in)) {
            String line;
            while ((line = br.readLine()) != null)
                text += " " + line;
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = Arrays.stream(text.toLowerCase().split("\\W+")).filter(s -> s.length() >= 3).toArray(String[]::new);
        for (int i = 0; i < words.length - 1; i++) {
            pairs_of_words.putIfAbsent(words[i], new TreeMap<>());
            Map<String, Integer> map_of_this_word = pairs_of_words.get(words[i]);
            map_of_this_word.put(words[i + 1], map_of_this_word.getOrDefault(words[i + 1], 0) + 1);
        }

        Path f_out = Paths.get("src/L_13/Static.d/output.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(f_out)) {
            pairs_of_words.entrySet().forEach(entry -> {
                try {
                    String word = entry.getKey();
                    Map<String, Integer> map = entry.getValue();
                    String equality = map.entrySet().stream().map(values -> values.getKey() + "=" + values.getValue()).reduce((s1, s2) -> s1 + ", " + s2).get();
                    bw.write(word + "={" + equality + "}\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
