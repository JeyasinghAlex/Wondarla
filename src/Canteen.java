import java.util.ArrayList;

public class Canteen {

   private  KallaPetti kallaPetti = new KallaPetti();
   private ArrayList<Server> servers = new ArrayList<>();
   public  ArrayList<Food> foods = new ArrayList<>();
   public Kitchen kitchen = new Kitchen();

   public void makeFood(){
        foods.add(new Briyani("Chicken", 120, 10));
        foods.add(new Kfc("Bucket Chicken", 270, 15));
        foods.add(new TamilFood("Rice", 90, 25));
        foods.add(new Chinese("Hot and Sour Soup", 50, 30));
        foods.add(new IceCream("cha-cho bar", 25, 150));
        foods.add(new CoolDring("Coca cola", 50, 50));
   }
   public void showMenuCard(){
       for (int food = 0; food < foods.size(); food++){
           System.out.println(food+1+") "+foods.get(food).toString());
       }
   }

   public void selectServer(){
       Server tempServer;
       for(int i = 0; i < servers.size(); i++){
           if(servers.get(i).getTips() < servers.get(i+1).getTips()){
               //tempServer =
           }
       }
   }

   public void orderItem(){
       System.out.println("Select the item - ");
       int item = GeneralUtil.getInstance().checkAndReturnValidInteger();
       String orderName = foods.get(item-1).getName();
       int price = foods.get(item-1).getPrice();
       System.out.print("Enter the number of Quantity - ");
       int quantity = GeneralUtil.getInstance().checkAndReturnValidInteger();
       if(quantity > foods.get(item-1).getQuantity())
           foods.get(item-1).setQuantity(kitchen.makeExtraItem(quantity));
       foods.get(item-1).takeQuantity(quantity);
      // kallaPetti.calculateMoney(price, quantity);
   }

   public void createServer(){
       servers.add(new Server("Mathen", 0));
       servers.add(new Server("Vignesh", 0));
       servers.add(new Server("Ebbu", 0));
       servers.add(new Server("Dharson", 0));
       servers.add(new Server("Luu", 0));
   }
}
