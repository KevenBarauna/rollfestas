/*
Keven
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import main.AplicacaoUtil;

public class CalculosFXMLController implements Initializable {

    @FXML
    private Label lblQuantidade100x100;

    @FXML
    private CheckBox ckSemAcabamento;

    @FXML
    private CheckBox cbProfissional;

    @FXML
    private Label lblValorTotalBanner;

    @FXML
    private CheckBox ckChassis;

    @FXML
    private TextField txtbannerLargura;

    @FXML
    private TextField txta3Largura;
 
    @FXML
    private TextField txtbannerAltura;

    @FXML
    private Button btnCalcularBanner;

    @FXML
    private Button btnMetroCalcular;

    @FXML
    private Label lblQuantidade100x50;

    @FXML
    private TextField txta3Altura;

    @FXML
    private CheckBox cbFotoEstudio;

    @FXML
    private TextField txtmetroLargura;

    @FXML
    private Button btnInicio;

    @FXML
    private CheckBox cbIlhois;

    @FXML
    private Label lblA3Quantidade;

    @FXML
    private CheckBox cbVarinha;

    @FXML
    private TextField txtilhois;

    @FXML
    private TextField txtmetroAltura;

    @FXML
    private CheckBox cbAmador;
    
    @FXML
    private CheckBox cbcriararte;
    
    @FXML
    private CheckBox cbartepronta;

    @FXML
    private Button btnA3Calcular;
    
      private float valorfinal=0;//VARIAL QUE A A LABEL FINAL RECEBE DO BANNER
      private float l=0; //LARGURA BANNER
      private float a=0; // ALTURA BANNER
      private int i;//ILHOIS
      
      private int valorfinalint=0;//VARIAL QUE A A LABEL FINAL RECEBE
      private int larg=0; //LARGURA
      private int alt=0; // ALTURA
      
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
     
    @FXML
    void voltaInicio(ActionEvent event) {
        AplicacaoUtil.getInstancia().irParaTela("PrincipalFXML.fxml");
    }

    @FXML
    void CalclularA3(ActionEvent event) {
        larg= Integer.parseInt(txta3Largura.getText());
        alt= Integer.parseInt(txta3Altura.getText());
        larg=27/larg;
        alt=40/alt;
        valorfinalint=alt*larg;
        lblA3Quantidade.setText("Aproximadamente: " + valorfinalint);
     
    }

    @FXML
    void CalcularMetro(ActionEvent event) {
        l=Float.parseFloat(txtmetroLargura.getText());
        a=Float.parseFloat(txtmetroAltura.getText());
        l=98/l;
	a=98/a;
	valorfinal=a*l;
        lblQuantidade100x100.setText("Aproximadamente" + valorfinal);
        lblQuantidade100x50.setText("Aproximadamente:  " + valorfinal/2);
    }

    @FXML
    void CalcularBanner(ActionEvent event) {
        
        l=Float.parseFloat(txtbannerLargura.getText());
        a=Float.parseFloat(txtbannerAltura.getText());
        
        valorfinal = l*a;
        
        //AMADOR OU PROFISSIONAL
        if(cbAmador.isSelected()){
          valorfinal = valorfinal*70;
        }else
        if(cbProfissional.isSelected()){
          valorfinal = valorfinal*35;
        }  
        
        //ACABAMENTO
        if(ckChassis.isSelected()){
          valorfinal = valorfinal+45;
        }else
        if(cbVarinha.isSelected()){
          valorfinal = valorfinal+3;
        }else
        if(cbIlhois.isSelected()){
            i=Integer.parseInt(txtilhois.getText());
            valorfinal=(float) ((i*(0.60))+valorfinal);         
        }
        
        //FOTO ESTUDIO
        if(cbFotoEstudio.isSelected()){ 
          valorfinal = valorfinal+25;
        }
        
        //ARTE
        if(cbcriararte.isSelected()){ 
          valorfinal = valorfinal+25;
        }
        
        lblValorTotalBanner.setText("Valor Final: " + valorfinal);
        
    }
    
}
