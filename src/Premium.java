import java.time.LocalDate;

public class Premium extends Ticket {

    public Premium(int ticketNumber, String category, String holder, String type, LocalDate date, float time) {
        super(ticketNumber, category, holder, type, date, time);
    }

    public int calculateMoney(int amount){
       return (amount/2);
    }

    public void setTime(int time){
        if(time > this.time)
            this.time = (float) (time + 0.50);
        else
            this.time += 0.50;
        System.out.println("Now "+this.holder + " Time is - " + this.time);
    }
}
