import java.util.ArrayList;
public class ThemPark {

    public static int time ;
    private static EntranceTicketCounter ticketCounter = new EntranceTicketCounter();
    private static  Canteen canteen = new Canteen();
    private static ArrayList<String> overallRides = new ArrayList<>();
    private static ArrayList<Ride> availableRides = new ArrayList<>();
    private static ArrayList<Operator> operators = new ArrayList<>();
    private static  ThemPark themPark = new ThemPark();
    /**ewn*/

    private ThemPark(){
        ThemParkTime.getParkTimeInstance().startThemParkTime();
    }

    public static ThemPark getThemParkInstance(){
            return themPark;
        }

    public EntranceTicketCounter getTicketCounterInstance() {
        return ticketCounter;
    }

    public Canteen getCanteenInstance() {
        return canteen;
    }

    public void main(){
            System.out.println("--------------------------------------------------------");
            System.out.println("|                    Welcome to Theme Park                 |");
            System.out.println("--------------------------------------------------------");
            createOperator();
            canteen.createFood();
        }

    public  void configurationGame(){
        boolean result;
        int getOperator = 0;
        do {
            System.out.println("Available Game in Them park\n");
            for(int i = 0; i < overallRides.size(); i++){
                System.out.println(i+1 + ")"+overallRides.get(i));
            }
            System.out.println("Which Game you configure ?");
            int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
            availableRides.add(operators.get(getOperator).configuration(overallRides.get(option-1)));
            overallRides.remove(option-1);
            getOperator++;
            System.out.println("Would you like another game configuration ?");
            result = GeneralUtil.getInstance().isAllowRide();
        }while (result);
    }

    public  void showAvailableRides(){
        System.out.println("Today Available Rides");
        for(int i = 0; i < availableRides.size(); i++){
            System.out.println(i+1+") "+ availableRides.get(i).toString());
        }

        System.out.println("--------------------------------------------------------");
        System.out.print("Enter your Selection - ");
        int selection = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if(selection <= availableRides.size()){
            System.out.println("Your Selected Ride is  -> "+ availableRides.get(selection-1).getRideName());
            availableRides.get(selection-1).operator.operateRide(availableRides.get(selection-1));
        } else
            System.out.println("Invalid Selection");
    }

    public void showRideEarningDetails(){
        for(int i = 0; i < availableRides.size(); i++){
            System.out.println("------------------"+ availableRides.get(i).getRideName()+"------------------");
            availableRides.get(i).getTicketCounterInstance().showRideEarningDetails();
        }
    }

    static {
        overallRides.add(ThemeParkConstants.Game.ROLLER_COASTER);
        overallRides.add(ThemeParkConstants.Game.COLUMBUS);
        overallRides.add(ThemeParkConstants.Game.GIANT_WHEEL);
        overallRides.add(ThemeParkConstants.Game.RAINBOW_DRAGON);
        overallRides.add(ThemeParkConstants.Game.WATER_PENDULUM);
        overallRides.add(ThemeParkConstants.Game.WAVE_POOL);

    operators.add(new Operator("Alex"));
    operators.add(new Operator("Kamalesh"));
    operators.add(new Operator("Senthil"));
    operators.add(new Operator("Maddy"));
    operators.add(new Operator("Darshon"));
}

    private  void createOperator() {

    }
}
