import Games.Ride;

import java.util.ArrayList;

public class ThemParkConstance {

    public static void showAvailableRides(ArrayList<Ride> rides){
        System.out.println("--------------------------------------------------------");
        System.out.println("Today Available Rides");
        for(int selectedRide = 0; selectedRide < rides.size(); selectedRide++){
            System.out.println(selectedRide+1+") "+rides.get(selectedRide).toString());
        }
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }
}

