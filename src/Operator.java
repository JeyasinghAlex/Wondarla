public class Operator {

    private String operatorName;
    private String hisGame;
    private OperatorTicketCounter ticketCounter;

    public Operator(String operatorName) {
        this.operatorName = operatorName;
        ticketCounter = new OperatorTicketCounter();
    }


    public String getOperatorName(){
        return this.operatorName;
    }

    public String getHisGame(){
        return this.hisGame;
    }

    public void setHisGame(String hisGame){
        this.hisGame = hisGame;
    }

    public OperatorTicketCounter getTicketCounter() {
        return this.ticketCounter;
    }

    public  Ride configuration(){
        System.out.println();
        System.out.println("------------------------------Game Configuration------------------------------");
        System.out.println();
        System.out.print("Enter the Game Name - ");
        String gameName = getString();
        setHisGame(gameName);
        System.out.print("Enter the Ride Amount - ");
        int rideAmount = GeneralUtil.getInstance().checkAndReturnValidInteger();
        System.out.print("Enter the Game Start Time - ");
        String startTime = getString();
        System.out.print("Enter the Game End Time - ");
        String endTime = getString();
        boolean isAllowAdult = isAllowRide("Adult");
        boolean isAllowChildren = isAllowRide("Children");
        boolean isAllowSenior = isAllowRide("Senior");
        return  newGameCreation(gameName, rideAmount, Integer.parseInt(startTime), Integer.parseInt(endTime), isAllowAdult, isAllowChildren, isAllowSenior);
    }

    private Ride newGameCreation(String gameName, int rideAmount, int startTime, int endTime, boolean isAllowAdult, boolean isAllowChildren, boolean isAllowSenior){
        if (gameName.equals("Roller Coaster"))
            return new RollerCoaster(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
        else if (gameName.equals("Columbus"))
            return  new Columbus(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
        else if (gameName.equals("Giant Wheel"))
            return new GiantWheel(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
        else if (gameName.equals("Wave Pool"))
            return  new WavePool(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
        else if (gameName.equals("Rain Dancing"))
            return new RainDancing(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
        else if (gameName.equals("Water Pendulum"))
            return new WaterPendulum(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
        else{
            //System.out.println("This Game is Not Available");
            return new Ride(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
        }
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
