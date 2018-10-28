
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roungureanu
 */
public class DatabaseUtils {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5432/java_lab4";

   //  Database credentials
   static final String USER = "postgres";
   static final String PASS = "";
   
   public static void connect() throws SQLException
   {
       Connection conn = null;
       Statement stmt = null;
       
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT id, name FROM teachers";
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("id");
         String name = rs.getString("name");

         //Display values
         System.out.print("!!!!!!! ID: " + id);
         System.out.print(", Name: " + name);
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }
}