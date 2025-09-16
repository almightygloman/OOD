package HW1;
import java.time.LocalDate;
public class Main {
    public static void main(String[]args){
        Onetime ot = new Onetime("tooth pulled", LocalDate.of(2025,12,26));
        Appointment monthly = new Monthly(null, LocalDate.of(2025, 11, 30));
        System.out.println(ot.occursOn(2025, 12, 26));
        System.out.println(monthly.occursOn(2025, 12, 31));
    }
}
