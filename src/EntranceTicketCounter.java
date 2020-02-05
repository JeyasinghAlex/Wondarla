import java.time.LocalDate;
import java.util.ArrayList;

public class EntranceTicketCounter {

    private  static int ticketNumber = 100;
    private int amount;
    private ArrayList<Visitor> visitors = new ArrayList<>();

    public void giveTicket() {
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
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        String category = "";
        if(option == 1){
            category = "Adult";
        }else if(option == 2)
            category = "Child";
        else
            category = "Senior";
        LocalDate date = LocalDate.now();
        System.out.print("What is the time Now  ? - ");
        int time = Integer.parseInt(GeneralUtil.getInstance().getString());
        System.out.println("Ticket Type  - 1) Premium");
        System.out.println("                        2) General");
        System.out.print("Select your Type - ");
        int selected = GeneralUtil.getInstance().checkAndReturnValidInteger();
        String type = "";
        int entryFee = 30;
        int fee = 0;
        if(selected == 1){
            type = "Premium";
            Premium premiumTicket = new Premium(++ticketNumber, category, name, type, date, time);
           fee = premiumTicket.calculateMoney(entryFee);
            visitors.add(new Visitor(name, age, gender, premiumTicket));
        } else{
            type = "General";
            General generalTicket = new General(++ticketNumber, category, name, type, date, time);
            visitors.add(new Visitor(name, age, gender, generalTicket));
        }
        int receiveAmount = Visitor.getVisitorInstance(visitors.get(visitors.size()-1), (entryFee+fee));
        this.amount += receiveAmount;
        System.out.println("Would you like another visitor registration ?");
        boolean result = GeneralUtil.getInstance().isAllowRide();
        if(result)
            giveTicket();
    }

    public Visitor searchVisitors(int ticketNumber){
        for(int i = 0; i < visitors.size(); i++){
                if(visitors.get(i).getTicket().getTicketNumber() == ticketNumber){
                    return visitors.get(i);
                }
        }
        return null;
    }
}
