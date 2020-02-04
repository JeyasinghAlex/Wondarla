import java.util.ArrayList;

public class Visitor {

    private int wallet = 1000;
    private String name;
    private int age;
    private String gender;
    private String category;
    private int time;
    private Ticket ticket;

    public Visitor( String name, int age, String gender, String category, Ticket ticket, int time) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.category = category;
        this.ticket = ticket;
        this.time = time;
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
        System.out.println(this.name + " your new Wallet is - " + this.wallet+"\n");
    }

    public int getWallet() {
        return this.wallet;
    }

    public String getName(){
        return this.name;
    }

    public int getTime(){
        return this.time;
    }

    public void setTime(int time){
        this.time = time+1;
        System.out.println("Now "+this.name + " Time is - " + this.time);
    }

//    public static Ride selectRide(ArrayList<Ride> rides){
//        System.out.print("Enter your Selection - ");
//        int selectedRide = GeneralUtil.getInstance().checkAndReturnValidInteger();
//        if(selectedRide <= rides.size())
//            System.out.println("Your Selected Ride is - "+rides.get(selectedRide-1).getRideName());
//        else
//            System.out.println("Invalid Selection");
//        return rides.get(selectedRide-1);
//    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public static Visitor orderFood(){
        Visitor visitor = null;
        System.out.print("Enter your Ticket Number - ");
        int ticket  = GeneralUtil.getInstance().checkAndReturnValidInteger();
        int length = ThemPark.getThemParkInstance().ticketCounter.visitorArrayList.size();
        for(int i = 0; i < length; i++){
            if(ticket == ThemPark.getThemParkInstance().ticketCounter.visitorArrayList.get(i).ticket.getTicketNumber()){
                return ThemPark.getThemParkInstance().ticketCounter.visitorArrayList.get(i);
            }
        }
        return visitor;
    }
}
