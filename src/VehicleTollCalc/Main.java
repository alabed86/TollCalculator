package VehicleTollCalc;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        TollCalculator tollCalculator = new TollCalculator();
        
        Car car = new Car();
        MotorBike honda = new MotorBike();

        Date[] dates = new Date[6];
        dates[0] = new Date();
        dates[1] = new Date(dates[0].getTime());
        dates[1].setDate(11);
        dates[2] = new Date(dates[1].getTime());
        dates[2].setHours(7);
        dates[3] = new Date(dates[1].getTime());
        dates[3].setHours(7);
        dates[4] = new Date(dates[1].getTime());
        dates[4].setHours(8);
        dates[5] = new Date(dates[1].getTime());
        dates[5].setHours(16);
        int carfee = tollCalculator.getTollFee(car, dates);
        int mcfee = tollCalculator.getTollFee(honda, dates);
        System.out.println("jbg933 " + carfee + "Kr");
        System.out.println("NMD358 " + mcfee + "Kr");
    }
}
