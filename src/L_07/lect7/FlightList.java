package L_07.lect7;

import rjj.util.Compare;
import rjj.util.Time;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

public class FlightList extends ArrayList<Flight> {

    public static FlightList loadFile(final FileReader f, final AirLineMap airLineCompanies) {
        FlightList rtn = new FlightList();
        try (BufferedReader reader = new BufferedReader(f)) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                int idx = 0;
                Time time = Time.fromString(line.substring(idx, idx += 5));
                if (line.charAt(idx++) != '\t')
                    return null;
                String initials = line.substring(idx, idx += 2);
                AirLine airLine = airLineCompanies.containsKey(initials) ? airLineCompanies.get(initials) : new AirLine(initials, "Unknown");
                String flightNumber = line.charAt(idx + 4) != '\t' ?
                        line.substring(idx, idx += 5).replaceAll("\\s+", "") :
                        line.substring(idx, idx += 4).replaceAll("\\s+", "");
                if (line.charAt(idx++) != '\t')
                    return null;
                String[] lineEnd = line.substring(idx).split("\t");
                String origin = lineEnd[0];
                Flight flight = new Flight(time, airLine, flightNumber, origin);
                Time delay = lineEnd.length > 1 ? Time.fromString(lineEnd[1]) : null;
                if (delay != null)
                    flight.setDelay(delay);
                rtn.add(flight);
            }
            return rtn;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<AirLine, Time> averageDelays(final AirLineMap airLines) {
        Map<AirLine, Time> delaysMap = new HashMap<>();
        for (Map.Entry<String, AirLine> entry : airLines.entrySet()) {
            AirLine al = entry.getValue();
            LinkedList<Time> fl = this.stream().filter(f -> f.getAirLine().equals(al)).map(Flight::getDelay).collect(Collectors.toCollection(LinkedList<Time>::new));
            delaysMap.put(al, Time.averageTime(fl.toArray(new Time[fl.size()])));
        }
        return Compare.MapUtil.sortByValue(delaysMap);
    }

    public boolean writeCities(final FileWriter f) {
        Map<String, Integer> citiesMap = new HashMap<>();
        for (Flight fl : this) {
            Integer res = citiesMap.get(fl.getOrigin());
            if (res == null)
                citiesMap.put(fl.getOrigin(), 1);
            else
                citiesMap.put(fl.getOrigin(), res + 1);
        }
        try {
            f.write("Origem\tVoo");
            for (Map.Entry<String, Integer> entry : Compare.MapUtil.sortByValue(citiesMap).entrySet())
                f.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            f.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveFile(final FileWriter f) {
        try {
            f.write("Hora\tVoo\tCompanhia\tOrigem\tAtraso\tObs\n");
            for (Flight fl : this)
                f.write(fl + "\n");
            f.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
