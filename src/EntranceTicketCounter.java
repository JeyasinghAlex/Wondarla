import java.time.LocalDate;
import java.util.ArrayList;

public class EntranceTicketCounter {

    private  static int ticketNumber = 100;
    private int amount;
    private ArrayList<Visitor> visitors = new ArrayList<>();

    public void giveTicket()  {
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
       // System.out.print("What is the time Now  ? - ");
       // int time = Integer.parseInt(GeneralUtil.getInstance().getString());
        float time = ThemParkTime.getParkTimeInstance().getThemParkTime();
        System.out.println("Ticket Type  - 1) Premium");
        System.out.println("                        2) General");
        System.out.print("Select your Type - ");
        int selected = GeneralUtil.getInstance().checkAndReturnValidInteger();
        String type = "";
        int entryFee = 30;
        int entranceTicketAmount = 0;
        Visitor visitor = null;
        if (selected == 1){
            type = "Premium";
            Premium premiumTicket = new Premium(++ticketNumber, category, name, type, date, time);
           entranceTicketAmount = premiumTicket.calculateMoney(entryFee);
            visitor = new Visitor(name, gender, premiumTicket);
            //entryFee = Visitor.getVisitorInstance(visitor, (entryFee+entranceTicketAmount));
        } else{
            type = "General";
            General generalTicket = new General(++ticketNumber, category, name, type, date, time);
             entranceTicketAmount = generalTicket.calculateMoney(entryFee);
             visitor = new Visitor(name, gender, generalTicket);
            //entryFee = Visitor.getVisitorInstance(visitor, (entryFee + entranceTicketAmount));
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        if( visitor.setWallet(entranceTicketAmount)){
            visitors.add(visitor);
            /** DB Connections */
           int visitorId =  VisitorDao.insertVisitorDetails(name, gender, category, time);
            int ticketId = TicketDao.insertTicketDetails(ticketNumber, type);
            VisitorDao.insertVisitorToTicketRelation(visitorId, ticketId);
           // DataBaseConnection.getDbInstance().getConnection().createStatement().executeUpdate("insert into visitors(name, gender, category, date, time) value('"+name+"','"+gender+"','"+category+"','"+date+"','"+time+"')");
           // DataBaseConnection.getDbInstance().getConnection().createStatement().executeUpdate("insert into visitors(visitor_name, visitor_gender, visitor_category, visitor_credits) value('"+name+"','"+gender+"','"+category+"','"+1000+"')");
            System.out.println("Collect your  -  "+visitor.getTicket().toString());
            this.amount += entryFee;
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------\n");
        System.out.println("Would you like another visitor registration ?");
        boolean result = GeneralUtil.getInstance().isAllowRide();
        if(result)
            giveTicket();
    }

    public Visitor searchVisitors(int ticketNumber)  {
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