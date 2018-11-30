
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
    private Button btnUsuarios;

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
    private Button btnEventos;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    btnVendas.setDisable(false);
     btnProdutos.setDisable(false);
     btnEstudio.setDisable(false);
     btnEventos.setDisable(false);
     btnEncomendas.setDisable(false);
     btnCalcular.setDisable(false);
   //aqui deverá conter o nome de usuário se formos implementas usuários únicos para cada funcionário
     lblUsuario.setText("RollFestas"); //em vez de string usar Usuario.getName();
    }    
    
    
    @FXML
    void Deslogar(ActionEvent event) {
        AplicacaoUtil.getInstancia().irParaTela("LoginFXML.fxml");
    }
    
        @FXML
    void vaiParaCalculo(ActionEvent event) {
        AplicacaoUtil.getInstancia().novaTela("CalculosFXML.fxml");
    }
    
       @FXML
    void vaiParaEventos(ActionEvent event) {
    AplicacaoUtil.getInstancia().novaTela("EventosFXML.fxml");
    }
    
    @FXML
    void Sair(ActionEvent event) {
        System.exit(0);
    }
    
      @FXML
    void vaiParaUsuarios(ActionEvent event) {
        AplicacaoUtil.getInstancia().novaTela("UsuariosFXML.fxml");
    }
    
       @FXML
    void vaiParaVendas(ActionEvent event) {
        AplicacaoUtil.getInstancia().novaTela("VendasFXML.fxml");
    }
    
    
    
}
