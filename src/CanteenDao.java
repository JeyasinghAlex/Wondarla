import java.sql.PreparedStatement;

public class CanteenDao {

    public static void insertCanteenDetails(int visitor_id, int selected_food, int order_quantity, int totalPrice){
        String query = "insert into order_details (visitor_id, food_id, order_quantity, price) values (?, ?, ?,  ?)";
        try{
            PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
            pstmt.setInt(1, visitor_id);
            pstmt.setInt(2, selected_food);
            pstmt.setInt(3, order_quantity);
            pstmt.setInt(4, totalPrice);
            pstmt.execute();
            System.out.println("Order Insert Query Successfully Executed");

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
