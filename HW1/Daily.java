package HW1;
import java.time.LocalDate;
class Daily extends Appointment {
    public Daily(String desc, LocalDate d){
        super(desc, d);
    }
    //check if the temp date is on or after the appointment date and if its more than a month out
    @Override
    public boolean occursOn(int year, int month, int day) {
        LocalDate temp = LocalDate.of(year, month, day);
        return !getDate().isAfter(temp) && !temp.isAfter(getDate().plusMonths(1));
    }

}
