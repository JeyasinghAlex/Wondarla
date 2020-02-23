public class Operator {

    private String operatorName;
    private int operatorId;
    private String hisGame;
    private int credits;
    private boolean isAvailable;


    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public Operator(String operatorName, int operatorId) {
        this.operatorName = operatorName;
        this.operatorId = operatorId;
    }

    public void setCredits(int credits) {
        this.credits += credits;
    }

    public int getCredits() {
        return credits;
    }

    public void setHisGame(String hisGame) {
        this.hisGame = hisGame;
    }

    public String getHisGame() {
        return hisGame;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void configuration(Ride selectedRide, int rideId){
        System.out.println("\n------------------------------  "+ selectedRide.getRideName()+" - Game Configuration------------------------------\n");
        System.out.print("Enter the Ride Amount - ");
        selectedRide.setAmount(GeneralUtil.getInstance().checkAndReturnValidInteger());
        System.out.print("Enter the Game Start Time - ");
        selectedRide.setStartTime(Integer.parseInt(getString()));
        System.out.print("Enter the Game End Time - ");
        selectedRide.setEndTime(Integer.parseInt(getString()));
        selectedRide.setAllowAdult(isAllowRide("Adult"));
        selectedRide.setAllowChildren(isAllowRide("Children"));
        selectedRide.setAllowSenior(isAllowRide("Senior"));

        /** Operator Configure */
        selectedRide.setOperator(this);
        setHisGame(selectedRide.getRideName());
        setAvailable(true);
        setCredits(1);

        selectedRide.setConfigure(true, rideId, this.getOperatorId());
        System.out.println(this.operatorName+ " Operate "+ selectedRide.getRideName());
    }

    public void operateRide(Ride selectedRide, int rideId){
        System.out.print("Enter your Ticket Number - ");
        int ticketNumber = GeneralUtil.getInstance().checkAndReturnValidInteger();
        Visitor visitor = ThemPark.getThemParkInstance().getTicketCounterInstance().searchVisitors(ticketNumber);
        if(visitor != null){
            Ticket ticket = visitor.getTicket();
            float visitorTime = ticket.getTime();
            String visitorCategory = ticket.getCategory();
            int rideStartingTime = selectedRide.getStartTime();
            int rideEndingTime = selectedRide.getEndTime();
            int actualRideAmount = selectedRide.getAmount();
            int totalAmount = ticket.calculateMoney(actualRideAmount);
            if(visitorTime < rideEndingTime && rideStartingTime <= ThemParkTime.getParkTimeInstance().getThemParkTime() && selectedRide.getCategory(visitorCategory)){
                if(visitor.setWallet(totalAmount)){
                    //selectedRide.getTicketCounterInstance().getRecordBooks().add(new RideRecordBook(ticketNumber, ticket.getHolder()));
                    selectedRide.getTicketCounterInstance().addRecordInRecordBook(ticketNumber, ticket.getHolder());
                    selectedRide.getTicketCounterInstance().setAmount(totalAmount, selectedRide);
                    /** DB Connection */
                    VisitorDao.getVisitorDaoInstance().InsertVisitorToRideDetails(VisitorDao.getVisitorDaoInstance().getVisitorId(ticketNumber), rideId, ThemParkTime.getParkTimeInstance().getThemParkTime(),  totalAmount);
                    System.out.println("---------------Successfully Ride Completed--------------------");
                    ticket.setTime(rideStartingTime);
                }else
                    System.out.println("Ride Cancelled due to insufficient balance");
            }else
                System.out.println("You are not eligible for the game (or) Still Ride is not start (or) May be yours late");
        }else
            System.out.println("Wrong Ticket Number");
    }

    private static String getString(){
        return GeneralUtil.getInstance().getString();
    }

    private static boolean isAllowRide(String category){
        System.out.println("\nCan "+category+" allowed the Ride ?");
        System.out.println("------------------------>  1)  Yes");
        System.out.println("------------------------>  2)  No\n");
        System.out.print("Enter the Option  - ");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if (option == 1)
            return true;
        else
            return false;
    }
}
