public class ThemParkTime {

    private static ThemParkTime parkTime = new ThemParkTime();
    private ThemParkTime(){

    }
    public static ThemParkTime getParkTimeInstance(){
        return parkTime;
    }

    private static float time = 0;
    public void startThemParkTime(){

        new Thread( ()->
        {
            while (true){
                try {
                    Thread.sleep(60000);
                    if(++time > 24){
                        time = 1;
                        System.out.println("----------Next Day Started----------");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

     public float getThemParkTime(){
                return time;
    }
}

