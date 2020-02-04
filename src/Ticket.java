import java.time.LocalDate;

public class Ticket {

    private int ticketNumber;
    private String holder;
    private String category;
    private String type;
    private LocalDate date;
    private int time;

    public Ticket(int ticketNumber, String category, String holder, String type, LocalDate date, int time) {
        this.ticketNumber = ticketNumber;
        this.category = category;
        this.holder = holder;
        this.type = type;
        this.date = date;
        this.time = time;
    }

    public int getTicketNumber(){
        return this.ticketNumber;
    }

    public String getCategory(){
        return this.category;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", holder='" + holder + '\'' +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
