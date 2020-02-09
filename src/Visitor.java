
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
        //VisitorDAO.insertVisitorDetails(this.name, this.gender, this.ticket.category, this.ticket.getTime());
//        try{
//           // DataBaseConnection.getDbInstance().getConnection().prepareStatement("insert into visitors(visitor_name, visitor_gender, visitor_category, visitor_credits) value('"+name+"','"+gender+"','"+this.getTicket().getCategory()+"','"+1000+"')");
//
//            //DataBaseConnection.getDbInstance().getConnection().createStatement().executeUpdate("insert into visitors(visitor_name, visitor_gender, visitor_category, visitor_credits) value('"+name+"','"+gender+"','"+this.getTicket().getCategory()+"','"+1000+"')");
//        }catch (Exception ex){
//            System.out.println(ex);
//        }

        System.out.println("Your password is - "+ this.password);
        System.out.println("--------------------------------------------------------");
        System.out.println();
    }

    public Ticket getTicket()  {
        return this.ticket;
    }

   private boolean passwordValidation(){
       System.out.print("Enter your password - ");
       int password = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if(this.password == password){
            System.out.println("--- Password is match ---");
            return true;
        }else{
            System.out.println("--- Password is incorrect ---");
            return  false;
        }
   }

   private int getWallet(int amount){
        System.out.println("Would you like to pay  "+amount+" ?");
        System.out.println("1) yes\n2)No");
        System.out.print("What is your wish ? - ");
        if(GeneralUtil.getInstance().checkAndReturnValidInteger() == 1)
        if(passwordValidation() && this.wallet >= amount){
             this.wallet = this.wallet-amount;
            System.out.println(this.name + " your new Wallet is - " + this.wallet+"\n");
             return amount;
        }
        System.out.println("Insufficient balance /Order Cancelled");
        return  0;
    }

    public static int getVisitorInstance(Visitor visitor, int amount){
        return visitor.getWallet(amount);
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "wallet=" + wallet +
                ", name='" + name + '\'' +
               // ", age=" + age +
                ", gender='" + gender + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}
