import java.util.ArrayList;
public class ThemPark {

    public static int time ;
    private static EntranceTicketCounter ticketCounter = new EntranceTicketCounter();
    private static  Canteen canteen = new Canteen();
    private static ArrayList<Ride> rides = new ArrayList<>();
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
    private int getOperator = 0;
    public  void configurationGame(){
            System.out.println("Available Game in Them park\n");
            for(int i = 0; i < rides.size(); i++){
                if(!(rides.get(i).getConfigure())){
                    System.out.println(i+1 + ")"+ rides.get(i).getRideName());
                }
            }

            System.out.println("Which Game you configure ?");
            int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
            if(!rides.get(option-1).getConfigure()){
                operators.get(getOperator++).configuration(rides.get(option-1));
            }else {
                System.out.println("Already this game is configure is completed");
            }
            System.out.println("Would you like another game configuration ?");
            if(GeneralUtil.getInstance().isAllowRide()){
                configurationGame();
            }
    }

    public  void showAvailableRides(){
        System.out.println("Today Available Rides");
        for(int i = 0; i < rides.size(); i++){
            if(rides.get(i).getConfigure()){
                System.out.println(i+1 + ")"+ rides.get(i).getRideName());
            }
        }

        System.out.println("--------------------------------------------------------");
        System.out.print("Enter your Selection - ");
        int selection = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if(selection <= rides.size()){
            System.out.println("Your Selected Ride is  -> "+ rides.get(selection-1).getRideName());
            rides.get(selection-1).operator.operateRide(rides.get(selection-1));
        } else
            System.out.println("Invalid Selection");
    }

    public void showRideEarningDetails(){
        for(int i = 0; i < rides.size(); i++){
            System.out.println("------------------"+ rides.get(i).getRideName()+"------------------");
            rides.get(i).getTicketCounterInstance().showRideEarningDetails();
        }
    }

    static {
    operators.add(new Operator("Alex"));
    operators.add(new Operator("Kamalesh"));
    operators.add(new Operator("Senthil"));
    operators.add(new Operator("Maddy"));
    operators.add(new Operator("Darshon"));

    rides.add(new RollerCoaster(ThemeParkConstants.Game.ROLLER_COASTER,  0, 0, 0, false, false,  false, new TicketCounter(), null, false));
    rides.add(new Columbus(ThemeParkConstants.Game.COLUMBUS,  0, 0, 0, false, false,  false, new TicketCounter(), null, false));
    rides.add(new GiantWheel(ThemeParkConstants.Game.GIANT_WHEEL,  0, 0, 0, false, false,  false, new TicketCounter(), null, false));
    rides.add(new RainBowDragon(ThemeParkConstants.Game.RAINBOW_DRAGON,  0, 0, 0, false, false,  false, new TicketCounter(), null, false));
    rides.add(new WaterPendulum(ThemeParkConstants.Game.WATER_PENDULUM,  0, 0, 0, false, false,  false, new TicketCounter(), null, false));
    rides.add(new WavePool(ThemeParkConstants.Game.WAVE_POOL,  0, 0, 0, false, false,  false, new TicketCounter(), null, false));
}

    private  void createOperator() {

    }
}
