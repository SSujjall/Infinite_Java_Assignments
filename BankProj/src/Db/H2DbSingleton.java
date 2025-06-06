package Db;
import java.sql.Connection;
import java.sql.DriverManager;

public class H2DbSingleton {
    // static instance for singleton class
    private static H2DbSingleton instance;

    private Connection conn;

    private static final String URL = "jdbc:h2:mem:./test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    // private const to prevent instantiation by other classes
    private H2DbSingleton() {
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Failed to connect to H2 database", e);
        }
    }

    // public method for providing access to the singleton instance
    public static H2DbSingleton getInstance() {
        if (instance == null) {
            synchronized (H2DbSingleton.class) {
                if (instance == null) {
                    instance = new H2DbSingleton();
                }
            }
        }
        return instance;
    }

    // Method to get the database connection
    public Connection getConnection() {
        return conn;
    }

//    // Creating singleton using Bill Pugh Singleton Design instead of double-checking instance with synchronized in the upper code
//    private static class SingletonHelper {
//        private static H2DbSingleton instance = new H2DbSingleton();
//    }
//
//    // public method for providing access to the singleton instance
//    public static H2DbSingleton getInstance() {
//        return SingletonHelper.instance;
//    }
//
//    // Method to get the database connection
//    public Connection getConnection() {
//        return conn;
//    }
}
