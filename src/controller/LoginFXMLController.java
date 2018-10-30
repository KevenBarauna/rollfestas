
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.AplicacaoUtil;

/**
 * FXML Controller class
 *
 * @author Jan Cloude
 */
public class LoginFXMLController implements Initializable {
  
    @FXML
    private PasswordField pswSenha;

    @FXML
    private Button btnLogar;

    @FXML
    private TextField txtUsuario;

    //Loga através do clicar do botão
    @FXML
    void Logar(ActionEvent event) {
        
        if((txtUsuario.getText().equals("rollfestas")  && txtUsuario.getText() != null) &&
                (pswSenha.getText().equals("@admin") && pswSenha.getText() != null)){
            AplicacaoUtil.getInstancia().irParaTela("PrincipalFXML.fxml");
        }else{
           if(txtUsuario.getText().equals("") || pswSenha.getText().equals("")){
                AplicacaoUtil.getInstancia().adicionarMensagemSimples(Alert.AlertType.ERROR, "Campos em Branco, por favor verifique os campos!");
            }else{
               AplicacaoUtil.getInstancia().adicionarMensagemSimples(Alert.AlertType.ERROR, "Usuário não encontrado!");
            }
            
        }
        
        
        
    }
    
    //Loga se o usuario terminar de digitar a senha e pressionar o botão enter
@FXML
public void txtPressed(KeyEvent ke)
{
    if(ke.getCode() == KeyCode.ENTER)
    {
        if((txtUsuario.getText().equals("rollfestas")  && txtUsuario.getText() != null) &&
                (pswSenha.getText().equals("@admin") && pswSenha.getText() != null)){
            AplicacaoUtil.getInstancia().irParaTela("PrincipalFXML.fxml");
        } else{
           if(txtUsuario.getText().equals("") || pswSenha.getText().equals("")){
                AplicacaoUtil.getInstancia().adicionarMensagemSimples(Alert.AlertType.ERROR, "Campos em Branco, por favor verifique os campos!");
            }else{
               AplicacaoUtil.getInstancia().adicionarMensagemSimples(Alert.AlertType.ERROR, "Usuário não encontrado!");
            }
        }
    }
}

// Loga se o usuario navegar com tab e pressionar o botão logar com enter
@FXML
public void botaoPressed(KeyEvent ke)
{
    if(ke.getCode() == KeyCode.ENTER)
    {
        if((txtUsuario.getText().equals("rollfestas")  && txtUsuario.getText() != null) &&
                (pswSenha.getText().equals("@admin") && pswSenha.getText() != null)){
            AplicacaoUtil.getInstancia().irParaTela("PrincipalFXML.fxml");
        } else{
           if(txtUsuario.getText().equals("") || pswSenha.getText().equals("")){
                AplicacaoUtil.getInstancia().adicionarMensagemSimples(Alert.AlertType.ERROR, "Campos em Branco, por favor verifique os campos!");
            }else{
               AplicacaoUtil.getInstancia().adicionarMensagemSimples(Alert.AlertType.ERROR, "Usuário não encontrado!");
            }
        }
    }
}

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //colocando o usuário e senha assim que o programa roda, a nivel de testes, não é para ser
        //deixado assim para o cliente, não ignorar camada de segurança básica
        txtUsuario.setText("rollfestas");
        pswSenha.setText("@admin");
    }    
    
}
