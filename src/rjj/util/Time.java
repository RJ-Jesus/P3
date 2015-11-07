package rjj.util;

import java.util.Objects;

public class Time implements Comparable<Time> {
    private long seconds;

    public Time(final long time) {
        if (time < 0 || time > 24 * 3600 - 1)
            throw new IllegalArgumentException("Invalid time stamp.");
        this.seconds = time;
    }

    public Time(final int hour, final int minute, final int second) {
        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("Invalid hour.");
        if (minute < 0 || minute > 59)
            throw new IllegalArgumentException("Invalid minute.");
        if (second < 0 || second > 59)
            throw new IllegalArgumentException("Invalid second.");
        this.seconds = hour * 3600 + minute * 60 + second;
    }

    public static Time fromString(final String time) {
        String[] timeParams = time.split(":");
        switch (timeParams.length) {
            case 1:
                return new Time(Integer.parseInt(timeParams[0]), 0, 0);
            case 2:
                return new Time(Integer.parseInt(timeParams[0]), Integer.parseInt(timeParams[1]), 0);
            case 3:
                return new Time(Integer.parseInt(timeParams[0]), Integer.parseInt(timeParams[1]), Integer.parseInt(timeParams[2]));
            default:
                throw new IllegalArgumentException("Invalid time string");
        }
    }

    public static Time addTimes(final Time... t) {
        Time rtn = new Time(0, 0, 0);
        for (Time aT : t) rtn.addTime(aT);
        return rtn;
    }

    public static Time averageTime(final Time... t) {
        if (t.length == 0)
            return null;
        Time rtn = addTimes(t);
        rtn.seconds = Math.round((double) rtn.seconds / t.length);
        return rtn;
    }

    public long getHours() {
        return seconds / 3600;
    }

    public long getMinutes() {
        return (seconds - getHours() * 3600) / 60;
    }

    public long getSeconds() {
        return seconds % 60;
    }

    public void addTime(final Time t) {
        Objects.requireNonNull(t, "Invalid time.");
        this.seconds = (this.seconds + t.seconds) % (24 * 3600 - 1);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Time time = (Time) o;

        return seconds == time.seconds;

    }

    @Override
    public int hashCode() {
        return (int) (seconds ^ (seconds >>> 32));
    }

    @Override
    public int compareTo(Time o) {
        return Long.compare(seconds, Objects.requireNonNull(o).seconds);
    }
}
