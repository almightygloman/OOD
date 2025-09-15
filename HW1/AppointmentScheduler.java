package HW1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class AppointmentScheduler {
    private final List<Appointment>appointments;

    public AppointmentScheduler(){
        this.appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment apt){
        appointments.add(apt);
    }
    public List<Appointment> getMatches(int year, int month, int day){
        List<Appointment>matches = new LinkedList<>();
        for(Appointment apt:appointments){
            if(apt.occursOn(year, month, day)) matches.add(apt);
        }
        return matches;
    }
}
