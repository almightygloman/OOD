package HW1;
//using java.time.LocalDate since java.util.Date has a depreciated constructor
import java.time.LocalDate;
abstract class Appointment{
    private String description;
    private String name;
    private LocalDate date;
    private LocalDate created;
    private int appointmentID;

    public Appointment(String desc, LocalDate d){
        this.description = desc;
        this.date = d;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String desc){
        this.description = desc;
    }

    public LocalDate getDate(){
        return this.date;
    }
    public void setDate(LocalDate d){
        this.date = d;
    }
    public abstract boolean occursOn(int year, int month, int day);

}