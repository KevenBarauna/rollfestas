
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.AplicacaoUtil;


public class PrincipalFXMLController implements Initializable {

    @FXML
    private Label lblUsuario;
    
    @FXML
    private Button btnDeslogar;
    
    @FXML
    private Button btnCalcular;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnVendas;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnEstudio;

    @FXML
    private Button btnEncomendas;

    @FXML
    private Button btnPagamentos;

    @FXML
    private Button btnEventos;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    btnVendas.setDisable(true);
     btnPagamentos.setDisable(true);
     btnProdutos.setDisable(true);
     btnEstudio.setDisable(true);
     btnEventos.setDisable(true);
     btnEncomendas.setDisable(true);
     btnCalcular.setDisable(true);
   //aqui deverá conter o nome de usuário se formos implementas usuários únicos para cada funcionário
     lblUsuario.setText("RollFestas"); //em vez de string usar Usuario.getName();
    }    
    
    
    @FXML
    void Deslogar(ActionEvent event) {
        AplicacaoUtil.getInstancia().irParaTela("LoginFXML.fxml");
    }
    
    @FXML
    void Sair(ActionEvent event) {
        System.exit(0);
    }
    
    
}
