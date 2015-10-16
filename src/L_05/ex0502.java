package L_05;

import rjj.util.Compare;
import rjj.vehicle.*;

public class ex0502 {
    public static void main(String[] args) {
        Car car = new Car("Blue", 2015, "99-ZZ-99", 500, 525, 550, 5, "Gasoline");
        Motorcycle moto = new Motorcycle("Silver", 2014, "88-YY-88", 500, 525, 550, 5, "Gasoline");
        Bicycle bike = new Bicycle("Silver Blue", 2013);
        PoliceCar pCar = new PoliceCar("Black", 2013, "00-AA-00", 500, 525, 550, 5, "Gasoline", "Car-01", PoliceVehicle.Type.GNR);
        PoliceMotorcycle pMoto = new PoliceMotorcycle("Black", 2014, "11-BB-11", 500, 525, 550, 5, "Gasoline", "Moto-01", PoliceVehicle.Type.PSP);
        PoliceBike pBike = new PoliceBike("Black", 2015, "Bike-01", PoliceVehicle.Type.PSP);
        Vehicle[] vehicles = {car, moto, bike, pCar, pMoto, pBike};
        Compare.sortArray(vehicles);
        for (Vehicle vehicle : vehicles)
            System.out.println(vehicle);
    }
}
