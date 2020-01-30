import java.util.ArrayList;

public class Server {

      private String name;
      private int tips;
      ArrayList<Food> orders = new ArrayList<>();

      public Server(String name, int tips) {
            this.name = name;
            this.tips = tips;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public void setTips(int tips) {
            this.tips = tips;
      }

      public int getTips() {
            return tips;
      }
}
