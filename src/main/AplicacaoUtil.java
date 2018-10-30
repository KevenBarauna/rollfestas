
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
            System.out.println("Carrega o arquivo da tela desejada");
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/".concat(nomeTela)));
             Parent root = loader.load();
            
            System.out.println("Cria uma nova cena para a tela e adiciona no palco (telaAtual)");
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/src/stylesheet.css").toExternalForm());
            this.telaAtual.setScene(scene);
            this.telaAtual.centerOnScreen();
            System.out.println("Exibe o palco caso o mesmo não esteja sendo exibido");
            if(!this.telaAtual.isShowing()){
                this.telaAtual.show();
            }
        }catch(Exception e){
        	System.out.println("entrou no catch");
            System.err.println("Ocorreu um erro ao tentar navegar para tela: ".concat(nomeTela).concat(" ".concat(e.getMessage())));
            e.printStackTrace();
           //exibe uma mensagem caso a tela não tenha sido encontrada + erro original
        }
    }
    
    public void novaTela(String nomeTela) {
        try {
            System.out.println("Carrega o arquivo da tela desejada");
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/".concat(nomeTela)));
             Parent root = loader.load();
            
            System.out.println("Cria uma nova cena para a tela e adiciona no palco (telaAtual)");
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initOwner(telaAtual);//indica a tela pai para esta stage que será a filha
            stage.initModality(Modality.APPLICATION_MODAL);            
            stage.setScene(scene);
            
            System.out.println("Exibe o palco caso o mesmo não esteja sendo exibido");
           stage.showAndWait();
        }catch(Exception e){
        	System.out.println("entrou no catch");
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
