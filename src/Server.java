
public class Server {

      private String name;
      private int tips;

      public Server(String name, int tips) {
            this.name = name;
            this.tips = tips;
      }

      public String getName() {
            return name;
      }

      public void setTips(int tips) {
            this.tips += tips;
      }

      public int getTips() {
            return tips;
      }
}
