package StudentDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class StudentDB_Connect {
    public String StudentDB_Details(String Query, String Attribute) {
        String RecievedData = "null";
        try {
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con;
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionsdb?autoReconnect=true&useSSL=false","root","UseYourPassword");
            System.out.println("connected");
            Statement stmt = con.createStatement();
            String s = Query;
            ResultSet rset = stmt.executeQuery(s);
            String a = Attribute;
            while (rset.next()) {
                RecievedData = rset.getString(a);
            }
            stmt.close();
            con.close();
            // return RecievedData;
        } catch (Exception e) {
            e.printStackTrace();
            // return RecievedData;
        }
        return RecievedData;
    }
}
