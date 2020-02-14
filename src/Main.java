
public class Main {

    public  static void main(String[] arg)  {
        ThemPark.getThemParkInstance().main();
        showUserOption();
    }

    public static void showUserOption()  {
        System.out.println("\n1) Admin");
        System.out.println("2) Visitor");
        System.out.println("OtherWise Exit");
        System.out.print("Enter your Option - ");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if(option == 1)
            showAdminOptions();
        else if (option == 2)
            showVisitorOptions();
        else{
            System.out.println("Program will be exited----");
            System.exit(0);
        }
    }

    public static void showAdminOptions()  {
        System.out.println("\n1) Configuration of Game");
        System.out.println("2) Print Visitor Details");
        System.out.println("3) Print Game Earning Details");
        System.out.println("4) Print total Earning of Entrance TicketCounter");
        System.out.println("5) Print canteen earning");
        System.out.println("6)  New Game Create");
        System.out.print("Enter your Option - ");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        switch (option)
        {
            case 1:
                ThemPark.getThemParkInstance().configurationGame();
                showUserOption();
                break;
            case 2:
                ThemPark.getThemParkInstance().getTicketCounterInstance().showVisitorsDetails();
                VisitorDAO.getVisitorDetails();
                showUserOption();
                break;
            case 3:
                ThemPark.getThemParkInstance().showRideEarningDetails();
                showUserOption();
                break;
            case 4:
                ThemPark.getThemParkInstance().getTicketCounterInstance().getAmount();
                showUserOption();
                break;
            case 5:
                ThemPark.getThemParkInstance().getCanteenInstance().getCanteenMoneyCollector().getAmount();
                showUserOption();
                break;
            case 6:
                break;
            default:
                break;
        }
    }

    public static void showVisitorOptions()  {
        System.out.println("\n1) Visitor Registration");
        System.out.println("2) Go Ride");
        System.out.println("3)Order Food");
        System.out.println("4) Check Visitor Wallet");
        System.out.print("Enter your Option - ");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        switch (option)
        {
            case 1:
                ThemPark.getThemParkInstance().getTicketCounterInstance().giveTicket();
                showUserOption();
                break;
            case 2:
                ThemPark.getThemParkInstance().showAvailableRides();
                showUserOption();
                break;
            case 3:
                Server server = ThemPark.getThemParkInstance().getCanteenInstance().selectServer();
                System.out.println("\nServer  - " + server.getName() + " handle the Order\n");
                ThemPark.getThemParkInstance().getCanteenInstance().orderFood(server);
                showUserOption();
                break;
            case 4:
                System.out.print("Enter the ticket number - ");
                int ticketNumber = GeneralUtil.getInstance().checkAndReturnValidInteger();
                ThemPark.getThemParkInstance().getTicketCounterInstance().searchVisitors(ticketNumber).setWallet(0);
                showUserOption();
                break;
            default:

                break;
        }
    }
}
