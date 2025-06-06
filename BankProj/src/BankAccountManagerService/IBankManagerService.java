package BankAccountManagerService;

import Models.BankAccount;

public interface IBankManagerService {
    boolean ManagerLogin(String username, String password);
    void AddAccount(BankAccount model);
    void UpdateAccount(BankAccount model, String flag);
    void DeleteAccount(String accNumber);
    void ViewAllUsers();

    BankAccount GetUserByAccNo(String accNo);
    void ViewFilteredUser(String filter1);
    void FilterUsersByBalance(int maxAmount);
    void GetAllNamesOfUsers();
}
