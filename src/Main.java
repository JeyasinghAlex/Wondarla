public class Main {

    public  static void main(String[] arg){
        ThemPark.getThemParkInstance().main();
        showMenu();
    }

    public static void showMenu(){
        System.out.println("\n");
        System.out.println("1) Configuration of Game");
        System.out.println("2) Visitor Registration");
        System.out.println("3) Show Available Rides");
        System.out.println("4) Start Ride");
        System.out.println("5) Canteen");
        System.out.println("6) Print Visitor Details");
        System.out.println("7) Print Game Earning Details");
        System.out.println("8) Check Visitor Wallet");
        System.out.println("9) Print total Earning of Entrance TicketCounter\n");
        System.out.println("10) Print canteen earning");
        System.out.print("Enter your Option - ");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        switch (option)
        {
            case 1:
                ThemPark.getThemParkInstance().configurationGame();
                break;
            case 2:
                ThemPark.getThemParkInstance().ticketCounter.giveTicket();
                break;
            case 3:
                //ThemPark.getThemParkInstance().showAvailableRides();
                break;
            case 4:
                ThemPark.getThemParkInstance().showAvailableRides();
                break;
            case 5:
               // CanteenMain.showMain();
                break;
            case 6:
               // ThemPark.getThemParkInstance().ticketCounter.printVisitorDetails();
                break;
            case 7:
               // ThemPark.getThemParkInstance().printGameEarningDetails();
                break;
            case 8:
              //  ThemPark.getThemParkInstance().ticketCounter.checkWallet();
                break;
            case 9:
                //ThemPark.getThemParkInstance().ticketCounter.getEntranceAmount();
                showMenu();
                break;
            case 10:
                ThemPark.getThemParkInstance().canteen.getInstance().getAmount();
                showMenu();
                break;
            default:
                break;
        }
    }
}
