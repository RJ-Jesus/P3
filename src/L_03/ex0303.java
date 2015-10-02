package L_03;

import L_03.lect3.*;
import rjj.util.Date;

public class ex0303 {
    public static void main(String[] args) {
        Driver d = new Driver("Vin Diesel", 0, new Date(1, 1, 2000), Driver.License.valueOf("A"));
        MotorVehicle mv1 = new Car(500, 560, 5, 1000);
        MotorVehicle mv2 = new Motorcycle(500, 560, 1, 300);
        MotorVehicle mv3 = new GoodsVehicle(500, 560, 2, 2500, "Oil");
        MotorVehicle mv4 = new PassengersVehicle(500, 560, 40, 3000);
        System.out.println(d);
        System.out.println(mv1);
        System.out.println(mv2);
        System.out.println(mv3);
        System.out.println(mv4);
    }
}
