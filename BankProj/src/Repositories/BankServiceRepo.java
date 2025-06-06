package Repositories;

import Db.DbHelper;
import Db.H2DbSingleton;
import Models.BankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankServiceRepo {
    H2DbSingleton db = H2DbSingleton.getInstance();
    Connection conn = db.getConnection();

    public BankAccount GetUserByAccNo(String accNo){
        String sql = "SELECT * FROM bank_accounts WHERE account_number = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
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

    public void DepositInDb(String accNumber, double amount) {
        String sql = "UPDATE bank_accounts SET balance = balance + ? WHERE account_number = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setString(2, accNumber);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void WithdrawInDb(String accNumber, double amount) {
        String sql = "UPDATE bank_accounts SET balance = balance - ? WHERE account_number = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setString(2, accNumber);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
