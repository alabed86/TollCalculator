package VehicleTollCalc;
import java.util.*;

public class TollCalculator {
    
    
    public int getTollFee(Vehicle vehicle, Date[] dates) {

        int prevHour = -1;
        int prevDay = -1;
        int prevYear = -1;
        Calendar currCal = Calendar.getInstance();
        int totalFee = 0;

        for (Date date : dates) {

            currCal.setTime(date);
            if((!((currCal.get(Calendar.HOUR) == prevHour) && 
                    (currCal.get(Calendar.DAY_OF_YEAR) == prevDay) && 
                    (currCal.get(Calendar.YEAR) == prevYear)))
                && (totalFee < 60))
                
                totalFee += getTollFee(date, vehicle);

            prevHour = currCal.get(Calendar.HOUR);
            prevDay = currCal.get(Calendar.DAY_OF_YEAR);
            prevYear = currCal.get(Calendar.YEAR);
        }
        if(totalFee > 60)   totalFee = 60;
        return              totalFee;
    }

    public int getTollFee(final Date date, Vehicle vehicle) {
        if(isTollFreeDate(date))
            return 0;
        else {
            //Calendar cal = Calendar.getInstance();
            //cal.setTime(date);
            //int hour = cal.get(Calendar.HOUR);
            int hour = date.getHours();
            if((hour == 8) || (hour == 16)) return 18;
            else                            return vehicle.getFee();
        }

    }

    private boolean isTollFreeDate(Date date) {

        int dayOfWeek = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        if((dayOfWeek == 1) || (dayOfWeek == 7))    return true;
        else                                        return false;
    }

}