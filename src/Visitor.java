public class Visitor {

    private int wallet = 1000;
    private String name;
    private int age;
    private String gender;
    private Ticket ticket;

    public Visitor( String name, int age, String gender, Ticket ticket) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.ticket = ticket;
        System.out.println("--------------------------------------------------------");
        System.out.println("Collect Your " + this.ticket.toString());
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }

    public Ticket getTicket(){
        return this.ticket;
    }

    private int sendMoney(int amount){

        System.out.println("Would you like to pay  "+amount+" ?");
        System.out.println("1) yes\n2)No");
        System.out.print("What is your wish ? - ");
        if(GeneralUtil.getInstance().checkAndReturnValidInteger() == 1 && this.wallet >= amount){
             this.wallet = this.wallet-amount;
            System.out.println(this.name + " your new Wallet is - " + this.wallet+"\n");
             return amount;
        }
        return  0;
    }

    public static int getVisitorInstance(Visitor visitor, int amount){
        return visitor.sendMoney(amount);
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "wallet=" + wallet +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}
