public class Main {

    public  static void main(String[] arg){
        ThemPark.getThemParkInstance().main();
        showUserOption();
    }

    public static void showUserOption(){
        System.out.println("1) Employee");
        System.out.println("2) Visitor");
        System.out.println("OtherWise Exit");
        System.out.print("Enter your Option - ");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if(option == 1)
            showEmployeeOptions();
        else if (option == 2)
            showVisitorOptions();
        else{
            System.out.println("Program will be exited----");
            System.exit(0);
        }
    }

    public static void showEmployeeOptions(){
        System.out.println("1) Configuration of Game");
        System.out.println("2) Print Visitor Details");
        System.out.println("3) Print Game Earning Details");
        System.out.println("4) Print total Earning of Entrance TicketCounter\n");
        System.out.println("5) Print canteen earning");
        System.out.print("Enter your Option - ");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        switch (option)
        {
            case 1:
                ThemPark.getThemParkInstance().configurationGame();
                break;
            case 2:
                //ThemPark.getThemParkInstance()
                break;
            case 3:
                //  ThemPark.getThemParkInstance().canteen.
                break;
            case 4:
                //
                break;
            case 5:
                ThemPark.getThemParkInstance().getCanteenInstance().getCanteenMoneyCollector().getAmount();
                break;
            default:
                break;
        }
    }

    public static void showVisitorOptions(){
        System.out.println("1) Visitor Registration");
        System.out.println("2) Go Ride");
        System.out.println("3)Order Food");
        System.out.println("4) Check Visitor Wallet");
        System.out.print("Enter your Option - ");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        switch (option)
        {
            case 1:
                ThemPark.getThemParkInstance().getTicketCounterInstance().giveTicket();
                break;
            case 2:
                ThemPark.getThemParkInstance().showAvailableRides();
                break;
            case 3:
                Server server = ThemPark.getThemParkInstance().getCanteenInstance().selectServer();
                System.out.println("Server  - " + server.getName() + " handle the Order");
                ThemPark.getThemParkInstance().getCanteenInstance().orderFood(server);
                break;
            case 4:
                //
                break;
            default:
                break;
        }
    }
}
