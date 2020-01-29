public class Ride {

    private String rideName;
    private int amount;
    private String startTime;
    private String endTime;
    private boolean adult;
    private boolean child;
    private boolean senior;

    public Ride(String rideName, int amount, String startTime, String endTime, boolean adult, boolean child, boolean senior) {
        this.rideName = rideName;
        this.amount = amount;
        this.startTime = startTime;
        this.endTime = endTime;
        this.adult = adult;
        this.child = child;
        this.senior = senior;
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
