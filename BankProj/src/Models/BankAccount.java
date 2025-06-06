package Models;

public class BankAccount {
    private String AccountNumber;
    private String AccountHolderName;
    private double Balance;

    public BankAccount(String _accountNumber, String _accountHolderName, double _balance) {
        AccountNumber = _accountNumber;
        AccountHolderName = _accountHolderName;
        Balance = _balance;
    }

    public String GetAccountNumber() {
        return AccountNumber;
    }
    public String GetAccountHolderName() {
        return AccountHolderName;
    }
    public double GetBalance() {
        return Balance;
    }

    public void SetAccountNumber(String _accountNumber) {
        AccountNumber = _accountNumber;
    }
    public void SetAccountHolderName(String _accountHolderName) {
        AccountHolderName = _accountHolderName;
    }
    public void SetBalance(double _balance) {
        Balance = _balance;
    }

    // Override the toString() method to print the value in this format in BankManagerService's ViewAllUser Method
    @Override
    public String toString(){
        return "\nAccountNumber: " + AccountNumber +
                "\nName: " + AccountHolderName +
                "\nBalance: " + Balance;
    }
}
