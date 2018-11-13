/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lucian.alexandru
 */
public class DatabaseSingleton {
   
    private static Connection connection = null;
   
    public static synchronized Connection getConnection() {
        
        if (connection != null) {
            return connection;
        }
        
        connection = DatabaseUtils.createConnection();
        
        return connection;
    }
    
}
