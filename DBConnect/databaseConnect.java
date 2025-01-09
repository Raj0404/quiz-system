/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rajdi
 */
public class databaseConnect {
    public Connection dbc(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // System.out.println(con);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/questionsdb?autoReconnect=true&useSSL=false","root","Unity4ever");
            return con;
        }catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
    
}
