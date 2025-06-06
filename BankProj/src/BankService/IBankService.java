package BankService;

import Models.BankAccount;

public interface IBankService {
    public void Deposit(String accNumber, double amount);
    public void Withdraw(String accNUmber, double amount);
    public void DisplayAccountDetails(String accNumber);
    BankAccount GetUserByAccNo(String accNo);
}
