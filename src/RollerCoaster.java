
public class RollerCoaster extends Ride  {

    public RollerCoaster(String rideName, int amount, int startTime, int endTime, boolean adult, boolean children, boolean senior, TicketCounter ticketCounter, Operator operator) {
        super(rideName, amount, startTime, endTime, adult, children, senior, ticketCounter, operator);
    }

    @Override
    public String getRideName() {
        return "Roller coaster";
    }

    public RollerCoaster() {
        super();
    }

    public void show(){
       System.out.println("hi");
   }
}
