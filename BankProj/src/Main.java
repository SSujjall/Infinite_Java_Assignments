import Db.DbHelper;
import Helper.Menu.PrintMenu;
import Portals.ManagerPortal;
import Portals.PublicPortal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // DB INITIALIZE
        var dbHelper = new DbHelper();
        dbHelper.initDB();

        var scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            try {
                PrintMenu.PrintHomeMenu();
                int isManagerInput = scanner.nextInt();

                if (isManagerInput == 1) {
                    var portal = new ManagerPortal();
                    portal.StartManagerPortal();
                } else if(isManagerInput == 2) {
                    var portal = new PublicPortal();
                    portal.StartPublicPortal();
                } else if(isManagerInput == 3) {
                    System.out.println("Thankyou for using.");
                    isRunning = false;
                } else {
                    System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input. Must be integers only");
            } finally {
                // Clears invalid input
                // If this is not used, then the program is entering in infinite loop as the scanner is not being cleared and using the same invalid value.
                scanner.nextLine();
            }
        }
    }
}