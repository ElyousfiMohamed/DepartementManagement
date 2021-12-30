/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ELYOUSFI
 */
public class ModifProfController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button save;
    @FXML
    private Button cancel;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField cin;
    @FXML
    private TextField adresse;
    @FXML
    private TextField email;
    @FXML
    private TextField tel;
    @FXML
    private TextField date;
    @FXML
    private TextField idDepart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) {
    }

    @FXML
    private void cancel(ActionEvent event) {
    }
    
}
