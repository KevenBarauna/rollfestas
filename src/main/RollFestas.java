/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Jan Cloude
 */
public class RollFestas extends Application {
    
    @Override
    public void start(Stage primaryStage) {
               primaryStage.setTitle("RollFestas");
       
        //stage.getIcons().add(new Image("file:icoKP3.png"));
        AplicacaoUtil.getInstancia().setTelaAtual(primaryStage);
        AplicacaoUtil.getInstancia().irParaTela("LoginFXML.fxml");
            }
   
   
    public static void main(String[] args) {
        launch(args);
    }
    
}
