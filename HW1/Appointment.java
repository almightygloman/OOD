package HW1;
//using java.time.LocalDate since java.util.Date has a depreciated constructor
import java.time.DateTimeException;
import java.time.LocalDate;
//Using abstract class so subclasses can inherit concrete methods while implementing their own occursOn
abstract class Appointment{
    private String description;
    private LocalDate date;

    public Appointment(String desc, LocalDate d) throws DateTimeException{
        if (desc == null) throw new IllegalArgumentException("Description cannot be null");
        this.description = desc;
        //ensure date is valid, throw exception if not
        if (d == null) throw new IllegalArgumentException("Date cannot be null");
        try {
            this.date = d;
        } catch (DateTimeException e) {
            System.out.println("invalid date/format");
        }
    }

    //concrete getters and setters, since subclasses will not have differing needs for these functions
    public String getDescription(){
        return description;
    }
    public void setDescription(String desc){
        if (desc == null) throw new IllegalArgumentException("Description cannot be null");
        this.description = desc;
    }
    public LocalDate getDate(){
        return this.date;
    }
    public void setDate(LocalDate d){
        if (d == null) throw new IllegalArgumentException("Date cannot be null");
        this.date = d;
    }
    @Override
    public String toString(){
        return getDate().toString() + " " + getDescription();
    }

    //abstract method for inheriting subclasses to have different logic
    public abstract boolean occursOn(int year, int month, int day);

}