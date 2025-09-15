package HW1;
import java.time.LocalDate;
public class Main {
    public static void main(String[]args){
        Onetime ot = new Onetime("tooth pulled", LocalDate.of(2025,12,25));
        System.out.println(ot.occursOn(2025, 12, 26));
    }
}
