import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String pass = "subham45";

        String sql = "INSERT INTO students (name, email) VALUES (?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Shubham");
            ps.setString(2, "shubham@gmail.com");

            int rows = ps.executeUpdate();
            System.out.println(rows + " record inserted");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}