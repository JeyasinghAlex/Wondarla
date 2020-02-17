public class Operator {

    private String operatorName;
    //private String hisGame;
    public Operator(String operatorName) {
        this.operatorName = operatorName;
    }

    public void configuration(Ride selectedRide){
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
        selectedRide.setOperator(this);
        selectedRide.setConfigure(true);
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
                        VisitorDao.InsertVisitorToRideDetails(VisitorDao.getVisitorId(ticketNumber), rideId, ThemParkTime.getParkTimeInstance().getThemParkTime(),  totalAmount);
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
