import java.util.ArrayList;

public class Ride {

    protected String rideName;
    protected int amount;
    protected int startTime;
    protected int endTime;
    protected boolean adult;
    protected boolean children;
    protected boolean senior;
    Operator operator = null;

    public Ride(String rideName, int amount, int startTime, int endTime, boolean adult, boolean children, boolean senior) {
        this.rideName = rideName;
        this.amount = amount;
        this.startTime = startTime;
        this.endTime = endTime;
        this.adult = adult;
        this.children = children;
        this.senior = senior;
    }

    public String getRideName(){
        return this.rideName;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getCategory(String category){
        if(category .equals("Adult"))
            return this.adult;
        else if(category.equals("Children"))
            return this.children;
        else
            return this.senior;
    }

    public Operator checkTicket(ArrayList<Operator> operators, Ride selectedRide){
        for(int i = 0; i < operators.size(); i++){
            if(selectedRide.getRideName().equals(operators.get(i).getHisGame())){
             return   operator =  operators.get(i);
            }
        }
       return operator;
    }

    public void startRide(ArrayList<Visitor> visitors, Ride selectedRide, ArrayList<Operator> operators){
        boolean result = false;
        Operator operator = checkTicket(operators, selectedRide);
        System.out.print("Enter your Ticket Number - ");
        int ticketNumber = GeneralUtil.getInstance().checkAndReturnValidInteger();
        for(int i = 0; i < visitors.size(); i++){
            int visitorTicket = visitors.get(i).getTicket().getTicketNumber();
            int visitorTime = visitors.get(i).getTime();
            int rideStartingTime = selectedRide.getStartTime();
            String visitorCategory = visitors.get(i).getTicket().getCategory();
            if(visitorTicket == ticketNumber && visitorTime <= rideStartingTime && selectedRide.getCategory(visitorCategory)){
                visitors.get(i).setWallet(selectedRide.getAmount());
                visitors.get(i).setTime(rideStartingTime);
                operator.getTicketCounter().recordBooks.add(new OperatorRecordBook(ticketNumber, visitors.get(i).getName()));
                operator.getTicketCounter().setAmount(selectedRide.getAmount(), operator);
                System.out.println("---------------Successfully Ride Completed--------------------");
                result = true;
                break;
            }
        }
        if(!result)
            System.out.println("You are not eligible for the game....May be yours late or wrong ticket");
    }

    @Override
    public String toString() {
        return "Ride { " +
                " rideName = '" + rideName + '\'' +
                ", amount = " + amount +
                ", startTime = '" + startTime + '\'' +
                ", endTime = '" + endTime + '\'' +
                ", adult = " + adult +
                ", child = " + children +
                ", senior = " + senior +
                "}";
    }
}
