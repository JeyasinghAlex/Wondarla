import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TicketDAO {

    public static void insertTicketDetails(String ticket_type){
        PreparedStatement pstmt = null;
        String query = "insert into tickets(ticket_type) values(?)";
        try{
            pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
            pstmt.setString(1, ticket_type);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Ticket Insert Query Successfully Executed");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static int getTicketId(){
        String query = "select * from tickets order by ticket_id DESC LIMIT 1";
        try{
                  ResultSet rs =  DataBaseConnection.getDbInstance().getConnection().prepareStatement(query).executeQuery();
                  if(rs.next())
                    return   rs.getInt(1);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
