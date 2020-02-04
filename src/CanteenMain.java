public class CanteenMain {

    public static void showMain(){
        System.out.println("1) Show Available Food");
        System.out.println("2) Order Food");
        System.out.println("3) Continue Ride");
        System.out.println("4) Exit");
        System.out.print("Enter your Option - ");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        switch(option)
        {
            case 1:
                ThemPark.getThemParkInstance().canteen.showMenuCard();
                break;
            case 2:
                Server server = ThemPark.getThemParkInstance().canteen.selectServer();
                System.out.println("Server  - " + server.getName() + " handle the Order");
                ThemPark.getThemParkInstance().canteen.orderFood(server);
                break;
            case 3:
                Main.showMenu();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Enter the Correct Option");
                showMain();
                break;
        }
    }
}
