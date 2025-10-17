import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try (Connection con = DBConnection.getConnection()) {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter book title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter author name: ");
                        String author = sc.nextLine();
                        PreparedStatement ps = con.prepareStatement("INSERT INTO books(title, author, status) VALUES (?, ?, 'AVAILABLE')");
                        ps.setString(1, title);
                        ps.setString(2, author);
                        ps.executeUpdate();
                        System.out.println("Book added successfully!");
                    }

                    case 2 -> {
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM books");
                        System.out.println("ID | Title | Author | Status");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4));
                        }
                    }

                    case 3 -> {
                        System.out.println("Exiting... Bye!");
                        System.exit(0);
                    }

                    default -> System.out.println("Invalid choice! Try again.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
