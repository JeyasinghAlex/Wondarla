import java.util.ArrayList;

public class OperatorTicketCounter {
    private int amount;
    public  ArrayList<OperatorRecordBook> recordBooks = new ArrayList<>();

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount += amount;
        System.out.println("Your Earning is - "+this.getAmount());
    }
}

