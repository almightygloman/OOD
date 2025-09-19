package HW1;
import java.time.LocalDate;
import java.util.List;
public class Main {
    public static void main(String[]args){
        AppointmentScheduler appointmentScheduler = new AppointmentScheduler();
        Appointment ot = new Onetime("root canal", LocalDate.of(2025,12,26));
        Appointment monthly = new Monthly("cleaning", LocalDate.of(2025, 11, 30));
        Appointment daily = new Daily("chemo", LocalDate.of(2025, 10, 30));
        appointmentScheduler.addAppointment(ot); 
        appointmentScheduler.addAppointment(monthly); 
        appointmentScheduler.addAppointment(daily); 

        System.out.println(ot.occursOn(2025, 12, 26));
        System.out.println(monthly.occursOn(2025, 12, 31));
        System.out.println(daily.occursOn(2025, 10, 31));

        List<Appointment> matches = appointmentScheduler.getMatches(2025, 12, 30);
        for(Appointment a : matches){
            System.out.println(a.toString());
        }
    }
}
