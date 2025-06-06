package BankAccountManagerService;
import Models.BankAccount;
import Repositories.BankManagerRepo;
import java.util.List;

public class BankManagerService implements IBankManagerService{
    private final BankManagerRepo _repo;

    public BankManagerService() {
        _repo = new BankManagerRepo();
    }


    @Override
    public boolean ManagerLogin(String username, String password) {
        if ("admin".equalsIgnoreCase(username) && "admin".equalsIgnoreCase(password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void AddAccount(BankAccount model) {
        _repo.AddAccountToDb(model);
        System.out.println("User account created with acc number " + model.GetAccountNumber());
    }

    @Override
    public void UpdateAccount(BankAccount model, String flag) {
        String accNo = model.GetAccountNumber();
        BankAccount existingAccount = _repo.GetAccByAccNo(accNo);

        if (existingAccount == null) {
            System.out.println("Account not found.");
            return;
        }

        switch (flag) {
            /// flags
            //un = update name
            //uba = update balance add
            //ubr = update balance remove
            case "un" -> {
                existingAccount.SetAccountHolderName(model.GetAccountHolderName());
                System.out.println("Account name succesfully updated");
            }
            case "uba" -> {
                existingAccount.SetBalance(existingAccount.GetBalance() + model.GetBalance());
                System.out.println("Balance added successfully");
            }
            case "ubr" -> {
                existingAccount.SetBalance(existingAccount.GetBalance() - model.GetBalance());
                System.out.println("Balance removed successfully");
            }
            default -> {
                System.out.println("Wrong Flag.");
                return; // if flag is null, then dont save in the db
            }
        }

        // saving changes to db
        _repo.UpdateAccInDb(existingAccount);
    }

    @Override
    public void DeleteAccount(String accNumber) {
//        userList.remove(accNumber);
        _repo.DeleteAccountFromDb(accNumber);
    }

    @Override
    public void ViewAllUsers() {
//        var list = new ArrayList<>(userList.values());
//        if (list.isEmpty()){
//            System.out.println("\nNo users to diplay");
//        } else {
////            System.out.print(""); // just a whitespace to make it a little clear in cli
////            for (BankAccount x : list) {
////                System.out.println(x);
////            }
//
//            // using stream
//            list.stream()
//                    .sorted((a,b) -> a.GetAccountHolderName().compareToIgnoreCase(b.GetAccountHolderName()))
//                    .forEach(System.out::println);
//        }

        var list = _repo.GetAllAccountsFromDb();
        var collectedList = list.stream()
                .toList();
        collectedList.forEach(System.out::println);
    }

    @Override
    public BankAccount GetUserByAccNo(String accNo) {
        return _repo.GetAccByAccNo(accNo);
    }

    @Override
    public void ViewFilteredUser(String filter) {
        var list = _repo.GetAllAccountsFromDb();
        var collectedList = list.stream()
                            .filter(x -> x.GetAccountNumber().contains(filter))
                            .toList();
        collectedList.forEach(System.out::println);
    }

    @Override
    public void FilterUsersByBalance(int maxAmount) {
//        var filteredList = _repo.GetAccountFilteredByBalance(maxAmount);
//        for (BankAccount acc : filteredList) {
//            System.out.println(acc);
//        }

        var list = _repo.GetAllAccountsFromDb();
        list.stream()
                .filter(x -> x.GetBalance() <= maxAmount)
                .toList()
                .forEach(System.out::println);
    }

    @Override
    public void GetAllNamesOfUsers() {
//        System.out.println("");
//        var listOfNames = _repo.GetAllAccountHolderNames();
//        int i = 1;
//        for (String name : listOfNames) {
//            System.out.println(i + "." + name);
//            i++;
//        }

        var list = _repo.GetAllAccountsFromDb();

        List<String> filteredList = list.stream()
                                        .map(BankAccount::GetAccountHolderName)
                                        //.map(a->a.GetAccountHolderName())
                                        .toList();

        filteredList.forEach(System.out::println);
    }
}
