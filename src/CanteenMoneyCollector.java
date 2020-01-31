public class CanteenMoneyCollector {

    private int amount;
    public void setAmount(int amount) {
        this.amount += amount;
        System.out.println("Canteen kalla is - " + this.amount);
    }
}
