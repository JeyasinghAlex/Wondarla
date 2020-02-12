import java.util.ArrayList;

public class TicketCounter {
    private int amount;
    private ArrayList<RideRecordBook> recordBooks = new ArrayList<>();
    //---------------------------------------------------------------------------------
    /** Inner Class */

    private ArrayList<Records> records = new ArrayList<>();
    private static class Records{
        private int ticketNumber;
        private String name;

        public Records(int ticketNumber, String name){
            this.ticketNumber = ticketNumber;
            this.name = name;
        }
    }

    public void addRecordInRecordBook(int ticketNumber, String name){
            records.add(new Records(ticketNumber, name));
    }

    public ArrayList<Records> getRecords() {
        return records;
    }

    //--------------------------------------------------------------------------------
    public int getAmount() {
        return amount;
    }

    public ArrayList<RideRecordBook> getRecordBooks() {
        return recordBooks;
    }

    public void setAmount(int amount, Ride selectedGame) {
        this.amount += amount;
        System.out.println(selectedGame.getRideName() +" Total Earning is - "+this.getAmount());
    }

    public void showRideEarningDetails(){
        for(int i = 0; i < recordBooks.size(); i++){
            System.out.println(recordBooks.get(i).toString());
        }
    }
}
