import java.sql.PreparedStatement;

public class FoodDao {

    public static void insertOrderDetails(int order_quantity, int price){
            String query = "insert into order_details(food_id, visitor_id, order_quantity, price) values (?, ?, ?, ?)";

            try{
                PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);

            }catch(Exception ex){
                System.out.println(ex);
            }
    }
}
