import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL =
        "jdbc:mysql://127.0.0.1:3306/library_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "Vinu@2005"; // <-- your MySQL password

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✅ Database connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}

