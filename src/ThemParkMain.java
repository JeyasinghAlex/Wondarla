import java.util.ArrayList;

public class ThemParkMain {
    public static  void main(String[] args) {

        System.out.println("--------------------------------------------------------");
        System.out.println("|                    Welcome to Theme Park                 |");
        System.out.println("--------------------------------------------------------");
        EntranceTicketCounter ticketCounter = new EntranceTicketCounter();
        ArrayList<Ride> rides = new ArrayList<>();
        ArrayList<Operator> operators = new ArrayList<>();
        createOperator(operators);
        boolean result;

        int getOperator = 0;
        do {
            rides.add(operators.get(getOperator).configuration());
            String gameName = operators.get(getOperator).getHisGame();
            System.out.println(operators.get(getOperator).getOperatorName() + " Operate "+ gameName);
            getOperator++;
            result = GeneralUtil.getInstance().isAllowRide("another game Configure ");
        }while (result);


        do {
            ticketCounter.receiveTicket();
            result = GeneralUtil.getInstance().isAllowRide("another visitor ");
        }while (result);

        showAvailableRides(rides);
        Ride selectedRide =  Visitor.selectRide(rides);
        //((RollerCoaster) selectedRide).getMoney();
        selectedRide.checkTicket(operators, selectedRide);
        selectedRide.startRide(EntranceTicketCounter.visitorArrayList, selectedRide, operators);
    }

    private static void createOperator(ArrayList<Operator> operators) {
        operators.add(new Operator("Alex"));
        operators.add(new Operator("Kamalesh"));
        operators.add(new Operator("Senthil"));
        operators.add(new Operator("Luu"));
        operators.add(new Operator("Darshon"));
    }

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
