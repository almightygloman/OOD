package HW1;
import java.util.LinkedList;
import java.util.List;
class AppointmentScheduler {
    private final List<Appointment>appointments;

    public AppointmentScheduler(){
        //using Linked list for constant time appending
        this.appointments = new LinkedList<>();
    }
    //allow adding to private list
    public void addAppointment(Appointment apt){
        if (apt == null) throw new IllegalArgumentException("Appointment cannot be null");
        appointments.add(apt);
    }

    //return list of appointments which occur on a given date
    public List<Appointment> getMatches(int year, int month, int day){
        List<Appointment>matches = new LinkedList<>();
        for(Appointment apt:appointments){
            if(apt.occursOn(year, month, day)) matches.add(apt);
        }
        if(matches.isEmpty()) System.out.println("No appointments on this date");
        return matches;
    }
}
