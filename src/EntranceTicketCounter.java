import java.time.LocalDate;
import java.util.ArrayList;

public class EntranceTicketCounter {

    private  static int ticketNumber = 100;
    private int amount;
    private ArrayList<Visitor> visitors = new ArrayList<>();

    public void giveTicket() {
        System.out.print("\nEnter your Name - ");
        String name = GeneralUtil.getInstance().getString();
        System.out.println("Gender - 1) Male");
        System.out.println("            - 2) Female");
        System.out.print("Select your Gender - ");
        int gen = GeneralUtil.getInstance().checkAndReturnValidInteger();
        String gender = "";
        if (gen == 1)
            gender = "Male";
        else
            gender = "Female";
        System.out.println("Category  - 1) Adult (18 to 30)");
        System.out.println("                - 2) Child (6 to 17)");
        System.out.println("                - 3) Senior (above > 31)");
        System.out.print("Select your Category - ");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        String category = "";
        if(option == 1){
            category = "Adult";
        }else if(option == 2)
            category = "Child";
        else {
            category = "Senior";
        }
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
        Visitor visitor = null;
        if(selected == 1){
            type = "Premium";
            Premium premiumTicket = new Premium(++ticketNumber, category, name, type, date, time);
           fee = premiumTicket.calculateMoney(entryFee);
            visitor = new Visitor(name, gender, premiumTicket);
            entryFee = Visitor.getVisitorInstance(visitor, (entryFee+fee));
            if(entryFee != 0)
            visitors.add(visitor);
        } else{
            type = "General";
            General generalTicket = new General(++ticketNumber, category, name, type, date, time);
             fee = generalTicket.calculateMoney(entryFee);
             visitor = new Visitor(name, gender, generalTicket);
            entryFee = Visitor.getVisitorInstance(visitor, (entryFee + fee));
            if(entryFee != 0)
            visitors.add(visitor);
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        if(entryFee != 0){
            int ticketNumber = visitor.getTicket().getTicketNumber();//"insert into employee (id, name, age, gender, email) value('"+id+"','"+name+"',"+age+",'"+gender+"','"+email+"')";
            //DataBaseConnection.getDbInstance().getConnection("insert into visitors value('"+ticketNumber+"','"+name+"','"+age+"','"+gender+"','"+category+"','"+date+"','"+time+"')");
            System.out.println("Collect your  -  "+visitor.getTicket().toString());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------\n");
          this.amount += entryFee;
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

    public void showVisitorsDetails(){
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < visitors.size(); i++){
            System.out.println(visitors.get(i).toString());
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }

    public void getAmount() {
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("Total Earning of - Endurance Ticket Counter - "+amount);
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }
}