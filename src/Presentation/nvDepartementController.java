/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package presentation;

import Presentation.DepartementController;
import SchoolManagementIMetier.IMetier;
import SchoolManagementIMetier.IMetierImpt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import persistantClasse.Departement;

/**
 * FXML Controller class
 *
 * @author ELYOUSFI
 */
public class nvDepartementController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button save;
    @FXML
    private Button cancel;
    @FXML
    private TextField nom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) {
        try {
            IMetier metier = new IMetierImpt();
            Departement d = new Departement(this.nom.getText());
            metier.addDepartement(d);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage)rootPane.getScene().getWindow();
        stage.close();
    }
    
    
    
}
