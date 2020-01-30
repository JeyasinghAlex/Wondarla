import java.util.ArrayList;
import Games.*;

public class Main {
    public static  void main(String[] args) {

        ArrayList<Ride> rides = new ArrayList<>();
        System.out.println("--------------------------------------------------------");
        System.out.println("|                    Welcome to Theme Park                 |");
        System.out.println("--------------------------------------------------------");
        boolean result;

        do {
            rides.add(new Operator().configuration());
            result = GeneralUtil.getInstance().isAllowRide("another game Configure ");
        }while (result);

        do {
            TicketCounter.getInstance().receiveTicket();
            result = GeneralUtil.getInstance().isAllowRide("another visitor ");
        }while (result);
        ThemParkConstance.showAvailableRides(rides);
        RollerCoaster selectedRide = (RollerCoaster) Visitor.selectRide(rides);
    }
}
