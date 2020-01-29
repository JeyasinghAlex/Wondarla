import java.util.ArrayList;

public class Operator {

    public Ride configuration(){
        System.out.println();
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
        return new Ride(gameName, rideAmount, startTime, endTime, isAllowAdult, isAllowChildren, isAllowSenior);
    }

    private String getString(){
        return GeneralUtil.getInstance().getString();
    }

    private boolean isAllowRide(String category){
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
