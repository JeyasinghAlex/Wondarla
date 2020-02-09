import java.sql.SQLException;

public class Main {

    public  static void main(String[] arg) throws SQLException, ClassNotFoundException {
        ThemPark.getThemParkInstance().main();
        showUserOption();
    }

    public static void showUserOption() throws SQLException, ClassNotFoundException {
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

    public static void showAdminOptions() throws SQLException, ClassNotFoundException {
        System.out.println("\n1) Configuration of Game");
        System.out.println("2) Print Visitor Details");
        //System.out.println("3) Print Game Earning Details");
        System.out.println("4) Print total Earning of Entrance TicketCounter");
        System.out.println("5) Print canteen earning");
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
                showUserOption();
                break;
            case 3:

                break;
            case 4:
                ThemPark.getThemParkInstance().getTicketCounterInstance().getAmount();
                showUserOption();
                break;
            case 5:
                ThemPark.getThemParkInstance().getCanteenInstance().getCanteenMoneyCollector().getAmount();
                showUserOption();
                break;
            default:
                break;
        }
    }

    public static void showVisitorOptions() throws SQLException, ClassNotFoundException {
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
                System.out.println("Server  - " + server.getName() + " handle the Order");
                ThemPark.getThemParkInstance().getCanteenInstance().orderFood(server);
                showUserOption();
                break;
            case 4:
                //
                break;
            default:
                break;
        }
    }
}
