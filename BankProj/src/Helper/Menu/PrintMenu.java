package Helper.Menu;

public class PrintMenu {
    public static void PrintHomeMenu() {
        System.out.println("\n********** WELCOME TO BLABLABLABLA **********");
        System.out.println("1. Access Manager Menu");
        System.out.println("2. Access Public Menu");
        System.out.println("3. Exit to Main Menu");
        System.out.println("Enter your choice: ");
    }

    public static void PrintManagerMenu() {
        System.out.println("\n********** MANAGER MENU **********");
        System.out.println("1. Add Account");
        System.out.println("2. Update Account Details");
        System.out.println("3. Delete Account");
        System.out.println("4. View All Users");
        System.out.println("5. View Filtered users");
        System.out.println("6. View Filtered user by balance");
        System.out.println("7. View all names of account holders");
        System.out.println("8. Exit to Main Menu");
        System.out.println("Enter your choice: ");
    }

    public static void PrintPublicMenu() {
        System.out.println("\n********** BANK MENU **********");
        System.out.println("1. Show Details");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit to Main Menu");
        System.out.println("Enter your choice: ");
    }

    public static void PrintUpdateMenu() {
        System.out.println("\n********** UPDATE ACCOUNT **********");
        System.out.println("1. Update Name");
        System.out.println("2. Update Balance");
        System.out.println("3. Go Back");
        System.out.println("Enter your choice: ");
    }

    public static void PrintUpdateBalanceMenu() {
        System.out.println("\n********** UPDATE ACCOUNT : BALANCE **********");
        System.out.println("1. Add Balance");
        System.out.println("2. Remove Balance");
        System.out.println("3. Go Back");
        System.out.println("Enter your choice: ");
    }
}
