import Games.*;

public class Operator {

    public Ride configuration(){
        System.out.println();
        //RollerCoaster rollerCoaster;
        System.out.println("------------------------------Game Configuration------------------------------");
        System.out.println();
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
        return  newGameCreation(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
    }

    private Ride newGameCreation(String gameName, int rideAmount, String startTime, String endTime, boolean isAllowAdult, boolean isAllowChildren, boolean isAllowSenior){
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
            System.out.println("This Game is Not Available");
            return new Ride(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
        }
    }

    private static String getString(){
        return GeneralUtil.getInstance().getString();
    }

    private static boolean isAllowRide(String category){
        System.out.println("Can "+category+" allowed the Ride ?");
        System.out.println("------------------------>  1)  Yes");
        System.out.println("------------------------>  2)  No");
        System.out.print("Enter the Option  - ");
       int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if(option == 1)
            return true;
        else
            return false;
    }
}
