package Portals;

import AccountService.AccountService;
import AccountService.IAccountService;
import BankAccountManagerService.BankManagerService;
import BankAccountManagerService.IBankManagerService;
import Helper.Menu.PrintMenu;
import Models.BankAccount;

import java.util.Scanner;
import java.util.UUID;

public class ManagerPortal {
    boolean isProgramRunning;
    int choice;
    IBankManagerService managerService;
    IAccountService accountService;
    Scanner scanner;

    public ManagerPortal() {
        managerService = new BankManagerService();
        accountService = new AccountService();
        scanner = new Scanner(System.in);
    }

    public void StartManagerPortal(){
        System.out.println("\nUsername: ");
        String uname = scanner.nextLine();

        System.out.println("\nPassword: ");
        String pw = scanner.nextLine();

        if (managerService.ManagerLogin(uname, pw)) {
            isProgramRunning = true;

            while (isProgramRunning) {
                try {
                    PrintMenu.PrintManagerMenu();
                    choice = scanner.nextInt();

                    // Choice Switch
                    switch (choice) {
                        case 1 -> {
                            String accountNum;

                            System.out.println("Account Type: \n1: Current \n2: Saving");
                            int accType = scanner.nextInt();

                            // Check account type input
                            if (accType == 1) {
                                accountNum = "1220" + UUID.randomUUID().toString();
                            }else if (accType == 2){
                                accountNum = "1330" + UUID.randomUUID().toString();
                            } else {
                                System.out.println("incorrect acc type");
                                continue;
                            }

                            System.out.println("Input account name: ");
                            String accountName = scanner.next();
                            double balance = 0.0;

                            var newModel = new BankAccount(accountNum, accountName, balance);
                            managerService.AddAccount(newModel);
                        }
                        case 2 -> {
                            System.out.println("Input account number: ");
                            String accountNum = scanner.next();

//                            var user = accountService.GetAccountById(accountNum);
                            var user = managerService.GetUserByAccNo(accountNum);

                            boolean isUMenuChoiceRunning = true;
                            while (isUMenuChoiceRunning) {
                                PrintMenu.PrintUpdateMenu();
                                int uMenuChoice = scanner.nextInt();

                                // uMenuChoice Switch
                                switch (uMenuChoice) {
                                    case 1 -> {
                                        System.out.println("Input new Name: ");
                                        scanner.nextLine(); // clear buffer, error dirako thyo yo nahaleko bela, "" pathairako thyo automatic in the newName variable below.
                                        String newName = scanner.nextLine();

                                        if (newName.isEmpty() || newName.isBlank()) {
                                            System.out.println("NAme cannot be blank");
                                            continue;
                                        }
                                        user.SetAccountHolderName(newName);
                                        managerService.UpdateAccount(user, "un");
                                    }
                                    case 2 -> {
                                        boolean isBalMenuChoiceRunning = true;
                                        while (isBalMenuChoiceRunning) {
                                            PrintMenu.PrintUpdateBalanceMenu();
                                            int bMenuChoice = scanner.nextInt();

                                            switch (bMenuChoice) {
                                                case 1 -> {
                                                    // add balance
                                                    System.out.println("How much balance to add: ");
                                                    double bal = scanner.nextDouble();
                                                    user.SetBalance(bal);
                                                    managerService.UpdateAccount(user, "uba");
                                                }
                                                case 2 -> {
                                                    // remove balance
                                                    System.out.println("How much balance to remove: ");
                                                    double bal = scanner.nextDouble();
                                                    user.SetBalance(bal);
                                                    managerService.UpdateAccount(user, "ubr");
                                                }
                                                case 3 -> {
                                                    isBalMenuChoiceRunning = false;
                                                }
                                                default -> {
                                                    System.out.println("\nInvalid Choice");
                                                }
                                            }
                                        }
                                    }
                                    case 3 -> {
                                        isUMenuChoiceRunning = false;
                                    }
                                    default -> {
                                        System.out.println("\nInvalid Choice");
                                    }
                                }
                            }
                        }
                        case 3 -> {
                            String accNum;
                            while (true) {
                                System.out.println("Input account number: ");
                                accNum = scanner.next();

                                var user = managerService.GetUserByAccNo(accNum);
                                if (user == null){
                                    System.out.println("\nAccount Number does not exist. Enter valid acc number.");
                                } else {
                                    break;
                                }
                            }

                            managerService.DeleteAccount(accNum);
                        }
                        case 4 -> {
                            managerService.ViewAllUsers();
                        }
                        case 5 -> {
                            String filter;

                            System.out.println("1. View Current Accounts (Starting with 1220) \n2. View Saving Accounts Starting with 1330)");
                            int input = scanner.nextInt();
                            if (input == 1) {
                                filter = "1220";
                            } else if(input == 2) {
                                filter = "1330";
                            } else {
                                System.out.println("Wrong input");
                                continue;
                            }

                            managerService.ViewFilteredUser(filter);
                        }
                        case 6 -> {
                            System.out.println("Enter max number you want to filter by: ");
                            int input = scanner.nextInt();
                            managerService.FilterUsersByBalance(input);
                        }
                        case 7 -> {
                            managerService.GetAllNamesOfUsers();
                        }
                        case 8 -> {
                            isProgramRunning = false;
                        }
                        default -> {
                            System.out.println("\nInvalid Choice");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("\nException. Check Stack.");
                } finally {
                    scanner.nextLine();
                }
            }
        } else {
            System.out.println("\nIncorrect Username or Password");
        }
    }
}
