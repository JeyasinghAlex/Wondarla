
public class RollerCoaster extends Ride {

        OperatorTicketCounter operatorTicketCounter;
        public RollerCoaster(String rideName, int amount, int startTime, int endTime, boolean adult, boolean child, boolean senior) {
        super(rideName, amount, startTime, endTime, adult, child, senior);
        operatorTicketCounter = new OperatorTicketCounter();
    }

    public void getMoney(){
        //operatorTicketCounter.setAmount(10);
        System.out.println("Hello Wold");
    }
}
