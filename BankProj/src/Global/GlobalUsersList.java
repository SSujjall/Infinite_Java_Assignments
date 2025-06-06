package Global;

import Models.BankAccount;

import java.util.HashMap;

public class GlobalUsersList {
    private static GlobalUsersList instance;
    private final HashMap<String, BankAccount> userList;

    private GlobalUsersList() {
        userList = new HashMap<>();
    }

    public static GlobalUsersList getInstance() {
        if (instance == null) {
            instance = new GlobalUsersList();
        }
        return instance;
    }

    public HashMap<String, BankAccount> getUserList() {
        return userList;
    }
}
