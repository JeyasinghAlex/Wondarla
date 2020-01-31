public class Main {

    static ThemPark themPark = new ThemPark();
    public  static void main(String[] arg){
        themPark.main();
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
        System.out.println("8) Chuck Visitor Wallet");
        System.out.println("9) Print total Earning of Entrance TicketCounter");
        System.out.print("Enter your Option - ");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        switch (option)
        {
            case 1:
                themPark.configurationGame();
                break;
            case 2:
                themPark.visitorRegistration();
                break;
            case 3:
                themPark.showAvailableRides();
                break;
            case 4:
                themPark.startRide();
                break;
            case 5:
                CanteenMain.showMain();
                break;
            case 6:
                themPark.printVisitorDetails();
                break;
            case 7:
                themPark.printGameEarningDetails();
                break;
            case 8:
                themPark.checkWallet();
                break;
            case 9:
                break;
            default:
                break;
        }
    }
}
