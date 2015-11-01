package L_07.lect7.ex01;

import rjj.util.Time;

import java.util.Objects;

public class Flight {
    private Time time;
    private AirLine airLine;
    private String flightNumber;
    private String origin;
    private Time delay;

    public Flight(Time time, AirLine airLine, String flightNumber, String origin) {
        this.time = Objects.requireNonNull(time);
        this.airLine = Objects.requireNonNull(airLine);
        this.flightNumber = Objects.requireNonNull(flightNumber);
        this.origin = Objects.requireNonNull(origin);
        this.delay = new Time(0, 0, 0);
    }

    public Time getTime() {
        return time;
    }

    public AirLine getAirLine() {
        return airLine;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
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

    @Override
    public String toString() {
        return time.toString().substring(0, 5) + "\t" +
                airLine.getInitials() +
                (Character.isAlphabetic(flightNumber.charAt(0)) ? "" : " " ) + flightNumber + "\t" +
                airLine.getName() + "\t" +
                origin + '\t' +
                (delay.equals(new Time(0, 0, 0)) ? "" : delay.toString().substring(0, 5) + "\t" + "Expected arrival: "
                        + ETA().toString().substring(0, 5));
    }
}
