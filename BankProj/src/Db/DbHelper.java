package Db;

import BankAccountManagerService.BankManagerService;
import Models.BankAccount;
import Repositories.BankManagerRepo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class DbHelper {
//    private static Connection conn;
//
//
//    // TODO: MAKE THIS A SINGLETON AND USE SINGLE INSTANCE FOR DB CONNECTION
//    public static Connection GetConnection() throws SQLException {
//        if(conn == null || conn.isClosed()) {
//            conn = DriverManager.getConnection("jdbc:h2:mem:test", "sa", "");
//        }
//        return conn;
//    }

    H2DbSingleton db = H2DbSingleton.getInstance();
    Connection conn = db.getConnection();

    public void initDB() {
        String sqlQuery = """
            CREATE TABLE IF NOT EXISTS bank_accounts (
                account_number VARCHAR(255) PRIMARY KEY,
                account_holder_name VARCHAR(255),
                balance DOUBLE
            )
            """;

        try (Statement st = conn.createStatement()) {
            st.execute(sqlQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        String[] namesForCurentAccountHolders = {
            "Alice", "Bob", "Charlie", "Diana", "Ethan",
            "Fiona", "George", "Hannah", "Ian", "Julia"
        };

        String[] namesForSavingAccountHolders = {
            "Kevin", "Laura", "Michael", "Nina", "Oliver",
            "Paula", "Quinn", "Rachel", "Steve", "Tina"
        };

        var service = new BankManagerService();
        for (String name : namesForCurentAccountHolders) {
            BankAccount model = new BankAccount("1330"+ UUID.randomUUID(), name, 0);
            service.AddAccount(model);
        }

        for (String name : namesForSavingAccountHolders) {
            BankAccount model = new BankAccount("1220"+ UUID.randomUUID(), name, 0);
            service.AddAccount(model);
        }
    }
}
