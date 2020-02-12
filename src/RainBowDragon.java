public class RainBowDragon extends Ride{

    public RainBowDragon(String rideName, int amount, int startTime, int endTime, boolean adult, boolean children, boolean senior, TicketCounter ticketCounter, Operator operator) {
        super(rideName, amount, startTime, endTime, adult, children, senior, ticketCounter, operator);
    }

    @Override
    public String getRideName() {
        return ThemeParkConstants.Game.RAINBOW_DRAGON;
    }
}
