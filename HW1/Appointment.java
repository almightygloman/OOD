package HW1;
//using java.time.LocalDate since java.util.Date has a depreciated constructor
import java.time.DateTimeException;
import java.time.LocalDate;
abstract class Appointment{
    private String description;
    private LocalDate date;

    public Appointment(String desc, LocalDate d) throws DateTimeException{
        this.description = desc;
        //ensure date is valid, throw exception if not
        try {
            this.date = d;
        } catch (DateTimeException e) {
            System.out.println(e.getMessage());
            System.out.println("invalid date/format");
        }
    }

    //concrete getters and setters, since subclasses will not have differing needs for these functions
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
    @Override
    public String toString(){
        return getDate().toString() + " " + getDescription();
    }

    //abstract method for inheriting subclasses to have different logic
    public abstract boolean occursOn(int year, int month, int day);

}