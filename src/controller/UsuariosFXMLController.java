
package controller;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.Usuario;
import model.UsuarioDAO;


public class UsuariosFXMLController implements Initializable {

     @FXML
    private TextField txtLogin;

    @FXML
    private Button btnSalvar;

    @FXML
    private PasswordField pswSenha;

    @FXML
    private TableView<Usuario> tbUsuario;
    
    @FXML
    private TableColumn<Usuario, Integer> tbcId;
    
    @FXML
    private TableColumn<Usuario, String> tbcNome;
    
    @FXML
    private TableColumn<Usuario, String> tbcLogin;

    @FXML
    private Button btnCadastrar;
    
    @FXML
    private Button btnCancelar;

    @FXML
    private TextField txtNome;

    @FXML
    private Button btnExcluir;
    
    private Usuario usuarioSelecionado;
    
    private UsuarioDAO usuarioDao;

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        usuarioDao = new UsuarioDAO();
        
        tbcId.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        tbcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
         inicio();
    }
    
    public void inicio(){
        btnCadastrar.setDisable(false);
        btnSalvar.setDisable(true);
        btnExcluir.setDisable(true);
        btnCancelar.setDisable(true);
        preencheTabela(); 
        limparCampos();
    }

    @FXML
    void cadastrarUsuario(ActionEvent event) {
        Usuario usuario = new Usuario();
        usuario.setNome(txtNome.getText());
        usuario.setLogin(txtLogin.getText());
        usuario.setSenha(pswSenha.getText());
        
        try {
            usuarioDao.cadastrar(usuario);
            exibirInformação("Usuário cadastrado");
            inicio();
        } catch (Exception e) {
            e.printStackTrace();
            exibirErro("Ocorreu um erro ao cadastrar o usuário");
        }
    }
    
     @FXML
    void salvarUsuario(ActionEvent event) {
        usuarioSelecionado.setNome(txtNome.getText());
        usuarioSelecionado.setLogin(txtLogin.getText());
        usuarioSelecionado.setSenha(pswSenha.getText());

        try {
            usuarioDao.atualizar(usuarioSelecionado);
            exibirInformação("Usuário Atualizado com Sucesso");
            inicio();
            
        } catch (Exception e) {
            e.printStackTrace();
            exibirErro("Falha ao atualizar funcionário");
        }

    }
    
    

    @FXML
    void excluirUsuario(ActionEvent event) {

      if(tbUsuario.getSelectionModel().getSelectedItem() ==  null){
          exibirErro("Nenhum usuário foi selecionado");
    } else{
          if(exibirConfirmação("Deseja excluir este funcionário??")){
              try {
                  usuarioDao.deletar(tbUsuario.getSelectionModel().getSelectedItem().getIdUsuario());
                  exibirInformação("O usuário foi Excluído");
                  inicio();
              } catch (Exception e) {
                  exibirErro("Erro ao deletar o usuário");
                  e.printStackTrace();
              }
          }
      }
    }
    
    void preencheTabela() {

        try {
            List<Usuario> resultado = usuarioDao.consultar("");
            if(!resultado.isEmpty()){
              tbUsuario.setItems(FXCollections.observableList(resultado));
            } 
            
        } catch (Exception e) {
            exibirErro("Falha ao preencher tabela");
            e.printStackTrace();
        }
    }
    
    
    
    
      
    
    public void limparCampos(){
        txtLogin.clear();
        txtNome.clear();
        pswSenha.clear();
        
    }
    

        void atualizaCamposUsuario() {

        usuarioSelecionado = tbUsuario.getSelectionModel().getSelectedItem();
        
        if(usuarioSelecionado == null){
            
        }else{
            btnSalvar.setDisable(false);
            btnExcluir.setDisable(false);
            
            txtNome.setText(usuarioSelecionado.getNome());
            txtLogin.setText(usuarioSelecionado.getLogin());
            pswSenha.setText(usuarioSelecionado.getSenha());
            btnCadastrar.setDisable(true);
            btnCancelar.setDisable(false);
            
           
        }
          
        
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
    
    private Boolean exibirConfirmação(String confirmacao){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText(null);
        alert.setContentText(confirmacao);
        Optional<ButtonType> opcao = alert.showAndWait();
        if(opcao.get() == ButtonType.OK){
            return true;
        }else{
            return false;
        }
    }
    
     @FXML
    void desabilitaBotoes(MouseEvent event) {
        atualizaCamposUsuario();
    }
    
    @FXML
    void cancelar(ActionEvent event) {
        inicio();
        usuarioSelecionado = null;
    }
    
}
 