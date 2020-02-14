import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class VisitorDAO {

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

    public static int getVisitorId(String name){
       // String query = "select * from visitors order by visitor_id DESC LIMIT 1";
        String query = "select * from visitors where visitor_name = 'alex'";
        try{
                PreparedStatement pstm  = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
                ResultSet rs = pstm.executeQuery();
              System.out.println(rs.getInt(1));
                return rs.getInt(1);
            }
        catch (Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static void insertTicketToVisitorRelation(int visitor_id, int ticket_id){
        String query = "insert into ticket_to_visitor_relation(visitor_id, ticket_id) values(?, ?)";
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
