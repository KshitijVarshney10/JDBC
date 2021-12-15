import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class pract {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/internal marks","root","");
        Statement s=con.createStatement();
        int phonenumber=0;
        String namep="";

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter strings:");
        String phone=sc.nextLine();
        String name=sc.nextLine();
        Pattern pp= Pattern.compile("\\b(0|91)?[6-9][0-9]{9}\\b");
        Matcher mp=pp.matcher(phone);
        Pattern pn=Pattern.compile("\\b(Aa)[A-Za-z]+\\b");
        Matcher mn=pn.matcher(name);

        while(mp.find() && mn.find()){
            phonenumber=Integer.parseInt(mp.group());
            namep=mn.group();
            s.executeQuery("insert into info(contact no,name) values (phonenumber,namep)");
        }
        ResultSet rs=s.executeQuery("select * from info");
        while(rs.next()){
            System.out.println(rs.getString(2)+"  "+rs.getInt(1));
        }

        System.out.println();
        con.close();
    }
}
