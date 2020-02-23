import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TicketDao {

    private static TicketDao ticketDao = new TicketDao();
    private TicketDao(){

    }
    public static TicketDao getTicketDaoInstance(){
        return ticketDao;
    }
    public  int insertTicketDetails(int ticket_number, String ticket_type){
        PreparedStatement pstmt = null;
        String query = "insert into tickets(ticket_number, ticket_type) values(?, ?)";
        try{
            pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, ticket_number);
            pstmt.setString(2, ticket_type);
            //int rowsAffected = pstmt.executeUpdate();
            pstmt.execute();
            System.out.println("Ticket Insert Query Successfully Executed");
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                return rs.getInt(1);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public  int getTicketId(int ticketNumber){
        //String query = "select * from tickets order by ticket_id DESC LIMIT 1";
        String query = "select visitor_id from visitor_to_ticket_relations where ticket_id = ?";
        try{
            PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
            pstmt.setInt(1, ticketNumber);
            pstmt.execute();

        }catch (Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public  int getTicketAmount(){
        String query = "select sum(ticket_amount) from tickets";
        try{
            ResultSet rs  = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query).executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
