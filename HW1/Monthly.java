package HW1;

import java.time.LocalDate;

public class Monthly extends Appointment{

    public Monthly(String desc, LocalDate d) {
        super(desc, d);
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        LocalDate temp = LocalDate.of(year, month, day);

        //make sure the date we are checking is after/on the appointment date
        if(temp.isBefore(getDate())) return false;
        //check if the days are the last of the month
        if(temp.getDayOfMonth() == temp.getMonth().length(temp.isLeapYear()) &&
            getDate().getDayOfMonth() == getDate().getMonth().length(getDate().isLeapYear())){
                return true;
        }


        return temp.getDayOfMonth() == getDate().getDayOfMonth();
    }
    
}
