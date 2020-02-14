import java.sql.PreparedStatement;

public class CanteenDAO {

    public static void insertCanteenDetails(){
        String query = "insert into order_details (visitor_id, food_id, order_quantity, price) values (?, ?, ?,  ?)";
        try{
            PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);

        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public int getFoodId(int id){
        String query = "select * from food where id = ?";

        try{
            PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
            //pstmt.
        }catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
