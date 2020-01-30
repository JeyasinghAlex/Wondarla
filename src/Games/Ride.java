package Games;

public class Ride {

    protected String rideName;
    protected int amount;
    protected String startTime;
    protected String endTime;
    protected boolean adult;
    protected boolean child;
    protected boolean senior;

    public Ride(String rideName, int amount, String startTime, String endTime, boolean adult, boolean child, boolean senior) {
        this.rideName = rideName;
        this.amount = amount;
        this.startTime = startTime;
        this.endTime = endTime;
        this.adult = adult;
        this.child = child;
        this.senior = senior;
    }

    public Ride(){

    }

    public String getRideName(){
        return this.rideName;
    }
    @Override
    public String toString() {
        return "Ride { " +
                " rideName = '" + rideName + '\'' +
                ", amount = " + amount +
                ", startTime = '" + startTime + '\'' +
                ", endTime = '" + endTime + '\'' +
                ", adult = " + adult +
                ", child = " + child +
                ", senior = " + senior +
                "}";
    }

}
