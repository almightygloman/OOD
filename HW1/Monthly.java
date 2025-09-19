package HW1;

import java.time.LocalDate;

public class Monthly extends Appointment{

    public Monthly(String desc, LocalDate d) {
        super(desc, d);
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        LocalDate temp = LocalDate.of(year, month, day);
        LocalDate apDate = getDate();
        //make sure the date we are checking is after/on the appointment date
        if(temp.isBefore(getDate())) return false;
        //check if the days are the last of the month if the DOTM aren't equal
        return temp.getDayOfMonth() == apDate.getDayOfMonth() || isLastDay(apDate) == isLastDay(temp);
    }

    public boolean isLastDay(LocalDate d){
        return d.getDayOfMonth() == d.getMonth().length(d.isLeapYear());
    }
    
}
