
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    String url ="jdbc:postgresql://localhost:5432/rollfestas";
    String user="postgres" ;
    String password="teste" ;
    
    
    public Connection getConnection(){
        try {
            
             return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
       
    }
}
