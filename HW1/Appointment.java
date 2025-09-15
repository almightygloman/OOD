package HW1;
//using java.time.LocalDate since java.util.Date has a depreciated constructor
import java.time.LocalDate;
abstract class Appointment{
    private String description;
    private LocalDate date;

    public Appointment(String desc, LocalDate d){
        this.description = desc;
        this.date = d;
        //think about using exception handling to validate the date
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