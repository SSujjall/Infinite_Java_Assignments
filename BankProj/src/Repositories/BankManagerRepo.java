package Repositories;
import Db.H2DbSingleton;
import Models.BankAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankManagerRepo {
    H2DbSingleton db = H2DbSingleton.getInstance();
    Connection conn = db.getConnection();

    public void AddAccountToDb(BankAccount model) {
        String sql = "INSERT INTO bank_accounts(account_number, account_holder_name, balance) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, model.GetAccountNumber());
            ps.setString(2, model.GetAccountHolderName());
            ps.setDouble(3, model.GetBalance());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BankAccount> GetAllAccountsFromDb() {
        List<BankAccount> list = new ArrayList<>();
        String sql = "SELECT * FROM bank_accounts";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new BankAccount(
                    rs.getString("account_number"),
                    rs.getString("account_holder_name"),
                    rs.getDouble("balance")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public BankAccount GetAccByAccNo(String accNo) {
        String sql = "SELECT * FROM bank_accounts WHERE account_number = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new BankAccount(
                    rs.getString("account_number"),
                    rs.getString("account_holder_name"),
                    rs.getDouble("balance")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void UpdateAccInDb(BankAccount model) {
        String sql = "UPDATE bank_accounts SET account_holder_name = ?, balance = ? WHERE account_number = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, model.GetAccountHolderName());
            ps.setDouble(2, model.GetBalance());
            ps.setString(3, model.GetAccountNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BankAccount> GetFiltedrBankAccounts(String filter) {
        List<BankAccount> list = new ArrayList<>();
        String sql = "SELECT * FROM bank_accounts WHERE account_number LIKE ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, filter + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BankAccount(
                    rs.getString("account_number"),
                    rs.getString("account_holder_name"),
                    rs.getDouble("balance")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<BankAccount> GetAccountFilteredByBalance(int maxAmount) {
        List<BankAccount> list = new ArrayList<>();
        String sql = "SELECT * FROM bank_accounts WHERE balance <= ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, maxAmount);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BankAccount(
                    rs.getString("account_number"),
                    rs.getString("account_holder_name"),
                    rs.getDouble("balance")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> GetAllAccountHolderNames() {
        List<String> list = new ArrayList<>();
        String sql = "SELECT account_holder_name FROM bank_accounts";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getString("account_holder_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void DeleteAccountFromDb(String accNum) {
        String sql = "DELETE FROM bank_accounts WHERE account_number = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, accNum);
            st.executeUpdate();
            System.out.println("Account deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
