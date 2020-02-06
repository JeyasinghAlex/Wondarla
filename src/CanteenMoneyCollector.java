public class CanteenMoneyCollector {

    private int amount;
    public void setAmount(int amount, Server server) {
        server.setTips((amount/100)*10);
        this.amount += amount;
        System.out.println("Canteen kalla is - " + this.amount);
    }

//    public void importCharge(int amount){
//        this.amount -= amount;
//        System.out.println("Canteen kalla is - " + this.amount);
//    }

    public void getAmount() {
        System.out.println(this.amount);
    }
}
