
import java.time.LocalDate;

public class Ticket {

    private int ticketNumber;
    private String holder;
    private String category;
   // private boolean status;
    private LocalDate date;
    private String time;

    public Ticket(int ticketNumber, String category, String holder, LocalDate date, String time) {
        this.ticketNumber = ticketNumber;
        this.category = category;
        this.holder = holder;
        this.date = date;
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
