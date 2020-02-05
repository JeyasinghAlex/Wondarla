import java.time.LocalDate;

public class Premium extends Ticket {

    public Premium(int ticketNumber, String category, String holder, String type, LocalDate date, int time) {
        super(ticketNumber, category, holder, type, date, time);
    }

    public int calculateMoney(int amount){
       return (amount/2);
    }

    public void setTime(int time){

    }

}
