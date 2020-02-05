

public class Ride {

    protected String rideName;
    protected int amount;
    protected int startTime;
    protected int endTime;
    protected boolean adult;
    protected boolean children;
    protected boolean senior;
    protected Operator operator;
    protected TicketCounter ticketCounter;

    public Ride(String rideName, int amount, int startTime, int endTime, boolean adult, boolean children, boolean senior, TicketCounter ticketCounter, Operator operator) {
        this.rideName = rideName;
        this.amount = amount;
        this.startTime = startTime;
        this.endTime = endTime;
        this.adult = adult;
        this.children = children;
        this.senior = senior;
        this.ticketCounter = ticketCounter;
        this.operator = operator;
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


//    public void startRide(Ride selectedRide){
//        System.out.print("Enter your Ticket Number - ");
//        int ticketNumber = GeneralUtil.getInstance().checkAndReturnValidInteger();
//        Visitor visitor = ThemPark.getThemParkInstance().ticketCounter.searchVisitors(ticketNumber);
//
//        if(visitor != null){
//            int visitorTime = visitor.getTime();
//            String visitorCategory = visitor.getTicket().getCategory();
//            int rideStartingTime = selectedRide.getStartTime();
//
//            if(visitorTime <= rideStartingTime && selectedRide.getCategory(visitorCategory)){
//                int returnedMoney =visitor.requestMoney(selectedRide.getAmount());
//                if(returnedMoney !=0){
//                    selectedRide.ticketCounter.recordBooks.add(new RideRecordBook(ticketNumber, visitor.getName()));
//                    selectedRide.ticketCounter.setAmount(returnedMoney, selectedRide);
//                    System.out.println("---------------Successfully Ride Completed--------------------");
//                    visitor.setTime(rideStartingTime);
//                } else
//                    System.out.println("--------------- Ride cancelled--------------------");
//            }else
//                System.out.println("You are not eligible for the game or May be yours late");
//        }else
//            System.out.println("Wrong Ticket Number");
//    }

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
