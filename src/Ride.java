public  class Ride {

    protected String rideName;
    protected int amount;
    protected int startTime;
    protected int endTime;
    protected boolean adult;
    protected boolean children;
    protected boolean senior;
    protected Operator operator;
    protected TicketCounter ticketCounter;

    public Ride(String rideName, int amount, int startTime, int endTime, boolean adult, boolean children, boolean senior, TicketCounter ticketCounter, Operator operator) {
        this.rideName = rideName;
        this.amount = amount;
        this.startTime = startTime;
        this.endTime = endTime;
        this.adult = adult;
        this.children = children;
        this.senior = senior;
        this.ticketCounter = ticketCounter;
        this.operator = operator;
        RideDAO.insertRideDetails(rideName, startTime, endTime, adult, children, senior);
    }

    public Ride(){

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

    public TicketCounter getTicketCounterInstance() {
        return ticketCounter;
    }

    public boolean getCategory(String category){
        if(category .equals("Adult"))
            return this.adult;
        else if(category.equals("Children"))
            return this.children;
        else
            return this.senior;
    }


    @Override
    public String toString() {
        return "Ride { " +
                " rideName = '" + rideName + '\'' +
                ", amount = " + amount +
                ", startTime = '" + startTime + '\'' +
                ", endTime = '" + endTime + '\'' +
                ", adult = " + adult +
                ", child = " + children +
                ", senior = " + senior +
                "}";
    }
}
