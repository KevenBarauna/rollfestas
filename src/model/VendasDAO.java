//KEVEN
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import javax.xml.bind.ParseConversionEvent;

public class VendasDAO {
    /*
        /*
    CREATE TABLE "venda" (
	"id_venda" serial NOT NULL,
	"data" DATE NOT NULL,
	"valor" double NOT NULL,
	"tipo_pagamento" varchar(255) NOT NULL,
	"id_produto" bigint NOT NULL,
	CONSTRAINT venda_pk PRIMARY KEY ("id_venda")
    ) WITH (
    OIDS=FALSE
    );
     private Date data;
    private double valor;
    private String tipo_pagamento;
    */
    
    private Connection connection;

    public VendasDAO() {
        connection = new ConnectionFactory().getConnection();
    }
    
    
    
        public void cadastrar(Vendas vendas){
        String sql = "insert into venda (data, valor, tipo_pagamento) values (?,?,?)";
        
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setDate(1, (Date) vendas.getData());
            statement.setDouble(2, vendas.getValor());
            statement.setString(3, vendas.getTipo_pagamento());
       
            
            statement.execute();
            statement.close();
        } catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
        }
        
        }
        
        
        
        
        public void atualizar(Vendas vendas){
        String sql = "update venda set data=?, valor=?, tipo_pagamento=? where id_venda=?";
        
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setDate(1, (Date) vendas.getData());
            statement.setDouble(2, vendas.getValor());
            statement.setString(3, vendas.getTipo_pagamento());
            statement.setInt(4, vendas.getId_venda());
            
            statement.execute();
            statement.close();
        } catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
        }
    }
        
        
        
        
        public void deletar(Integer id_venda){
        String sql = "delete from venda where id_venda = ?";
        
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            statement.setInt(1, id_venda);
            
            statement.execute();
            statement.close();
        } catch (SQLException e) {
           e.printStackTrace();
           throw new RuntimeException(e);
        }
    }
     
        

        
        
        
    
}
