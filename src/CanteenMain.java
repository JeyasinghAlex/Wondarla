public class CanteenMain {

    static Canteen canteen = Main.themPark.canteen;
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
                canteen.showMenuCard();
                break;
            case 2:
                Server server = canteen.selectServer();
                Visitor visitor =  Visitor.orderFood();
               canteen.orderFood(visitor);
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
