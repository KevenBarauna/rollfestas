
package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
  private String url;
  private String usuario;
  private String senha;
  private Connection con;
  
  public Conexao(){
  url = "jdbc:postgresql://localhost:5432/rollfestas";
 usuario = "postgres";
senha = "teste";
    
    try {
         
          Class.forName("org.postgresql.Driver");
         con = DriverManager.getConnection(url,usuario,senha);
          System.out.println("Conexão Bem Sucedida");
         
    } catch (Exception e) {
      e.printStackTrace();
   }
  }
   
    
}
