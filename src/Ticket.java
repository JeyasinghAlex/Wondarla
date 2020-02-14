
import java.time.LocalDate;

public class Ticket {

    protected int ticketNumber;
    protected String holder;
    protected String category;
    protected String type;
    protected LocalDate date;
    protected float time;

    public Ticket(int ticketNumber, String category, String holder, String type, LocalDate date, float time)  {
        this.ticketNumber = ticketNumber;
        this.category = category;
        this.holder = holder;
        this.type = type;
        this.date = date;
        this.time = time;
        // DataBaseConnection.getDbInstance().getConnection().createStatement().executeUpdate("Insert into tickets(ticket_type) value('"+this.type+"')");
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getHolder() {
        return holder;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public float getTime() {
        return time;
    }

    public int calculateMoney(int amount){
        return 0;
    }

    public void setTime(int time) {
        if(time > this.time)
            this.time = time+1;
        else
            this.time += 1;
        System.out.println("Now "+this.holder + " Time is - " + this.time);
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
