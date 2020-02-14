import java.util.ArrayList;
public class Canteen {

   private ArrayList<Server> servers = new ArrayList<>();
   private ArrayList<Food> foods = new ArrayList<>();
   private CanteenMoneyCollector moneyCollector = new CanteenMoneyCollector();

    public void createFood(){
        foods.add(new Food("Briyani",  130,  20));
        foods.add(new Food("Dhosa",  30,  30));
        foods.add(new Food("Rice",  90,  15));
        foods.add(new Food("Chicken Fry",  80,  10));
        foods.add(new Food("Parotta",  10,  50));
        createServer();
    }

    public CanteenMoneyCollector getCanteenMoneyCollector(){
        return  moneyCollector;
    }

     public void orderFood(Server server){
       System.out.print("Enter your Ticket Number - ");
       int ticketNumber = GeneralUtil.getInstance().checkAndReturnValidInteger();
       Visitor visitor = ThemPark.getThemParkInstance().getTicketCounterInstance().searchVisitors(ticketNumber);

       if(visitor != null){
           for (int i = 0; i < foods.size(); i++){
               System.out.println(i+1+")"+ foods.get(i).toString());
           }
            System.out.print(" Which food you need ? - ");
            int food = GeneralUtil.getInstance().checkAndReturnValidInteger();
            System.out.print("Enter the number of Quantity - ");
            int quantity = GeneralUtil.getInstance().checkAndReturnValidInteger();

            if(quantity > foods.get(food-1).getQuantity()){
                System.out.println("Food is not Enough......plzz wait few minutes");
                foods.get(food-1).importQuantity(quantity+10);
                moneyCollector.importCharge((quantity * foods.get(food-1).getPrice()/100) * 10);
            }

            int price = foods.get(food-1).getPrice();
            //int amount = Visitor.getVisitorInstance(visitor, (price * quantity));
            if(visitor.setWallet(price*quantity)){
                FoodDAO.insertOrderDetails(quantity, price);
                moneyCollector.setAmount(price*quantity, server);
                foods.get(food-1).setQuantity(quantity);
                CanteenDAO.insertCanteenDetails();
            }
            }else{
           System.out.println("Wrong Ticket Number");
       }
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
       servers.add(new Server("alex", 0));
       servers.add(new Server("sparrow", 0));
       servers.add(new Server("Luu", 0));
   }
}
