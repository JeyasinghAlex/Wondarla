public class Operator {

    private String operatorName;
    public Operator(String operatorName) {
        this.operatorName = operatorName;
    }

    public Ride configuration(){
        System.out.println("\n------------------------------Game Configuration------------------------------\n");
        System.out.print("Enter the Game Name - ");
        String gameName = getString();
        System.out.print("Enter the Ride Amount - ");
        int rideAmount = GeneralUtil.getInstance().checkAndReturnValidInteger();
        System.out.print("Enter the Game Start Time - ");
        String startTime = getString();
        System.out.print("Enter the Game End Time - ");
        String endTime = getString();
        boolean isAllowAdult = isAllowRide("Adult");
        boolean isAllowChildren = isAllowRide("Children");
        boolean isAllowSenior = isAllowRide("Senior");
        System.out.println(this.operatorName+ " Operate "+ gameName);
        return  new Ride(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
    }

    public void operateRide(Ride selectedRide){
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
            int premiumAmount = ticket.calculateMoney(actualRideAmount);
            int totalAmount = actualRideAmount + premiumAmount;
            if(visitorTime < rideEndingTime && selectedRide.getCategory(visitorCategory)){
                int returnedMoney = Visitor.getVisitorInstance(visitor, totalAmount);
                if(returnedMoney !=0){
                    // selectedRide.ticketCounter.recordBooks.add(new RideRecordBook(ticketNumber, ticket.getHolder()));
                    selectedRide.getTicketCounterInstance().setAmount(returnedMoney, selectedRide);
                    System.out.println("---------------Successfully Ride Completed--------------------");
                        ticket.setTime(rideStartingTime);
                } else
                    System.out.println("--------------- Ride cancelled (Due to insufficient balance for this ride)--------------------");
            }else
                System.out.println("You are not eligible for the game or May be yours late");
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
        if(option == 1)
            return true;
        else
            return false;
    }
}
