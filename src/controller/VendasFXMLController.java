//KEVEN
package controller;

import java.net.URL;
import java.time.Instant;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Vendas;
import model.VendasDAO;
import java.util.Date;
import java.text.SimpleDateFormat;
import model.UsuarioDAO;


public class VendasFXMLController implements Initializable {

    @FXML
    private Button btnDesconto;

    @FXML
    private Label lblTroco;

    @FXML
    private CheckBox cbDinheiro;

    @FXML
    private TextField txtValorDoProduto;

    @FXML
    private CheckBox CbCartaoDebito;

    @FXML
    private CheckBox CbCartaoCredito;

    @FXML
    private TextField txtPagamento;

    @FXML
    private ChoiceBox<?> selectProduto;

    @FXML
    private Button btnCancelarVenda;

    @FXML
    private Button btnConfirmarProduto;

    @FXML
    private Button btnDevolucao;

    @FXML
    private Button btninicio;

    @FXML
    private Label lblValorTotal;

    @FXML
    private Button btnEditarVenda;

    @FXML
    private Button btnFinalizarCompra;
    
    private VendasDAO vendasDao;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    private void exibirInformação(String informacao){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText(null);
        alert.setContentText(informacao);
        alert.showAndWait();
    }
   
    private void exibirErro(String erro){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText(null);
        alert.setContentText(erro);
        alert.showAndWait();
    }
    
     public void limparCampos(){
        txtPagamento.clear();
        txtValorDoProduto.clear();
        lblValorTotal.setText("R$:");
        lblTroco.setText("R$:");
        
    }
    
    
    //data, valor, tipo_pagamento
    @FXML
    void FinalizaCompra(ActionEvent event) {
        
        Vendas venda = new Vendas();

           venda.setValor(Double.parseDouble(lblValorTotal.getText()));
                      
            if (cbDinheiro.isSelected()){
            // Dinheiro
            venda.setTipo_pagamento("Dinheiro");
            }
            if (CbCartaoCredito.isSelected()){
            venda.setTipo_pagamento("Cartão de Crédito");
            }
            if (CbCartaoDebito.isSelected()){
            venda.setTipo_pagamento("Cartão de Débito");
            }
            
            Date data = new Date();
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy"); 
            formatador.format( data );
            
            venda.setData(data);
            
        try {
            vendasDao.adicionar(venda);
            exibirInformação("Venda cadastrada");
            limparCampos();
        } catch (Exception e) {
            e.printStackTrace();
            exibirErro("Ocorreu um erro ao cadastrar a venda");
        }

    }
    
    
    
      @FXML
    void CancelarCompra(ActionEvent event) {
        limparCampos();
        exibirInformação("Venda cancelada");
        
    }
    
    

    
}
