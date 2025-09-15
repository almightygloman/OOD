package HW1;
import java.time.LocalDate;
public class Daily extends Appointment {
    public Daily(String desc, LocalDate d){
        super(desc, d);
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        LocalDate temp = LocalDate.of(year, month, day);
        return getDate().isBefore(temp);
    }

}
