import java.util.ArrayList;

public class TicketCounter {
    private int amount;
    private ArrayList<RideRecordBook> recordBooks = new ArrayList<>();

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount, Ride selectedGame) {
        this.amount += amount;
        System.out.println(selectedGame.getRideName() +" Total Earning is - "+this.getAmount());
    }
}

