
import java.util.InputMismatchException;
import java.util.Scanner;

public class GeneralUtil {

    private static Scanner scan = new Scanner(System.in);
    private static GeneralUtil generalUtil = new GeneralUtil();
    private GeneralUtil() {

    }

    public static GeneralUtil getInstance() {
        return generalUtil;
    }

    public  String getString(){
        return scan.nextLine();
    }

    public int checkAndReturnValidInteger() {

        try {
               return Integer.parseInt(scan.nextLine());
        } catch (InputMismatchException ex){
            System.out.println("Type Of Exception is -" + ex);
            System.out.println("Plzz Enter Valid Input");
            System.out.println();
            System.out.println("Enter the Correct Value");
            checkAndReturnValidInteger();
        } catch (NumberFormatException ex){
            System.out.println("Type Of Exception - " + ex);
            System.out.println("Plzz Enter Valid Input");
            System.out.println();
            System.out.println("Enter the Correct Value");
             checkAndReturnValidInteger();
        }
        return scan.nextInt();
    }

    public boolean isAllowRide(){
        System.out.println("------------------------>  1)  Yes");
        System.out.println("------------------------>  2)  No");
        System.out.print("Enter the Option  - ");
        int option = GeneralUtil.getInstance().checkAndReturnValidInteger();
        if(option == 1)
            return true;
        else
            return false;
    }
}
