package rjj.vehicle;

public interface PoliceVehicle {
    String getType();

    String getID();

    enum Type {
        INEM,
        Firemen,
        GNR,
        PSP,
        PJ
    }
}
