import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VisitorDAO {

    public static void insertVisitorDetails(String visitor_name, String visitor_gender, String visitor_category, float visitor_time){
        String query = "insert into visitors (visitor_name, visitor_gender, visitor_category, visitor_time, visitor_credits)  values (?, ?, ?, ?, ?)";

        try{
                /** Create the mysql insert prepared statement*/
                PreparedStatement  pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
                 pstmt.setString(1,visitor_name);
                 pstmt.setString(2,visitor_gender);
                 pstmt.setString(3,visitor_category);
                 pstmt.setFloat(4,visitor_time);
                 pstmt.setInt(5,1000);
                 pstmt.executeUpdate();
                 System.out.println("Visitor Insert Query Successfully Executed");
                 //insertTicketToVisitorRelation();
            }catch (Exception ex){
                System.out.println(ex);
            }
    }

    public static int getVisitorId(){
        String query = "select * from visitors order by visitor_id DESC LIMIT 1";
        try{
            ResultSet rs =  DataBaseConnection.getDbInstance().getConnection().createStatement().executeQuery(query);
            if(rs.next())
                return rs.getInt(1);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static void insertTicketToVisitorRelation(){

        String query = "insert into ticket_to_visitor_relation(visitor_id, ticket_id) values(?, ?)";
        try{
            PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
            pstmt.setInt(1, VisitorDAO.getVisitorId());
            pstmt.setInt(2, TicketDAO.getTicketId());
            pstmt.executeUpdate();
            System.out.println("Query Insert Successfully");
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
