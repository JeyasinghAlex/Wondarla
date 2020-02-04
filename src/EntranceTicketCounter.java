import java.time.LocalDate;
import java.util.ArrayList;

public class EntranceTicketCounter {

    private  static int ticketNumber = 100;
    private int amount;
    private ArrayList<Visitor> visitors = new ArrayList<>();

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
        System.out.println("Ticket Type  - 1) Premium");
        System.out.println("                        2) General");
        System.out.print("Select your Type - ");
        String type = "";
        if(GeneralUtil.getInstance().checkAndReturnValidInteger() == 1){
            type = "Premium";
            int amount = visitors.get(visitors.size() - 1).requestMoney(50);
            this.amount += amount;
        }
        else{
            type = "General";
            int amount = visitors.get(visitors.size() - 1).requestMoney(50);
            this.amount += amount;
        }

        String category = "";
        if (cat == 1){
            category = "Adult";
            visitors.add(new Visitor(name, age, gender, category, new Ticket(++ticketNumber, category, name, type,  date, time ), time));
        }
        else if (cat == 2){
            category = "Child";
            visitors.add(new Visitor(name, age, gender, category, new Ticket(++ticketNumber, category, name, type, date,  time), time));
        }
        else{
            category = "Senior";
            visitors.add(new Visitor(name, age, gender, category, new Ticket(++ticketNumber, category, name, type, date, time), time));
        }
    }

    public Visitor searchVisitors(int ticketNumber){
        for(int i = 0; i < visitors.size(); i++){
                if(visitors.get(i).getTicket().getTicketNumber() == ticketNumber){
                    return visitors.get(i);
                }
        }
        return null;
    }


    public  void checkWallet(){
        for(int i = 0; i < visitors.size(); i++){
            System.out.println("Ticket Number ("+visitors.get(i).getTicket().getTicketNumber() + ") Available balance is - " +visitors.get(i).getWallet());
        }
        Main.showMenu();
    }


    public  void printVisitorDetails() {
        for (int i = 0; i < visitors.size(); i++) {
            System.out.println(visitors.get(i).toString());
        }
        Main.showMenu();
    }

    public void getEntranceAmount(){
        System.out.println(this.amount);
    }
}
