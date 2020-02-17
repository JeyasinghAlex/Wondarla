import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorDao {

    public static int insertVisitorDetails(String visitor_name, String visitor_gender, String visitor_category, float visitor_time){
        String query = "insert into visitors (visitor_name, visitor_gender, visitor_category, visitor_time, visitor_credits)  values (?, ?, ?, ?, ?)";

        try{
                /** Create the mysql insert prepared statement*/
                PreparedStatement  pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1,visitor_name);
                pstmt.setString(2,visitor_gender);
                pstmt.setString(3,visitor_category);
                pstmt.setFloat(4,visitor_time);
                pstmt.setInt(5,1000);
                // int rowsAffected = pstmt.executeUpdate();
                pstmt.execute();
                System.out.println("Visitor Insert Query Successfully Executed");
                ResultSet rs = pstmt.getGeneratedKeys();
                if(rs.next()){
                return rs.getInt(1);
                }
                }catch (Exception ex){
                    System.out.println(ex);
                }
        return 0;
    }

    public static int getVisitorId(int ticketNumber){
       // String query = "select * from visitors order by visitor_id DESC LIMIT 1";
        //String query = "select * from visitors where visitor_name = 'alex'";
        String query = "select * from tickets where ticket_number = ?";
        try{
                PreparedStatement pstm  = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
                pstm.setInt(1, ticketNumber);
                ResultSet rs = pstm.executeQuery();
              System.out.println(rs.getInt(1));
                return rs.getInt(1);
            }
        catch (Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static void insertVisitorToTicketRelation(int visitor_id, int ticket_id){
        String query = "insert into visitor_to_ticket_relation(visitor_id, ticket_id) values(?, ?)";
        try{
            PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
            pstmt.setInt(1, visitor_id);
            pstmt.setInt(2, ticket_id);
           int rowsAffected =  pstmt.executeUpdate();
            System.out.println("Query Insert Successfully");
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public static void InsertVisitorToRideDetails(int visitor_id, int ride_id, float visitor_time, int visitor_paid_amount){
        String query = "insert into visitor_to_ride_details(visitor_id, game_id, visitor_time, visitor_paid_amount) values(?, ?, ?, ?) ";

        try{
            PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
            pstmt.setInt(1, visitor_id);
            pstmt.setInt(2, ride_id);
            pstmt.setFloat(3, visitor_time);
            pstmt.setInt(4, visitor_paid_amount);
            pstmt.execute();
            System.out.println("Insert Visitor To Ride Details Insert Query Successfully Executed");
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public static void getVisitorDetails(){
        String query = "select * from visitors";
        try{
            ResultSet rs = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query).executeQuery();
            while (rs.next()){
                String data = rs.getInt(1) + ":" + rs.getString(2) + ":" +rs.getString(3) + ":" + rs.getString(4) + ":" + rs.getFloat(5) + ":" + rs.getInt(6);
                System.out.println(data);
            }

        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
