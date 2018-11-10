/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.xml.bind.DatatypeConverter;

/**
 * FXML Controller class
 *
 * @author Jan Cloude
 */
public class EventosFXMLController implements Initializable {
@FXML
    private DatePicker dtpDataEvento;

    @FXML
    private CheckBox cbFotoFilmagem;

    @FXML
    private Button btnEditarEvento;

    @FXML
    private Label lblvalortotal;

    @FXML
    private TextField txthoraEvento;

    @FXML
    private Button btnAdicionarEvento;

    @FXML
    private TextField txteditarevento;

    @FXML
    private TextField txtvalortotal;

    @FXML
    private TextField txtvalorpago;

    @FXML
    private Button btnDeletarEvento;

    @FXML
    private TextArea txtenderecoEvento;

    @FXML
    private CheckBox cbFoto;

    @FXML
    private Button btnInicio;

    @FXML
    private TextField txttelefoneEvento;

    @FXML
    private TextField txtnomeEvento;

    @FXML
    private TextField txtdeletarevento;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        @FXML
    void adicionarDados(ActionEvent event) {
        
        LocalDate date = dtpDataEvento.getValue();
            System.out.println(date);
    
 LocalDate ld = LocalDate.parse(date.toString());//Pegue a data do banco.
 ld.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println(ld);
    }
    
}
