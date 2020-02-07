import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnection {

    private static Connection connection = null;
    private static DataBaseConnection dataBaseConnection = new DataBaseConnection();
    private DataBaseConnection(){

    }

    public static DataBaseConnection getDbInstance(){
        return dataBaseConnection;
    }

    public  Connection getConnection( ) {
        if(connection != null)
        try {
            String url = "jdbc:mysql://localhost/wonderla";
            String userName = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection Created");
            return connection;

        } catch (Exception ex) {
             //System.out.println(ex);
        }
        return null;
    }

    public void createStatement(){

    }
}

/*public void operateRide(Ride selectedRide){
        System.out.print("Enter your Ticket Number - ");
        int ticketNumber = GeneralUtil.getInstance().checkAndReturnValidInteger();
        Visitor visitor = ThemPark.getThemParkInstance().getTicketCounterInstance().searchVisitors(ticketNumber);
        if(visitor != null){
            Ticket ticket = visitor.getTicket();
            float visitorTime = ticket.getTime();
            String visitorCategory = ticket.getCategory();
            int rideStartingTime = selectedRide.getStartTime();
            int rideEndingTime = selectedRide.getEndTime();
            int actualRideAmount = selectedRide.getAmount();
            int premiumAmount = ticket.calculateMoney(actualRideAmount);
            int totalAmount = actualRideAmount + premiumAmount;
            if(visitorTime < rideEndingTime && selectedRide.getCategory(visitorCategory)){
                int returnedMoney = Visitor.getVisitorInstance(visitor, totalAmount);
                if(returnedMoney !=0){
                    // selectedRide.ticketCounter.recordBooks.add(new RideRecordBook(ticketNumber, ticket.getHolder()));
                    selectedRide.getTicketCounterInstance().setAmount(returnedMoney, selectedRide);
                    System.out.println("---------------Successfully Ride Completed--------------------");
                    ticket.setTime(rideStartingTime);
                } else
                    System.out.println("--------------- Ride cancelled--------------------");
            }else
                System.out.println("You are not eligible for the game or May be yours late");
        }else
            System.out.println("Wrong Ticket Number");
    }
}*/
