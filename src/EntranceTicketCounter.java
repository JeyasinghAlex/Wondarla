import java.time.LocalDate;
import java.util.ArrayList;

public class EntranceTicketCounter {

    private  static int ticketNumber = 100;
    private int amount;
    public ArrayList<Visitor> visitorArrayList = new ArrayList<>();

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
        int time = Integer.parseInt(GeneralUtil.getInstance().getString());
        String category = "";
        if (cat == 1){
            category = "Adult";
            visitorArrayList.add(new Visitor(name, age, gender, category, new Ticket(++ticketNumber, category, name,  date, time ), time));
        }
        else if (cat == 2){
            category = "Child";
            visitorArrayList.add(new Visitor(name, age, gender, category, new Ticket(++ticketNumber, category, name, date,  time), time));
        }
        else{
            category = "Senior";
            visitorArrayList.add(new Visitor(name, age, gender, category, new Ticket(++ticketNumber, category, name, date, time), time));
        }
        visitorArrayList.get(visitorArrayList.size() - 1).setWallet(30);
        this.amount += 30;
    }

    public void getEntranceAmount(){
        System.out.println(this.amount);
    }

}
