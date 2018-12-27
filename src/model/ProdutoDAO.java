
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {

     private Connection connection;
    
    public ProdutoDAO() {
        connection = new ConnectionFactory().getConnection();
    }
    
     public void cadastrar(Produto produto){
        String sql = "insert into produto (nome, preco, quantidade, tema) values (?,?,?,?)";
        
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setString(1, produto.getNome());
            statement.setFloat(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());
            statement.setString(4, produto.getTema());
       
            
            statement.execute();
            statement.close();
        } catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
        }
        
    }
    
    
    public List<Produto> buscarTodos(){
      
        List<Produto> produtos = new ArrayList<>();
        
        String sql = "select * from produto";
        
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
              Produto produto = new Produto();
              
             
              produto.setIdProduto(resultSet.getInt("id_produto"));
              produto.setNome(resultSet.getString("nome"));
              produto.setPreco(resultSet.getFloat("preco"));
              produto.setQuantidade(resultSet.getInt("quantidade"));
              produto.setTema(resultSet.getString("tema"));
              produtos.add(produto);
            }
            
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
        }
        
        
        return produtos;
    }
    
}
