public class Operator {

    private String operatorName;
    //private String hisGame;
    public Operator(String operatorName) {
        this.operatorName = operatorName;
    }

    public Ride configuration(String gameName){
        System.out.println("\n------------------------------Game Configuration------------------------------\n");
//        System.out.print("Enter the Game Name - ");
//        String gameName = getString();

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
        //return  new Ride(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
        return newGameCreation(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
    }


        private Ride newGameCreation(String gameName, int rideAmount, String  startTime, String  endTime, boolean isAllowAdult, boolean isAllowChildren, boolean isAllowSenior) {

            switch (gameName) {
                case ThemeParkConstants.Game.ROLLER_COASTER: {
                    return new RollerCoaster(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
                }
                case ThemeParkConstants.Game.COLUMBUS: {
                    return new Columbus(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
                }
                case ThemeParkConstants.Game.GIANT_WHEEL: {
                    return new GiantWheel(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
                }
                case ThemeParkConstants.Game.RAINBOW_DRAGON: {
                    return new RainBowDragon(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
                }
                case ThemeParkConstants.Game.WATER_PENDULUM: {
                    return new WaterPendulum(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
                }
                case ThemeParkConstants.Game.WAVE_POOL: {
                    return new WavePool(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
                }
                default:{
                    return null;
                }
            }
        }
//        if (gameName.equals(ThemeParkConstants.Game.ROLLER_COASTER))
//            return new RollerCoaster(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
//        else if (gameName.equals("Columbus"))
//            return  new Columbus(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
//        else if (gameName.equals("Giant Wheel"))
//            return new GiantWheel(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
//        else if (gameName.equals("Wave Pool"))
//            return  new WavePool(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
//        else if (gameName.equals("Rain Dancing"))
//            return new RainBowDragon(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
//        else if (gameName.equals("Water Pendulum"))
//            return new WaterPendulum(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
//        else{
//            return new Ride(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior, new TicketCounter(), this);
//        }
//    }

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
            int totalAmount = ticket.calculateMoney(actualRideAmount);
           // int totalAmount = actualRideAmount + premiumAmount;
           // int returnedMoney = Visitor.getVisitorInstance(visitor, totalAmount);
            if(visitorTime < rideEndingTime && rideStartingTime <= ThemParkTime.getParkTimeInstance().getThemParkTime() && selectedRide.getCategory(visitorCategory)){
                    //int returnedMoney = Visitor.getVisitorInstance(visitor, totalAmount);
                    if(visitor.setWallet(totalAmount)){
                        selectedRide.getTicketCounterInstance().getRecordBooks().add(new RideRecordBook(ticketNumber, ticket.getHolder()));
                        selectedRide.getTicketCounterInstance().setAmount(totalAmount, selectedRide);
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
