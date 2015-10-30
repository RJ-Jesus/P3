package L_07.lect7;

import rjj.util.Time;

import java.util.Objects;

public class Flight {
    private Time time;
    private AirLine airLine;
    private int flightNumber;
    private String string;
    private Time delay;

    public Flight(Time time, AirLine airLine, int flightNumber, String string) {
        this.time = Objects.requireNonNull(time);
        this.airLine = Objects.requireNonNull(airLine);
        this.flightNumber = Objects.requireNonNull(flightNumber);
        this.string = Objects.requireNonNull(string);
        this.delay = new Time(0, 0, 0);
    }

    public Time getTime() {
        return time;
    }

    public AirLine getAirLine() {
        return airLine;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getString() {
        return string;
    }

    public Time getDelay() {
        return delay;
    }

    public void setDelay(Time delay) {
        this.delay = Objects.requireNonNull(delay);
    }

    public Time ETA() {
        return Time.addTimes(time, delay);
    }
}
