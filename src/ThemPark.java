import java.util.ArrayList;

public class ThemPark {

    public  EntranceTicketCounter ticketCounter = new EntranceTicketCounter();
    public  Canteen canteen = new Canteen();
    public  ArrayList<Ride> rides = new ArrayList<>();
    public   ArrayList<Operator> operators = new ArrayList<>();
   // public ArrayList<Visitor> visitorArrayList = new ArrayList<>();
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
            result = GeneralUtil.getInstance().isAllowRide("another game Configure ");
        }while (result);
        Main.showMenu();
    }

    public  void visitorRegistration(){
        boolean result;
        do {
            ticketCounter.receiveTicket();
            result = GeneralUtil.getInstance().isAllowRide("another visitor ");
        }while (result);
        Main.showMenu();
    }

    public  void startRide(){
        System.out.println("Today Available Rides");
        for(int i = 0; i < rides.size(); i++){
            System.out.println(i+1+") "+rides.get(i).toString());
        }

        System.out.println("--------------------------------------------------------");
        //Ride selectedRide =  Visitor.selectRide(rides);
        //((RollerCoaster) selectedRide).getMoney();
        System.out.print("Enter your Selection - ");
        int selectedRide = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if(selectedRide <= rides.size()){
            System.out.println("Your Selected Ride is  -> "+rides.get(selectedRide-1).getRideName());
          //  rides.get(selectedRide-1).startRide(rides.get(selectedRide-1));
            rides.get(selectedRide-1).operator.startRide(rides.get(selectedRide-1));
        } else
            System.out.println("Invalid Selection");
            Main.showMenu();
    }

//        public  void printVisitorDetails() {
//            for (int i = 0; i < themPark.ticketCounter.visitors.size(); i++) {
//                System.out.println(themPark.ticketCounter.visitors.get(i).toString());
//            }
//            Main.showMenu();
//        }

         public  void printGameEarningDetails() {
             for(int i = 0; i < rides.size(); i++){
                 System.out.println("--------------------"+rides.get(i).getRideName()+ "-------------------------------");
                 //if(operators.get(i).getHisGame() != null)
                 for(int j = 0; i < rides.get(i).ticketCounter.recordBooks.size();  j++){
                     System.out.println(rides.get(i).ticketCounter.recordBooks.get(j).toString());
                 }
             }
             Main.showMenu();
         }

//       public  void checkWallet(){
//            for(int i = 0; i < themPark.ticketCounter.visitors.size(); i++){
//                System.out.println("Ticket Number ("+themPark.ticketCounter.visitors.get(i).getTicket().getTicketNumber() + ") Available balance is - " +themPark.ticketCounter.visitors.get(i).getWallet());
//            }
//           Main.showMenu();
//        }

    private  void createOperator() {
        operators.add(new Operator("Alex"));
        operators.add(new Operator("Kamalesh"));
        operators.add(new Operator("Senthil"));
        operators.add(new Operator("Luu"));
        operators.add(new Operator("Darshon"));
    }

    public  void showAvailableRides(){
        System.out.println("--------------------------------------------------------\n");
        System.out.println("Today Available Rides");
        for(int selectedRide = 0; selectedRide < rides.size(); selectedRide++){
            System.out.println(selectedRide+1+") "+rides.get(selectedRide).toString());
        }
        System.out.println("--------------------------------------------------------");
        Main.showMenu();
    }
}
