import java.sql.*;
public class connection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
            System.out.println("Connection Success!");
        } catch (SQLException e) {
            System.out.println(e+"Connection Failed.");;
        }


        con.close();
    }
}
