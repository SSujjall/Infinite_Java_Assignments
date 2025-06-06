package AccountService;

import Models.BankAccount;

public interface IAccountService {
    boolean CheckIfAccountExists(String accountNumber);
    BankAccount GetAccountById(String accountNumber);
}
