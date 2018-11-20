
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
     private Connection connection;

    public UsuarioDAO() {
        connection = new ConnectionFactory().getConnection();
    }
    
    
    
    
    public void cadastrar(Usuario usuario){
        String sql = "insert into usuario (nome, login, senha) values (?,?,?)";
        
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getSenha());
       
            
            statement.execute();
            statement.close();
        } catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
        }
        
    }
    
     
    
     
      
     public void atualizar(Usuario usuario){
        String sql = "update usuario set nome=?, login=?, senha=? where id_usuario=?";
        
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getLogin());
            statement.setString(3, usuario.getSenha());
            statement.setInt(4, usuario.getIdUsuario());
            
            statement.execute();
            statement.close();
        } catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
        }
    }  
     
      public void deletar(Integer idUsuario){
        String sql = "delete from usuario where id_usuario = ?";
        
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setInt(1, idUsuario);
            
            statement.execute();
            statement.close();
        } catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
        }
    }
     
    public List<Usuario> consultar(String nomeUsuario){
      
        List<Usuario> usuarios = new ArrayList<>();
        
        String sql = "select * from usuario where nome like '%" + nomeUsuario + "%'";
        
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
              Usuario usuario = new Usuario();
              
              usuario.setIdUsuario(resultSet.getInt("id_usuario"));
              usuario.setNome(resultSet.getString("nome"));
              usuario.setLogin(resultSet.getString("login"));
              usuario.setSenha(resultSet.getString("senha"));
              usuarios.add(usuario);
            }
            
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
        }
        
        
        return usuarios;
    }
    
}
