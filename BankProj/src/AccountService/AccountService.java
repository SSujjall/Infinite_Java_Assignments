package AccountService;

import Global.GlobalUsersList;
import Models.BankAccount;

import java.util.HashMap;

public class AccountService implements IAccountService {
    // Get the singleton instance of userlist hashmap
    private HashMap<String, BankAccount> userList = GlobalUsersList.getInstance().getUserList();

    @Override
    public boolean CheckIfAccountExists(String accountNumber) {
        // CHeck if the account number is already used or not.
        if(userList.containsKey(accountNumber))
        {
            return true;
        }
        return false;
    }

    @Override
    public BankAccount GetAccountById(String accountNumber) {
        BankAccount user = userList.get(accountNumber);
        return user;
    }
}
