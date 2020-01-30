import java.time.LocalDate;

public class Ticket {

    private int ticketNumber;
    private String holder;
    private String category;
   // private boolean status;
    private LocalDate date;
    private int time;

    public Ticket(int ticketNumber, String category, String holder, LocalDate date, int time) {
        this.ticketNumber = ticketNumber;
        this.category = category;
        this.holder = holder;
        this.date = date;
        this.time = time;
    }
    public int getTicketNumber(){
        return this.ticketNumber;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Ticket - { " +
                "ticketNumber = " + ticketNumber +
                ", holder = '" + holder +
                ", category = '" + category +
                ", date = " + date +
                ", time = '" + time +
                " }";
    }
}
