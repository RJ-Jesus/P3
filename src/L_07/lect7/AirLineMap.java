package L_07.lect7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class AirLineMap extends HashMap<String, AirLine> {

    public static AirLineMap loadFile(final FileReader f) {
        AirLineMap rtn = new AirLineMap();
        try (BufferedReader reader = new BufferedReader(f)) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\t");
                AirLine airLine = new AirLine(fields[0], fields[1]);
                rtn.put(fields[0], airLine);
            }
            return rtn;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
