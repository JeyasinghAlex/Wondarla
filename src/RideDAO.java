import java.sql.PreparedStatement;

public class RideDAO {

    public static void insertRideDetails(String game_name, float start_time, float end_time, boolean is_allow_adult, boolean is_allow_children, boolean is_allow_senior){
        String query = "insert into game(game_name, start_time, end_time, is_allow_adult, is_allow_children, is_allow_senior) values (?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
            pstmt.setString(1, game_name);
            pstmt.setFloat(2, start_time);
            pstmt.setFloat(3, end_time);
            pstmt.setBoolean(4, is_allow_adult);
            pstmt.setBoolean(5, is_allow_children);
            pstmt.setBoolean(6, is_allow_senior);
            pstmt.executeUpdate();
            System.out.println("Ride Insert Query Successfully Executed");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
