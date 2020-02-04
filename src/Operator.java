public class Operator {

    private String operatorName;
    private String hisGame;

    public Operator(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorName(){
        return this.operatorName;
    }

    public String getHisGame(){
        return this.hisGame;
    }

    public  Ride configuration(){
        System.out.println();
        System.out.println("------------------------------Game Configuration------------------------------");
        System.out.println();
        System.out.print("Enter the Game Name - ");
        String gameName = getString();
        this.hisGame = gameName;
        System.out.print("Enter the Ride Amount - ");
        int rideAmount = GeneralUtil.getInstance().checkAndReturnValidInteger();
        System.out.print("Enter the Game Start Time - ");
        String startTime = getString();
        System.out.print("Enter the Game End Time - ");
        String endTime = getString();
        boolean isAllowAdult = isAllowRide("Adult");
        boolean isAllowChildren = isAllowRide("Children");
        boolean isAllowSenior = isAllowRide("Senior");
        System.out.println(this.operatorName+ " Operate "+ this.getHisGame());
        return  new Ride(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
    }

//    private Ride newGameCreation(String gameName, int rideAmount, int startTime, int endTime, boolean isAllowAdult, boolean isAllowChildren, boolean isAllowSenior){
//        if (gameName.equals("Roller Coaster"))
//            return new RollerCoaster(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
//        else if (gameName.equals("Columbus"))
//            return  new Columbus(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
//        else if (gameName.equals("Giant Wheel"))
//            return new GiantWheel(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
//        else if (gameName.equals("Wave Pool"))
//            return  new WavePool(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
//        else if (gameName.equals("Rain Dancing"))
//            return new RainDancing(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
//        else if (gameName.equals("Water Pendulum"))
//            return new WaterPendulum(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
//        else{
//            //System.out.println("This Game is Not Available");
//            return new Ride(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
//        }
//    }


    public void startRide(Ride selectedRide){
        System.out.print("Enter your Ticket Number - ");
        int ticketNumber = GeneralUtil.getInstance().checkAndReturnValidInteger();
        Visitor visitor = ThemPark.getThemParkInstance().ticketCounter.searchVisitors(ticketNumber);

        if(visitor != null){
            int visitorTime = visitor.getTime();
            String visitorCategory = visitor.getTicket().getCategory();
            int rideStartingTime = selectedRide.getStartTime();

            if(visitorTime <= rideStartingTime && selectedRide.getCategory(visitorCategory)){
                int returnedMoney =visitor.requestMoney(selectedRide.getAmount());
                if(returnedMoney !=0){
                    selectedRide.ticketCounter.recordBooks.add(new RideRecordBook(ticketNumber, visitor.getName()));
                    selectedRide.ticketCounter.setAmount(returnedMoney, selectedRide);
                    System.out.println("---------------Successfully Ride Completed--------------------");
                    visitor.setTime(rideStartingTime);
                } else
                    System.out.println("--------------- Ride cancelled--------------------");
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
