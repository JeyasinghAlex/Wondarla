public class RideRecordBook {
   private int ticketNumber;
   private String name;

    public RideRecordBook(int ticketNumber, String  name){
        this.ticketNumber = ticketNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ticketNumber = " + ticketNumber +
                ",  name = " + name;
    }
}
