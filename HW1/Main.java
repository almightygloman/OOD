package HW1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.time.DateTimeException;

public class Main {

    //given input file with appointments split by commas
    public static void main(String[] args) throws IOException {
        AppointmentScheduler scheduler = new AppointmentScheduler();
        Scanner sc = new Scanner(System.in);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("HW1/input.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                String type = values[0].toUpperCase();
                String desc = values[1];
                LocalDate date = LocalDate.parse(values[2]);

                switch (type) {
                    case "ONETIME" ->
                        scheduler.addAppointment(new Onetime(desc, date));
                    case "DAILY" ->
                        scheduler.addAppointment(new Daily(desc, date));
                    case "MONTHLY" ->
                        scheduler.addAppointment(new Monthly(desc, date));
                }
            }
            //test scheduler
            List<Appointment> matches = scheduler.getMatches(2025, 12, 30);
            for (Appointment apt : matches) {
                System.out.println(apt.toString());
            }
        }
        //loop for user to add appointments and check the schedule for dates
        while (true) {
            System.out.println("Enter a date in format(YYYY-MM-DD) to check if you have an appointment on that day");
            System.out.println("Enter \"add\" to add an appointment to your schedule");
            System.out.println("Enter \"exit\" to quit");
            String input = sc.nextLine();

            //handle adding appointments to schedule
            if (input.toLowerCase().equals("add")) {
                System.out.println("Enter the type of appointment (Onetime, Daily, Monthly)");
                String t = sc.nextLine().toUpperCase();
                if(!validType(t)){
                    System.out.println("invalid type");
                    continue;
                }

                System.out.println("Enter a description for the appointment");
                String des = sc.nextLine();
                System.out.println("Enter the date of the appointment in the format of (YYYY-MM-DD)");
                String dateStr = sc.nextLine();
    
                if(!validDate(dateStr)){
                    System.out.println("invalid date");
                    continue;
                } 

                LocalDate date = LocalDate.parse(dateStr);
               
                switch (t) {
                    case "ONETIME" ->{
                        scheduler.addAppointment(new Onetime(des, date));
                        System.out.println("Appointmet added successfully");
                    }
                    case "DAILY" ->{
                        scheduler.addAppointment(new Daily(des, date));
                        System.out.println("Appointmet added successfully");
                    }
                    case "MONTHLY" ->{
                        scheduler.addAppointment(new Monthly(des, date));
                        System.out.println("Appointmet added successfully");
                    }
                    default -> System.out.println("invalid appointment type");
                }

            } else if (input.toLowerCase().equals("exit")) {
                System.out.println("smell ya later");
                sc.close();
                break;

            } else if(validDate(input)){
                    System.out.println("\nHere are the appointments on " + input);
                    LocalDate check = LocalDate.parse(input);
                    List<Appointment> m = scheduler.getMatches(check.getYear(), check.getMonthValue(), check.getDayOfMonth());
                    for(Appointment apt: m){
                        System.out.println(apt.toString());
                    }
            } else{
                System.out.println("invalid input, enter \"add\", \"exit\" or a formatted date (YYYY-MM-DD)");
            }
        }
    }
    private static boolean validDate(String in){
        try {
            LocalDate.parse(in);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }
    private static boolean validType(String type){
        String[]types = {"ONETIME","DAILY","MONTHLY"};
        boolean temp = false;
        for(String str : types){
            if(type.equals(str)) temp = true;
        }
        return temp;
    }
}
