public class OperatorRecordBook {
   private int ticketNumber;
   private String name;

    public OperatorRecordBook(int ticketNumber, String  name){
        this.ticketNumber = ticketNumber;
        this.name = name;
    }
    @Override
    public String toString() {
        return "OperatorRecordBook{" +
                "ticketNumber=" + ticketNumber +
                ", name=" + name +
                '}';
    }
}
