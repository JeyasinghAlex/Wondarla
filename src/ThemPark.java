import java.util.ArrayList;

public class ThemPark {

    public  EntranceTicketCounter ticketCounter = new EntranceTicketCounter();
    public  Canteen canteen = new Canteen();
    public  ArrayList<Ride> rides = new ArrayList<>();
    public   ArrayList<Operator> operators = new ArrayList<>();
       private static  ThemPark themPark = new ThemPark();
        private ThemPark(){

        }

        public static ThemPark getThemParkInstance(){
            return themPark;
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
            rides.add(operators.get(getOperator).configuration());
            getOperator++;
            System.out.println("Would you like another game configuration ?");
            result = GeneralUtil.getInstance().isAllowRide();
        }while (result);
        Main.showMenu();
    }

    public  void showAvailableRides(){
        System.out.println("Today Available Rides");
        for(int i = 0; i < rides.size(); i++){
            System.out.println(i+1+") "+rides.get(i).toString());
        }

        System.out.println("--------------------------------------------------------");
        System.out.print("Enter your Selection - ");
        int selectedRide = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if(selectedRide <= rides.size()){
            System.out.println("Your Selected Ride is  -> "+rides.get(selectedRide-1).getRideName());
            rides.get(selectedRide-1).operator.operateRide(rides.get(selectedRide-1));
        } else
            System.out.println("Invalid Selection");
            Main.showMenu();
    }

    private  void createOperator() {
        operators.add(new Operator("Alex"));
        operators.add(new Operator("Kamalesh"));
        operators.add(new Operator("Senthil"));
        operators.add(new Operator("Maddy"));
        operators.add(new Operator("Darshon"));
    }
}
