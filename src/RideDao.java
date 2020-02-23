import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RideDao {

    private static RideDao dao = new RideDao();
    private RideDao(){

    }
    public static  RideDao getRideDaoInstance(){
        return dao;
    }
    public  void insertRideDetails(int ride_id, float start_time, float end_time, boolean is_allow_adult, boolean is_allow_children, boolean is_allow_senior, int employee_id){
        String query = "insert into ride_details(ride_id, start_time, end_time, is_allow_adult, is_allow_children, is_allow_senior, employee_id) values (?, ?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
            pstmt.setInt(1, ride_id);
            pstmt.setFloat(2, start_time);
            pstmt.setFloat(3, end_time);
            pstmt.setBoolean(4, is_allow_adult);
            pstmt.setBoolean(5, is_allow_children);
            pstmt.setBoolean(6, is_allow_senior);
            pstmt.setInt(7, employee_id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Ride Insert Query Successfully Executed");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public  int insertNewGame(String game_name){
        String query = "insert into games(game_name) values (?)";

        try{
            PreparedStatement  pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, game_name);
            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }

        }catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public  void findRideToReadGame(float time){
        String query = "select * from ride_details";
        int gameId = 0;
        try{
            ResultSet rs = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query).executeQuery();
            while (rs.next()){
                gameId++;
                if(rs.getFloat(2) == time){
                    String qry = "select game_name from games inner join ride_details on games.game_id = ride_details.ride_id where game_id = ?";
                    PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(qry);
                    pstmt.setInt(1, gameId);
                    ResultSet resultSet = pstmt.executeQuery();
                    if(resultSet.next()){
                        String name = resultSet.getString(1);
                        System.out.println("--------- --  "+name +"  is Ready to Ride");
                    }
                }
                else if(rs.getFloat(3) == time){
                    ThemPark.rides.get(gameId-1).getOperator().setAvailable(false);
                    System.out.println("Now  "+ThemPark.rides.get(gameId-1).getOperator().getOperatorName() + " is free");
                }
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    public  int getEarningDetails(int game_id){
        String query = "select game_id, sum(visitor_paid_amount) from visitor_to_ride_details where game_id = ?  group by game_id";
        try{
            PreparedStatement pstmt = DataBaseConnection.getDbInstance().getConnection().prepareStatement(query);
            pstmt.setInt(1,game_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return rs.getInt(2);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
