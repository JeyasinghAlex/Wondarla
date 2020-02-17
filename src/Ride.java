public class Ride {

    protected String rideName;
    protected int amount;
    protected int startTime;
    protected int endTime;
    protected boolean isAllowAdult;
    protected boolean isAllowChildren;
    protected boolean isAllowSenior;
    protected boolean isConfigure;
    protected Operator operator;
    protected TicketCounter ticketCounter;

    public Ride(String rideName, TicketCounter ticketCounter) {
        this.rideName = rideName;
        this.ticketCounter = ticketCounter;
    }

    public String getRideName(){
        return this.rideName;
    }

   // public abstract String getRideName();

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getConfigure() {
        return this. isConfigure;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setAllowAdult(boolean allowAdult) {
        this.isAllowAdult = allowAdult;
    }

    public void setAllowChildren(boolean allowChildren) {
        this.isAllowChildren = allowChildren;
    }

    public void setAllowSenior(boolean allowSenior) {
        this.isAllowSenior = allowSenior;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setTicketCounter(TicketCounter ticketCounter) {
        this.ticketCounter = ticketCounter;
    }

    public void setConfigure(boolean configure) {
        RideDao.insertRideDetails(this.rideName, this.startTime, this.endTime, this.isAllowAdult, this.isAllowChildren, this.isAllowSenior);
        isConfigure = configure;
    }

    public TicketCounter getTicketCounterInstance() {
        return ticketCounter;
    }

    public boolean getCategory(String category){
        if(category .equals("Adult"))
            return this.isAllowAdult;
        else if(category.equals("Children"))
            return this.isAllowChildren;
        else
            return this.isAllowSenior;
    }


    @Override
    public String toString() {
        return "Ride { " +
                " rideName = '" + rideName + '\'' +
                ", amount = " + amount +
                ", startTime = '" + startTime + '\'' +
                ", endTime = '" + endTime + '\'' +
                ", adult = " + isAllowAdult +
                ", child = " + isAllowChildren +
                ", senior = " + isAllowSenior +
                "}";
    }
}
