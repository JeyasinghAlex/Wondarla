import java.util.ArrayList;

public class Visitor {

    private int wallet = 1000;
    private String name;
    private int age;
    private String gender;
    private String category;
    private int height;
    private int weight;
    private Ticket ticket;

    public Visitor( String name, int age, String gender, String category, Ticket ticket) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.category = category;
        this.ticket = ticket;
        System.out.println("--------------------------------------------------------");
        System.out.println("Collect Your " + this.ticket.toString());
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }

    public Ticket getTicket(){
        return this.ticket;
    }

    public void setWallet(int wallet) {
        this.wallet -= wallet;
        System.out.println("Your new Wallet is - " + this.wallet);
    }

    public String getName(){
        return this.name;
    }

    public static Ride selectRide(ArrayList<Ride> rides){
        System.out.print("Enter your Selection - ");
        int selectedRide = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if(selectedRide <= rides.size())
            System.out.println("Your Selected Ride is - "+rides.get(selectedRide-1).getRideName());
        else
            System.out.println("Invalid Selection");
        return rides.get(selectedRide-1);
    }
}
