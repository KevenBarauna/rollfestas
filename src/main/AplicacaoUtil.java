
package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AplicacaoUtil {
  
     //Instância única que será guardada
    private static AplicacaoUtil instancia = null;
    

    
    private Stage telaAtual = null;


    private AplicacaoUtil() {
        this.telaAtual = new Stage();
    }
    
    public static AplicacaoUtil getInstancia()
    {
        if(instancia == null){
            instancia = new AplicacaoUtil();
        }
        return instancia;
    }
    

    
    public void irParaTela(String nomeTela) {
        try {
            
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/".concat(nomeTela)));
             Parent root = loader.load();
            
          
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/src/stylesheet.css").toExternalForm());
            this.telaAtual.setScene(scene);
            this.telaAtual.centerOnScreen();
            
            if(!this.telaAtual.isShowing()){
                this.telaAtual.show();
            }
        }catch(Exception e){
       
            System.err.println("Ocorreu um erro ao tentar navegar para tela: ".concat(nomeTela).concat(" ".concat(e.getMessage())));
            e.printStackTrace();
           //exibe uma mensagem caso a tela não tenha sido encontrada + erro original
        }
    }
    
    public void novaTela(String nomeTela) {
        try {
            
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/".concat(nomeTela)));
             Parent root = loader.load();
           
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initOwner(telaAtual);//indica a tela pai para esta stage que será a filha
            stage.initModality(Modality.APPLICATION_MODAL); 
            stage.centerOnScreen();
            stage.setScene(scene);
            
           
           stage.showAndWait();
        }catch(Exception e){
        	
            System.err.println("Ocorreu um erro ao tentar navegar para tela: ".concat(nomeTela).concat(" ".concat(e.getMessage())));
            e.printStackTrace();
           //exibe uma mensagem caso a tela não tenha sido encontrada + erro original
        }
    }
    
     public void adicionarMensagemSimples(Alert.AlertType tipo , String mensagem){
         Alert alerta = new Alert(tipo, mensagem, ButtonType.CLOSE);
         alerta.show();
    }
  
    public void setTelaAtual(Stage telaAtual) {
        this.telaAtual = telaAtual;
    }

    public Stage getTelaAtual() {
        return telaAtual;
    }
    
    
    
    
}
