package L_07.lect7;

import rjj.util.Time;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FlightList extends ArrayList<Flight> {

    public boolean loadFile(final FileReader f, final AirLineMap airLineCompanies) {
        try (BufferedReader reader = new BufferedReader(f)) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                int idx = 0;
                Time time = Time.fromString(line.substring(idx, idx+=5));
                if (line.charAt(idx++) != '\t')
                    return false;
                String initials;
                if(line.charAt(idx+2) == '\t') {
                    initials = line.substring(idx, idx+=2);
                    idx++;
                }
                else {
                    initials = line.substring(idx, idx += 3);
                }
                int flightNumber;
                if (line.charAt(idx + 3) == '\t') {
                    flightNumber = Integer.parseInt(line.substring(idx, idx += 3));
                }
                else {
                    flightNumber = Integer.parseInt(line.substring(idx, idx += 4));
                }
                if (line.charAt(idx++) != '\t')
                    return false;
                String[] lineEnd = line.substring(idx).split("\t");
                String origin = lineEnd[0];
                Flight flight = new Flight(time, airLineCompanies.get(initials), flightNumber, origin);
                Time delay = lineEnd.length > 1 ? Time.fromString(lineEnd[1]) : null;
                if(delay != null)
                    flight.setDelay(delay);
                this.add(flight);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
