package L_03;

import rjj.util.Date;
import rjj.vehicle.*;

public class ex0303 {
    public static void main(String[] args) {
        Driver d = new Driver("Vin Diesel", 0, new Date(1, 1, 2000), Driver.License.valueOf("A"));
        MotorVehicle mv1 = new Car("Blue", 2015, "00-AA-00", 1000, 1000, 1000, 1000, "Gas");
        MotorVehicle mv2 = new Motorcycle("Blue", 2015, "11-BB-11", 1000, 1000, 1000, 1000, "Gas");
        MotorVehicle mv3 = new GoodsVehicle("Blue", 2015, "01-AB-01", 1000, 1000, 1000, 1000, "Gas", "Oil");
        MotorVehicle mv4 = new PassengersVehicle("Blue", 2015, "10-BA-10", 1000, 1000, 1000, 1000, "Gas");
        System.out.println(d);
        System.out.println(mv1);
        System.out.println(mv2);
        System.out.println(mv3);
        System.out.println(mv4);
    }
}
