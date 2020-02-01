import java.util.ArrayList;

public class OperatorTicketCounter {
    private int amount;
    public  ArrayList<OperatorRecordBook> recordBooks = new ArrayList<>();

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount, Operator operator) {
        this.amount += amount;
        System.out.println(operator.getHisGame() +" Total Earning is - "+this.getAmount());
    }
}

