
public class Visitor {

    private static int number = 1000;
    private int wallet = 1000;
    private  int password;
    private String name;
    private String gender;
    private Ticket ticket;

    public Visitor( String name, String gender, Ticket ticket)  {
        this.name = name;
        this.gender = gender;
        this.ticket = ticket;
        this.password = ++number;
        System.out.println("--------------------------------------------------------");
        System.out.println("Your password is - "+ this.password);
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }

    public Ticket getTicket()  {
        return this.ticket;
    }

    private boolean passwordValidation(){
        System.out.print("Enter your Password - ");
        int pwd = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if(this.password == pwd){
            return true;
        }else{
            System.out.println("Wrong password");
            return false;
        }
    }

    private boolean getPermission(int amount){
        System.out.println("If you want to pay  - " + amount + "?\n1) Yes \n 2) No");
        System.out.println("Enter your option");
        if(GeneralUtil.getInstance().checkAndReturnValidInteger() == 1){
            return true;
        }else
            return false;
    }

    public Boolean setWallet(int wallet){
        if(this.wallet >= wallet && getPermission(wallet) && passwordValidation()){
            this.wallet -= wallet;
            System.out.println(this.name + " your debited amount is - " + wallet );
            System.out.println(this.name + " your new Wallet is - " + this.wallet+"\n");
            return true;
        }else{
            System.out.println("Insufficient balance");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "name = " + name +
                ", gender ='" + gender + '\'' +
                ", wallet = '" + wallet + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}
