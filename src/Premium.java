import java.time.LocalDate;

public class Premium extends Ticket {

    public Premium(int ticketNumber, String category, String holder, String type, LocalDate date, float time) {
        super(ticketNumber, category, holder, type, date, time);
    }

    public Premium(){
        super();

    }

    public int calculateMoney(int amount){
       return (amount/2);
    }

    public void setTime(int time){
        this.time = (float) (time + 0.30);
    }
}
