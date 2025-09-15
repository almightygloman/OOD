package HW1;

import java.time.LocalDate;

public class Monthly extends Appointment{

    public Monthly(String desc, LocalDate d) {
        super(desc, d);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
