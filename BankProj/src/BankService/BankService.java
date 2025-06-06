package BankService;
import Models.BankAccount;
import Repositories.BankServiceRepo;

public class BankService implements IBankService {
    private final BankServiceRepo _repo;

    public BankService() {
        _repo = new BankServiceRepo();
    }


    @Override
    public void Deposit(String accNumber, double amount) {
        BankAccount user = _repo.GetUserByAccNo(accNumber);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        if (amount > 0) {
            user.SetBalance(user.GetBalance() + amount);

            // update changes in db
            _repo.DepositInDb(accNumber, amount);
            System.out.println("Deposited amount: " + amount);
        }
        else {
            System.out.println("Very low deposit amount! Must be greater than 0");
        }
    }

    @Override
    public void Withdraw(String accNumber, double amount) {
        BankAccount user = _repo.GetUserByAccNo(accNumber);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        if (amount > 0 && amount <= user.GetBalance()) {
            user.SetBalance(user.GetBalance() - amount);
            _repo.WithdrawInDb(accNumber, amount); // update changes in db
            System.out.println("Withdrawn: " + amount);
        }
        else {
            System.out.println("Balance not sufficient!!!");
        }
    }

    @Override
    public void DisplayAccountDetails(String accNumber) {
        BankAccount user = _repo.GetUserByAccNo(accNumber);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("\nAccount Holder Name: " + user.GetAccountHolderName());
        System.out.println("Account Number: " + user.GetAccountNumber());
        System.out.println("Balance: " + user.GetBalance());
    }

    @Override
    public BankAccount GetUserByAccNo(String accNo) {
        return _repo.GetUserByAccNo(accNo);
    }
}
