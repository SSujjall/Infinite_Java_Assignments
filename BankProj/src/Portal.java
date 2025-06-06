/// THIS CODE IS REFACTORED TO 2 DIFFERENT FILES IN Portal: ManagerPorta and PublicPortal class

//import AccountService.AccountService;
//import AccountService.IAccountService;
//import BankAccountManagerService.BankManagerService;
//import BankAccountManagerService.IBankManagerService;
//import BankService.BankService;
//import BankService.IBankService;
//import Helper.Menu.PrintMenu;
//import Models.BankAccount;
//import java.util.Scanner;
//import java.util.UUID;
//
//public class Portal {
//    boolean isProgramRunning;
//    int choice;
//    IBankService bankService;
//    IBankManagerService managerService;
//    IAccountService accountService;
//    Scanner scanner;
//
//    // INIT
//    public Portal(){
//        bankService = new BankService();
//        managerService = new BankManagerService();
//        accountService = new AccountService();
//        scanner = new Scanner(System.in);
//    }
//
//    public void ManagerPortal(){
//        System.out.println("\nUsername: ");
//        String uname = scanner.nextLine();
//
//        System.out.println("\nPassword: ");
//        String pw = scanner.nextLine();
//
//        if (managerService.ManagerLogin(uname, pw)) {
//            isProgramRunning = true;
//
//            while (isProgramRunning) {
//                try {
//                    PrintMenu.PrintManagerMenu();
//                    choice = scanner.nextInt();
//
//                    // Choice Switch
//                    switch (choice) {
//                        case 1 -> {
//                            // Check if the account number is already used.
//                            // If already used then loop until a unused account number is input by user
//                            // TODO: Auto generate account number (GUID/UUID) -- DONE
//
////                        String accountNum;
////                        while (true) {
////                            System.out.println("Input account number: ");
////                            accountNum = scanner.next();
////
////                            if (accountService.CheckIfAccountExists(accountNum)){
////                                System.out.println("\nAccount Number Already used. Please use another account number.");
////                            } else {
////                                break;
////                            }
////                        }
//
//                            String accountNum = UUID.randomUUID().toString();
//
//                            System.out.println("Input account name: ");
//                            String accountName = scanner.next();
//                            double balance = 0.0;
//
//                            var newModel = new BankAccount(accountNum, accountName, balance);
//                            managerService.AddAccount(newModel);
//                        }
//                        case 2 -> {
//                            String accountNum;
//                            while (true) {
//                                System.out.println("Input account number: ");
//                                accountNum = scanner.next();
//                                if (!accountService.CheckIfAccountExists(accountNum)) {
//                                    System.out.println("\nAccount Number does not exist. Please enter a valid Aaccount number");
//                                } else {
//                                    break;
//                                }
//                            }
//
//                            var user = accountService.GetAccountById(accountNum);
//
//                            boolean isUMenuChoiceRunning = true;
//                            while (isUMenuChoiceRunning) {
//                                PrintMenu.PrintUpdateMenu();
//                                int uMenuChoice = scanner.nextInt();
//
//                                // uMenuChoice Switch
//                                switch (uMenuChoice) {
//                                    case 1 -> {
//                                        System.out.println("Input new Name: ");
//                                        String newName = scanner.next();
//                                        user.SetAccountHolderName(newName);
//                                        managerService.UpdateAccount(user, "un");
//                                    }
//                                    case 2 -> {
//                                        boolean isBalMenuChoiceRunning = true;
//                                        while (isBalMenuChoiceRunning) {
//                                            PrintMenu.PrintUpdateBalanceMenu();
//                                            int bMenuChoice = scanner.nextInt();
//
//                                            switch (bMenuChoice) {
//                                                case 1 -> {
//                                                    // add balance
//                                                    System.out.println("How much balance to add: ");
//                                                    double bal = scanner.nextDouble();
//                                                    user.SetBalance(bal);
//                                                    managerService.UpdateAccount(user, "uba");
//                                                }
//                                                case 2 -> {
//                                                    // remove balance
//                                                    System.out.println("How much balance to remove: ");
//                                                    double bal = scanner.nextDouble();
//                                                    user.SetBalance(bal);
//                                                    managerService.UpdateAccount(user, "ubr");
//                                                }
//                                                case 3 -> {
//                                                    isBalMenuChoiceRunning = false;
//                                                }
//                                                default -> {
//                                                    System.out.println("\nInvalid Choice");
//                                                }
//                                            }
//                                        }
//                                    }
//                                    case 3 -> {
//                                        isUMenuChoiceRunning = false;
//                                    }
//                                    default -> {
//                                        System.out.println("\nInvalid Choice");
//                                    }
//                                }
//                            }
//                        }
//                        case 3 -> {
//                            String accNum;
//                            while (true) {
//                                System.out.println("Input account number: ");
//                                accNum = scanner.next();
//
//                                if (!accountService.CheckIfAccountExists(accNum)){
//                                    System.out.println("\nAccount Number does not exist. Enter valid acc number.");
//                                } else {
//                                    break;
//                                }
//                            }
//
//                            managerService.DeleteAccount(accNum);
//                        }
//                        case 4 -> {
//                            managerService.ViewAllUsers();
//                        }
//                        case 5 -> {
//                            isProgramRunning = false;
//                        }
//                        default -> {
//                            System.out.println("\nInvalid Choice");
//                        }
//                    }
//                } catch (Exception e) {
//                    System.out.println("\nInvalid Input. Must be integers only");
//                } finally {
//                    scanner.nextLine();
//                }
//            }
//        } else {
//            System.out.println("\nIncorrect Username or Password");
//        }
//    }
//
//    public void PublicPortal() {
//        isProgramRunning = true;
//        String accNo;
//
//        while (isProgramRunning) {
//            System.out.println("Enter your account number: ");
//            accNo = scanner.next();
//
//            if (!accountService.CheckIfAccountExists(accNo)) {
//                System.out.println("Account does not exist;");
//                isProgramRunning = false;
//            } else {
//                boolean isPublicPortalRunning = true;
//                while (isPublicPortalRunning) {
//                    PrintMenu.PrintPublicMenu();
//                    choice = scanner.nextInt();
//
//                    // Public menu choice switch
//                    switch (choice) {
//                        case 1 -> {
//                            // view details
//                            bankService.DisplayAccountDetails(accNo);
//                        }
//                        case 2 -> {
//                            // DEPOSIT
//                            System.out.println("Amount to deposit: ");
//                            double amt = scanner.nextDouble();
//
//                            bankService.Deposit(accNo, amt);
//                        }
//                        case 3 -> {
//                            // WITHdraW
//                            System.out.println("Amount to withdraw: ");
//                            double amt = scanner.nextDouble();
//
//                            bankService.Withdraw(accNo, amt);
//                        }
//                        case 4 -> {
//                            isPublicPortalRunning = false;
//                            isProgramRunning = false;
//                        }
//                        default -> {
//                            System.out.println("\nInvalid Choice");
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
