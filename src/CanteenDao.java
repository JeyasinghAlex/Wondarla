import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CanteenDao {

    private static CanteenDao dao = new CanteenDao();
    private CanteenDao(){

    }

    public static CanteenDao getCanteenDaoInstance(){
        return dao;
    }


    public  void insertCanteenDetails(int visitor_id, int selected_food, int order_quantity, int totalPrice){
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

    public int getCanteenEarning(){

        String query = "select sum(price) from order_details";
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
