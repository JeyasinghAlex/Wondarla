import java.time.LocalDate;

public class General extends Ticket {
    public General(int ticketNumber, String category, String holder, String type, LocalDate date, int time) {
        super(ticketNumber, category, holder, type, date, time);
    }
}
