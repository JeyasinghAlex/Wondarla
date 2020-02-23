import java.util.ArrayList;

public class ThemPark {

    public static int time ;
    private static EntranceTicketCounter ticketCounter = new EntranceTicketCounter();
    private static  Canteen canteen = new Canteen();
    public static ArrayList<Ride> rides = new ArrayList<>();
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
        //createOperator();
        canteen.createFood();
    }
    private int getOperator = 0;
    /*public  void configurationGame(){
            System.out.println("Available Game in Them park\n");
            for(int i = 0; i < rides.size(); i++){
                if(!(rides.get(i).getConfigure())){
                    System.out.println(i+1 + ")"+ rides.get(i).getRideName());
                }
            }

            System.out.println("Which Game you configure ?");
            int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
            if(!rides.get(option-1).getConfigure()){
                operators.get(getOperator++).configuration(rides.get(option-1), option);
            }else {
                System.out.println("Already this game is configure is completed");
            }
            System.out.println("Would you like another game configuration ?");
            if(GeneralUtil.getInstance().isAllowRide()){
                configurationGame();
            }
    }*/

    public void configurationGame(){
        boolean result = false;
        System.out.println("Available Game in Them park\n");
        for(int i = 0; i < rides.size(); i++){
            if(!(rides.get(i).getConfigure())){
                System.out.println(i+1 + ")"+ rides.get(i).getRideName());
            }
        }

        System.out.println("Which Game you configure ?");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if(!rides.get(option-1).getConfigure()){
            for(int i = 0; i < operators.size(); i++){
                if(!operators.get(i).isAvailable()){
                    result = true;
                    for(int j = i+1; j < operators.size(); j++){
                        if(!operators.get(j).isAvailable() && operators.get(j).getCredits() < operators.get(i).getCredits()){
                            Operator temp = operators.get(i);
                            operators.set(i, operators.get(j));
                            operators.set(j, temp);
                        }
                    }
                    operators.get(i).configuration(rides.get(option-1), option);
                    break;
                }
            }
            if(!result){
                System.out.println("All Operators Busy");
            }
        } else {
            System.out.println("Already this game is configure is completed");
        }

        System.out.println("Would you like another game configuration ?");
        if(GeneralUtil.getInstance().isAllowRide()){
            configurationGame();
        }
    }

    public void createGame(){
        System.out.print("Enter the Game Name - ");
        String gameName = GeneralUtil.getInstance().getString();
        rides.add(new Ride(gameName, new TicketCounter()));
        int rideId = RideDao.getRideDaoInstance().insertNewGame(gameName);
        operators.get(getOperator++).configuration(rides.get(rides.size() - 1), rideId);
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
        if(selection <= rides.size() && rides.get(selection-1).getConfigure()){
            System.out.println("Your Selected Ride is  -> "+ rides.get(selection-1).getRideName());
            rides.get(selection-1).operator.operateRide(rides.get(selection-1), selection);
        } else
            System.out.println("Invalid Selection.... Plzz Check Available Game");
    }

    public void showRideEarningDetails(){
        for(int i = 0; i < rides.size(); i++){
            System.out.println("------------------"+ rides.get(i).getRideName()+"------------------");
            rides.get(i).getTicketCounterInstance().showRideEarningDetails();
            /** DB Connection */
            System.out.println(RideDao.getRideDaoInstance().getEarningDetails(i+1));
        }
    }

    static {
        operators.add(new Operator("Alex", 12345));
        operators.add(new Operator("Kamalesh", 12346));
        operators.add(new Operator("Senthil", 12347));
        operators.add(new Operator("Maddy", 12348));
        operators.add(new Operator("Darshon", 12349));

        rides.add(new RollerCoaster(ThemeParkConstants.Game.ROLLER_COASTER, new TicketCounter()));
        rides.add(new Columbus(ThemeParkConstants.Game.COLUMBUS,  new TicketCounter()));
        rides.add(new GiantWheel(ThemeParkConstants.Game.GIANT_WHEEL, new TicketCounter()));
        rides.add(new RainBowDragon(ThemeParkConstants.Game.RAINBOW_DRAGON,  new TicketCounter()));
        rides.add(new WaterPendulum(ThemeParkConstants.Game.WATER_PENDULUM,  new TicketCounter()));
        rides.add(new WavePool(ThemeParkConstants.Game.WAVE_POOL,  new TicketCounter()));
    }
}
