import java.util.ArrayList;
public class Canteen {

   private ArrayList<Server> servers = new ArrayList<>();
   private ArrayList<Food> foods = new ArrayList<>();
   private CanteenMoneyCollector moneyCollector = new CanteenMoneyCollector();

    public void createFood(){
        foods.add(new Food("Briyani",  130,  20));
        foods.add(new Food("Dhosa",  30,  30));
        foods.add(new Food("Rise",  90,  15));
        foods.add(new Food("Chicken Fry",  80,  10));
        foods.add(new Food("Parotta",  10,  50));
        createServer();
    }

   public void showMenuCard(){
        for (int i = 0; i < foods.size(); i++){
            System.out.println(i+1+")"+ foods.get(i).toString());
        }
        System.out.println();
        CanteenMain.showMain();
   }

   public void orderFood(Visitor visitor, Server server){
        if(visitor != null){
            System.out.print(" Which food you need ? - ");
            int food = GeneralUtil.getInstance().checkAndReturnValidInteger();
            System.out.print("Enter the number of Quantity - ");
            int quantity = GeneralUtil.getInstance().checkAndReturnValidInteger();

            if(quantity > foods.get(food-1).getQuantity()){
                foods.get(food-1).importQuantity(quantity);
                moneyCollector.importCharge((quantity * foods.get(food-1).getPrice()/100) * 10);
            }

            int price = foods.get(food-1).getPrice();
            if(visitor.getWallet() > (price * quantity)){
                moneyCollector.setAmount((price * quantity), server);
                visitor.setWallet(price * quantity);
                foods.get(food-1).setQuantity(quantity);
            }else{
                System.out.println("Insufficient Balance");
                showMenuCard();
            }
        }else{
            System.out.println("Invalid Ticket Number");
            CanteenMain.showMain();
        }
        Main.showMenu();
   }

   public Server selectServer(){
       Server tempServer;
       for(int i = 0; i < servers.size(); i++){
           for(int j = i+1; j < servers.size(); j++){
               if(servers.get(i).getTips() > servers.get(j).getTips()){
                   tempServer = servers.get(i);
                   servers.set(i, servers.get(j));
                   servers.set(j, tempServer);
               }
           }
       }
       return servers.get(0);
   }

   public void createServer(){
       servers.add(new Server("Santhosh", 0));
       servers.add(new Server("Ebbu", 0));
       servers.add(new Server("Luu", 0));
   }
}
