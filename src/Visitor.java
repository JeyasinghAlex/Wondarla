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

    private void setWallet(int wallet) {
        this.wallet = wallet;
        System.out.println(this.name + " your new Wallet is - " + this.wallet+"\n");
    }


    public int requestMoney(int amount){
        /***/
        System.out.println("Would you like to pay  "+amount+" ?");
        System.out.println("1) yes\n2)No");
        System.out.print("What is your wish ? - ");
        if(GeneralUtil.getInstance().checkAndReturnValidInteger() == 1 && this.wallet >= amount){
             setWallet(getWallet()-amount);
             return amount;
        }
        return  0;
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

//    public static Visitor orderFood(){
//        Visitor visitor = null;
//        System.out.print("Enter your Ticket Number - ");
//        int ticket  = GeneralUtil.getInstance().checkAndReturnValidInteger();
//        int length = ThemPark.getThemParkInstance().ticketCounter.visitors.size();
//        for(int i = 0; i < length; i++){
//            if(ticket == ThemPark.getThemParkInstance().ticketCounter.visitors.get(i).ticket.getTicketNumber()){
//                return ThemPark.getThemParkInstance().ticketCounter.visitors.get(i);
//            }
//        }
//        return visitor;
//    }
}
