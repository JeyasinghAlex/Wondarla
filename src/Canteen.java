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
            System.out.println(foods.get(i).toString());
        }
        CanteenMain.showMain();
   }

   public void orderFood(Visitor visitor){
        if(visitor != null){
            System.out.print("Enter your Option - ");
            int food = GeneralUtil.getInstance().checkAndReturnValidInteger();
            System.out.print("Enter the number of Quantity - ");
            int quantity = GeneralUtil.getInstance().checkAndReturnValidInteger();
//            if(quantity > foods.get(food-1).getQuantity())
//                foods.get(food-1).
            int price = foods.get(food-1).getPrice();
            if(visitor.getWallet() > (price * quantity)){
                moneyCollector.setAmount(price * quantity);
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
   }

   public Server selectServer(){
       Server tempServer;
       Server orderServer;
       for(int i = 0; i < servers.size(); i++){
           if(servers.get(i).getTips() < servers.get(i+1).getTips()){
               for(int j = i+1; j < servers.size(); j++){
                   if(servers.get(i).getTips() < servers.get(j).getTips()){
                       tempServer = servers.get(i);
                       servers.set(i, servers.get(i+1));
                       servers.set(i+1, tempServer);
                   }
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
