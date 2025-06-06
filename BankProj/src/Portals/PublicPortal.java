package Portals;
import AccountService.AccountService;
import AccountService.IAccountService;
import BankService.BankService;
import BankService.IBankService;
import Helper.Menu.PrintMenu;
import Models.BankAccount;

import java.util.Scanner;

public class PublicPortal {
    boolean isProgramRunning;
    int choice;
    IBankService bankService;
    IAccountService accountService;
    Scanner scanner;

    public PublicPortal() {
        bankService = new BankService();
        accountService = new AccountService();
        scanner = new Scanner(System.in);
    }

    public void StartPublicPortal() {
        isProgramRunning = true;
        String accNo;

        while (isProgramRunning) {
            System.out.println("Enter your account number: ");
            accNo = scanner.next();

            BankAccount user = bankService.GetUserByAccNo(accNo);

            if (user == null) {
                System.out.println("Account does not exist;");
                isProgramRunning = false;
            } else {
                boolean isPublicPortalRunning = true;
                while (isPublicPortalRunning) {
                    PrintMenu.PrintPublicMenu();
                    choice = scanner.nextInt();

                    // Public menu choice switch
                    switch (choice) {
                        case 1 -> {
                            // view details
                            bankService.DisplayAccountDetails(accNo);
                        }
                        case 2 -> {
                            // DEPOSIT
                            System.out.println("Amount to deposit: ");
                            double amt = scanner.nextDouble();

                            bankService.Deposit(accNo, amt);
                        }
                        case 3 -> {
                            // WITHdraW
                            System.out.println("Amount to withdraw: ");
                            double amt = scanner.nextDouble();

                            bankService.Withdraw(accNo, amt);
                        }
                        case 4 -> {
                            isPublicPortalRunning = false;
                            isProgramRunning = false;
                        }
                        default -> {
                            System.out.println("\nInvalid Choice");
                        }
                    }
                }
            }
        }
    }
}
