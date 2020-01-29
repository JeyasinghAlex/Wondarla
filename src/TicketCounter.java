import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

final class TicketCounter {

    private static TicketCounter ticketCounter = new TicketCounter();
    private  static int ticketNumber = 100;
    private TicketCounter(){

    }

    private static  ArrayList<Visitor> visitorArrayList = new ArrayList<>();
    public static TicketCounter getInstance(){
        return ticketCounter;
    }

    public void receiveTicket() {
        System.out.print("Enter your Name - ");
        String name = GeneralUtil.getInstance().getString();
        System.out.print("Enter your Age - ");
        int age = GeneralUtil.getInstance().checkAndReturnValidInteger();
        System.out.println("Gender - 1) Male");
        System.out.println("            - 2) Female");
        System.out.print("Select your Gender - ");
        int gen = GeneralUtil.getInstance().checkAndReturnValidInteger();
        String gender = "";
        if (gen == 1)
            gender = "Male";
        else
            gender = "Female";
        System.out.println("Category  - 1) Adult");
        System.out.println("                - 2) Child");
        System.out.println("                - 3) Senior");
        System.out.print("Select your Category - ");
        int cat = GeneralUtil.getInstance().checkAndReturnValidInteger();
        LocalDate date = LocalDate.now();
        //LocalTime time = LocalTime.now();
        System.out.print("What is the time Now  ? - ");
        String time = GeneralUtil.getInstance().getString();
        String category = "";
        if (cat == 1){
            category = "Adult";
            visitorArrayList.add(new Visitor(name, age, gender, category, new Ticket(++ticketNumber, category, name,  date, time)));
        }
        else if (cat == 2){
            category = "Child";
            visitorArrayList.add(new Visitor(name, age, gender, category, new Ticket(++ticketNumber, category, name, date, time)));
        }
        else{
            category = "Senior";
            visitorArrayList.add(new Visitor(name, age, gender, category, new Ticket(++ticketNumber, category, name, date, time)));
        }
    }
}
