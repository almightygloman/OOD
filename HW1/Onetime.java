package HW1;

import java.time.LocalDate;

class Onetime extends Appointment{

    public Onetime(String desc, LocalDate d) {
        super(desc, d);
    }
    //all fields must match
    @Override
    public boolean occursOn(int year, int month, int day) {
        LocalDate temp = LocalDate.of(year,month,day);
        return getDate().equals(temp);
    }
}
