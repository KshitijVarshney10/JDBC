import java.sql.*;
public class jdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
        Statement s=con.createStatement();
        ResultSet rs=s.executeQuery("select * from stu");
        while(rs.next()) {
            System.out.println(rs.getString(1)+" "+rs.getInt(2));
        }
    }
}
