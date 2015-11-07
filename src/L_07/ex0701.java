package L_07;

import L_07.lect7.AirLine;
import L_07.lect7.AirLineMap;
import L_07.lect7.Flight;
import L_07.lect7.FlightList;
import rjj.util.Time;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ex0701 {
    public static void main(String[] args) throws IOException {
        FileReader airLines_f = new FileReader("src/L_07/Static.d/aula7_material/companhias.txt");
        FileReader flights_f = new FileReader("src/L_07/Static.d/aula7_material/voos.txt");
        FileWriter infoPublic_f = new FileWriter("src/L_07/Static.d/aula7_resultados/Infopublico.txt");
        FileWriter cities_f = new FileWriter("src/L_07/Static.d/aula7_resultados/cidades.txt");
        File infoPublic_bin_f = new File("src/L_07/Static.d/aula7_resultados/Infopublico.bin");

        AirLineMap airLines = AirLineMap.loadFile(airLines_f);
        if (airLines == null)
            throw new NullPointerException("Couldn't parse airlines.");

        FlightList flights = FlightList.loadFile(flights_f, airLines);
        if (flights == null)
            throw new NullPointerException("Couldn't parse flights.");

        flights.saveFile(infoPublic_f);

        Map<AirLine, Time> delaysMap = flights.averageDelays(airLines);
        System.out.println("Company\tAverage Time");
        for (Map.Entry<AirLine, Time> entry : delaysMap.entrySet())
            System.out.println(entry.getKey() + " <-> " + entry.getValue());

        flights.writeCities(cities_f);

        System.out.println("Could save binary file: " + saveFileBinary(infoPublic_bin_f, flights));
        List<String> l = readFileBinary(infoPublic_bin_f);
        if (l != null) {
            System.out.println("Reading of binary file result:");
            l.forEach(System.out::println);
        }

    }

    public static boolean saveFileBinary(final File f, final FlightList fl) {
        try (RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
            raf.writeBytes("Hora\tVoo\tCompanhia\tOrigem\tAtraso\tObs\n");
            for (Flight flight : fl)
                raf.writeBytes(flight + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<String> readFileBinary(final File f) {
        List<String> l = new LinkedList<>();
        try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {
            String line;
            while ((line = raf.readLine()) != null)
                l.add(line);
            return l;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
